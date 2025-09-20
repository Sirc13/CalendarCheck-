package project.exception.handler;


import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ServerErrorException;
import project.exception.ApiResponse;
import project.exception.BadRequest;
import project.exception.FilledInIncorrectly;

import java.rmi.ServerError;

@ControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<ApiResponse> handleBadRequestException(BadRequestException e) {
        return buildResponse(HttpStatus.BAD_REQUEST, "Некорректный запрос", e);
    }

    @ExceptionHandler(FilledInIncorrectly.class)
    public ResponseEntity<ApiResponse> handleFilledInIncorrectlyException(FilledInIncorrectly filledIn) {
        return buildResponse(HttpStatus.BAD_REQUEST, "Неправильно заполнил", filledIn);
    }

    @ExceptionHandler(ServerError.class)
    public ResponseEntity<ApiResponse> handleServerErrorException(ServerErrorException e) {
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Сервер это не обработал", e);
    }

    private ResponseEntity<ApiResponse> buildResponse(HttpStatus status, String message, Throwable throwable) {
        ApiResponse errorResponse = new ApiResponse(
                status.getReasonPhrase(),
                message,
                throwable.getMessage()
        );
        return ResponseEntity.status(status).body(errorResponse);
    }
}
