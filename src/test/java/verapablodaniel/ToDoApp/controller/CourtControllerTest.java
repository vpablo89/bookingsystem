package verapablodaniel.ToDoApp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import verapablodaniel.ToDoApp.persistence.entities.Court;
import verapablodaniel.ToDoApp.service.CourtService;
import verapablodaniel.ToDoApp.service.dto.CourtCreateDTO;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = CourtController.class, properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.datasource.username=sa",
        "spring.datasource.password=",
        "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect"
})
public class CourtControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CourtService courtService;

    @Test
    void createCourt_returnsCreatedCourt() throws Exception {
        CourtCreateDTO dto = new CourtCreateDTO();
        dto.setName("Court A");
        dto.setLocation("Location A");

        Court created = new Court("Court A", "Location A");
        created.setId(1L);

        when(courtService.createCourt(ArgumentMatchers.any(CourtCreateDTO.class))).thenReturn(created);

        mockMvc.perform(post("/courts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Court A"))
                .andExpect(jsonPath("$.location").value("Location A"));
    }

    @Test
    void getCourts_returnsCourtsList() throws Exception {
        Court c1 = new Court("Court A", "Location A");
        c1.setId(1L);
        Court c2 = new Court("Court B", "Location B");
        c2.setId(2L);

        when(courtService.getCourts()).thenReturn(List.of(c1, c2));

        mockMvc.perform(get("/courts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("Court A"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].name").value("Court B"));
    }
}

