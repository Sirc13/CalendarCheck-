package project.service;
//hoy
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import project.model.DataRequest;

@Getter
@Setter
@RequiredArgsConstructor
public class DataParse {
    public int getDay(DataCheck dataCheck, DataRequest dataRequest) {
        dataCheck.DataIncorrect(dataRequest);
        String stringDay = dataRequest.getData().substring(0, 2);
        int day = Integer.parseInt(stringDay);
        return day;
    }

    public int getMouth(DataCheck dataCheck, DataRequest dataRequest) {
        dataCheck.DataIncorrect(dataRequest);
        String stringMonth = dataRequest.getData().substring(3, 5);
        int month = Integer.parseInt(stringMonth);
        return month;
    }

    public int getYear(DataCheck dataCheck, DataRequest dataRequest) {
        dataCheck.DataIncorrect(dataRequest);
        String stringYear = dataRequest.getData().substring(6, 10);
        int year = Integer.parseInt(stringYear);
        return year;
    }

}
