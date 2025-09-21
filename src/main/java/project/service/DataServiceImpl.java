package project.service;

import project.model.*;
import lombok.RequiredArgsConstructor;
import project.repository.DataRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {
    private final DataRepository dataRepository;

    public DataResponse getSuccessWorkedDay(DataRequest request) {
        DataResponse response = new DataResponse();
        Data data = new Data();
        DataSetSuccess dataSetSuccess = new DataSetSuccess();
        DataCheck dataCheck = new DataCheck(dataRepository);
        DataParse dataParse = new DataParse();
        dataCheck.DataIncorrect(request);
        Time time = new Time(dataParse.getDay(dataCheck, request),
                dataParse.getMouth(dataCheck, request),
                dataParse.getYear(dataCheck, request));
        response.setSuccess(dataSetSuccess.getDataResponse(time));
        data.setData(request.getData());
        data.setAnswer(response.isSuccess());
        dataRepository.save(data);
        return response;
    }
}
