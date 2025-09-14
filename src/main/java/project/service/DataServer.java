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
        int day=0;
        int month=0;
        int year=0;
        char[] chars = request.getData().toCharArray();
        if (chars.length<8 || chars.length>10){ // todo Вынести в отдельный метод
            data.setData(request.getData());
            dataRepository.save(data);
            throw new RuntimeException("Error");
        }
        if (chars.length==8){
            String da3 = request.getData().substring(0, 1);
            String mo3 = request.getData().substring(2, 3);
            String ye3 = request.getData().substring(4, 8);
            day = Integer.parseInt(da3);
            month = Integer.parseInt(mo3);
            year = Integer.parseInt(ye3);
        } else if (chars.length==9) {
            if (chars[2]=='.' || chars[2]=='-' || chars[2]==' ' || chars[2]=='/'){
                String da2 = request.getData().substring(0, 2);
                String mo2 = request.getData().substring(3, 4);
                String ye2 = request.getData().substring(5, 9);
                day = Integer.parseInt(da2);
                month = Integer.parseInt(mo2);
                year = Integer.parseInt(ye2);
            }else {
                String da1 = request.getData().substring(0, 1);
                String mo1 = request.getData().substring(2, 4);
                String ye1 = request.getData().substring(5, 9);
                day = Integer.parseInt(da1);
                month = Integer.parseInt(mo1);
                year = Integer.parseInt(ye1);
            }
        }else{
            String da = request.getData().substring(0, 2);
            String mo = request.getData().substring(3, 5);
            String ye = request.getData().substring(6, 10);
            day = Integer.parseInt(da);
            month = Integer.parseInt(mo);
            year = Integer.parseInt(ye);
        }
        for (int i=0; i<chars.length; i++){
            if (chars[i]=='-'){
                return null;
            }
        }

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
