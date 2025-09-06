package project.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import project.ApiError;
import project.model.DataRequest;

import project.model.DataResponse;
import project.service.DataService;



@RestController
@RequestMapping("/api/data")
@RequiredArgsConstructor
@Tag(name = "Data Controller", description = "Controller about data")
public class DataController {
    private final DataService dataService;

    @Operation(
            summary = "Проверяет рабочий день или выходной",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Дата проверилась", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = DataResponse.class))
                    }
                    ),
                    @ApiResponse(responseCode = "400", description = "Неправильно заполнил", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))
                    }
                    ),
                    @ApiResponse(responseCode = "500", description = "Сервер это не обработал. Повторите пожалуйста.", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))
                    }
                    )
            }
    )
    @GetMapping("/work")
    public DataResponse getSuccessWorkedDay(@RequestBody DataRequest dataRequest) {
        return dataService.getSuccessWorkedDay(dataRequest);
    }
}
