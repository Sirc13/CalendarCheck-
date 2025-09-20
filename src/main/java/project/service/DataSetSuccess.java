package project.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import project.model.DataResponse;
import project.model.Time;

import java.time.DayOfWeek;
import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@Setter
public class DataSetSuccess {
    public boolean getDataResponse(Time time) {
        DataResponse dataResponse = new DataResponse();
        int day = time.getDay();
        int month = time.getMouth();
        int year = time.getYear();
        LocalDate date = LocalDate.of(year, month, day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if(dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY){
            dataResponse.setSuccess(false);
        }else{
            dataResponse.setSuccess(true);
        }
        return dataResponse.isSuccess();
    }
}
