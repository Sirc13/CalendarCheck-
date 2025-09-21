package project.service;

import project.model.DataRequest;
import project.model.DataResponse;

public interface DataService {

    DataResponse getSuccessWorkedDay(DataRequest dataRequest);
}
