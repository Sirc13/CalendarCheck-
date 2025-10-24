package project;

import org.junit.jupiter.api.Test;
import project.model.DataRequest;
import project.repository.DataRepository;
import project.service.DataCheck;
import project.service.DataParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataParseTest {
    DataRepository dataRepository;

    DataCheck dataCheck = new DataCheck(dataRepository);
    @Test
    public void testDay() {
        DataRequest dataRequest = new DataRequest("13.03.2025");
        int a = DataParse.getDay(dataCheck,dataRequest);
        assertEquals(13, a);
    }
    @Test
    public void testDay1() {
        DataRequest dataRequest = new DataRequest("24.03.2025");
        int a = DataParse.getDay(dataCheck,dataRequest);
        assertEquals(24, a);
    }
}
