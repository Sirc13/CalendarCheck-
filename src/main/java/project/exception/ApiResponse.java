package project.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse {
    @JsonProperty("status")
    private String status;
    @JsonProperty("dev_message")
    private String devMessage;
    @JsonProperty("user_message")
    private String userMessage;
}
