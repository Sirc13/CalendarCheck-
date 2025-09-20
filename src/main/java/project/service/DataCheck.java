package project.service;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import project.exception.FilledInIncorrectly;
import project.model.Data;
import project.model.DataRequest;
import project.repository.DataRepository;

@RequiredArgsConstructor
@Getter
@Setter
public class DataCheck {
    private final DataRepository dataRepository;
    public void DataIncorrect(DataRequest request) {
        Data data = new Data();
        char[] chars = request.getData().toCharArray();
        if (chars.length<8 || chars.length>10){
            data.setData(request.getData());
            dataRepository.save(data);
            throw new FilledInIncorrectly("Incorrect data");
        }
        for (int i=0; i<chars.length; i++){
            if (chars[i]=='-'){
                throw new FilledInIncorrectly("Incorrect data");
            }
        }
    }
}
