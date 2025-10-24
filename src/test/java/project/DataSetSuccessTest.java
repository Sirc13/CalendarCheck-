package project;

import org.junit.jupiter.api.Test;
import project.model.Time;
import project.service.DataSetSuccess;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataSetSuccessTest {
    @Test
    public void test() {
        Time time = new Time(15,03,2025);
        boolean a = DataSetSuccess.getDataResponse(time);
        assertEquals(false, a);
    }
    @Test
    public void test1() {
        Time time = new Time(12,05,2025);
        boolean a = DataSetSuccess.getDataResponse(time);
        assertEquals(true, a);
    }
}
