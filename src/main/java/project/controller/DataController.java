package project.controller;


import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import project.model.DataRequest;

import project.model.DataResponse;
import project.service.DataService;

@RestController
@RequestMapping("/api/data")
@RequiredArgsConstructor
public class DataController {
    private final DataService dataService;
    @GetMapping("/work")
    public DataResponse getSuccessWorkedDay(DataRequest dataRequest) {
        return dataService.getSuccessWorkedDay(dataRequest);
    }
}
