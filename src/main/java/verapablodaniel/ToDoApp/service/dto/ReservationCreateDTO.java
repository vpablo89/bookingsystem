package verapablodaniel.ToDoApp.service.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ReservationCreateDTO {

    @NotNull(message = "userId is required")
    private Long userId;
    @NotNull(message = "courtId is required")
    private Long courtId;
    @NotNull(message = "startTime is required")
    private LocalDateTime startTime;
    @NotNull(message = "endTime is required")
    private LocalDateTime endTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourtId() {
        return courtId;
    }

    public void setCourtId(Long courtId) {
        this.courtId = courtId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}

