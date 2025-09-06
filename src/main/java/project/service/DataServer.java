package project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.model.Data;
import project.model.DataRequest;
import project.model.DataResponse;
import project.repository.DataRepository;

import java.time.DayOfWeek;
import java.time.LocalDate;

@RequiredArgsConstructor
@Service

public class DataServer implements DataService{
    private final DataRepository dataRepository;

    public DataResponse getSuccessWorkedDay(DataRequest request){
        DataResponse response = new DataResponse();
        Data data = new Data();
        char[] chars = request.getData().toCharArray();
        if (chars.length<9 || chars.length>10){
            return null;
        }
        for (int i=0; i<chars.length; i++){
            if (chars[i]=='-'){
                return null;
            }
        }
        String da = request.getData().substring(0, 2);
        String mo = request.getData().substring(3, 5);
        String ye = request.getData().substring(6, 10);
        int day = Integer.parseInt(da);
        int month = Integer.parseInt(mo);
        int year = Integer.parseInt(ye);
        LocalDate date = LocalDate.of(year, month, day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if(dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY){
            response.setSuccess(false);
        }else{
            response.setSuccess(true);
        }
        data.setData(request.getData());
        data.setAnswer(response.isSuccess());
        dataRepository.save(data);
        return response;
    }
}
