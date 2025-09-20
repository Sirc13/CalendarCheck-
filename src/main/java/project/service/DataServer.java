package project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.model.*;
import project.repository.DataRepository;

@RequiredArgsConstructor
@Service

public class DataServer implements DataService{
    private final DataRepository dataRepository;

    public DataResponse getSuccessWorkedDay(DataRequest request){
        DataResponse response = new DataResponse();
        Data data = new Data();
        DataSetSuccess dataSetSuccess = new DataSetSuccess();
        DataCheck dataCheck = new DataCheck(dataRepository);
        DataParse dataParse = new DataParse();
        dataCheck.DataIncorrect(request);
        Time time =new Time(dataParse.getDay(dataCheck, request),
                dataParse.getMouth(dataCheck, request),
                dataParse.getYear(dataCheck, request));
        response.setSuccess(dataSetSuccess.getDataResponse(time));
        data.setData(request.getData());
        data.setAnswer(response.isSuccess());
        dataRepository.save(data);
        return response;
    }
}
