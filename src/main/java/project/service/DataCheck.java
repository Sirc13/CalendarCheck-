package project.service;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import project.exception.FilledInIncorrectly;
import project.model.Data;
import project.model.DataRequest;
import project.repository.DataRepository;

@Getter
@Setter
@RequiredArgsConstructor
public class DataCheck {
    private final DataRepository dataRepository;

    public void DataIncorrect(DataRequest request) {
        Data data = new Data();
        char[] chars = request.getData().toCharArray();
        String dataString = new String(chars);
        String charsString = dataString.replaceAll("[^0-9]", "");
        if (charsString.length() < 8 || charsString.length() > 10) {
            data.setData(request.getData());
            dataRepository.save(data);
            throw new FilledInIncorrectly("Incorrect data");
        }
        for (int i = 0; i < charsString.length(); i++) {
            if (chars[i] == '-') {
                throw new FilledInIncorrectly("Incorrect data");
            }
        }
    }
}
