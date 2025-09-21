package project;

import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
public class ApiError {

    private String message;
    private int code;
}
