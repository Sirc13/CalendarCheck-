package project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataRequest {
    @Schema(name = "data", example = "5.03.2025", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("data")
    private String data;
}