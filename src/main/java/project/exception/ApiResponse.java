package project.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApiResponse {
    @JsonProperty("status")
    private String status;
    @JsonProperty("dev_message")
    private String devMessage;
    @JsonProperty("user_message")
    private String userMessage;
}
