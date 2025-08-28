package project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.model.Data;
import project.model.DataRequest;
import project.model.DataResponse;
import project.repository.DataRepository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@RequiredArgsConstructor
@Service

public class DataServer implements DataService{
    private final DataRepository dataRepository;

    public DataResponse getSuccessWorkedDay(DataRequest request){
        DataResponse response = new DataResponse();
        Data data = new Data();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try {
            LocalDate localDate = LocalDate.parse((CharSequence) request, formatter);
            data.setData(localDate.toString());
            DayOfWeek dayOfWeek = localDate.getDayOfWeek();

            if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
                response.setSuccess(false);
            } else {
                response.setSuccess(true);
            }
        } catch (DateTimeParseException e) {
            return null;
        }
        data.setAnswer(response.isSuccess());
        dataRepository.save(data);
        return response;
    }
}
