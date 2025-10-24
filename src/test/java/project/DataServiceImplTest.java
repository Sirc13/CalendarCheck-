package project;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import project.model.DataRequest;
import project.model.DataResponse;
import project.service.DataService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class DataServiceImplTest {
    @MockBean
    private DataService dataService;
    @Test
    public void test() {
        DataRequest request = new DataRequest("12.09.2025");
        DataResponse dataResponse = new DataResponse(true);
        when(dataService.getSuccessWorkedDay(any())).thenReturn(dataResponse);
        DataResponse a = dataService.getSuccessWorkedDay(request);
        assertEquals(true, a.isSuccess());
    }
}
