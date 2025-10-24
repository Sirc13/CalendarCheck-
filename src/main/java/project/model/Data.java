package project.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "data")
public class Data {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Schema(name = "data", example = "05.03.2025", requiredMode = Schema.RequiredMode.REQUIRED)
   private String data;
   @Schema(name = "answer", example = "true", requiredMode = Schema.RequiredMode.REQUIRED)
   private boolean answer;
}
