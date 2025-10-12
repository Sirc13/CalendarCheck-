package project;

import org.junit.jupiter.api.Test;
import project.service.CountSquareService;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountSquareServiceTest {
    @Test
    public void test1 () {
        int a = CountSquareService.CountSquareService(9,10);
        assertEquals(90, a);
    }
    @Test
    public void test2 () {
        int a = CountSquareService.CountSquareService(9,10);
        assertEquals(10, a);
    }
    @Test
    public void test3 () {
        int a = CountSquareService.CountSquareService(9,10);
        assertEquals(45, a);
    }
}
