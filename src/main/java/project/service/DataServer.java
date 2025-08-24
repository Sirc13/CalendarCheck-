package project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.model.DataRequest;
import project.model.DataResponse;

@RequiredArgsConstructor
@Service

public class DataServer implements DataService{
    public DataResponse getSuccessWorkedDay(DataRequest request){
        return null;
    }
}
