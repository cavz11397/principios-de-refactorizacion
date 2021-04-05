package co.com.sofka.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectDataReloaderTest {

    @Test
    @DisplayName("Testing varias restas")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "0,    1,   -1",
            "1,    5,   -4",
            "49,  51, -2",
            "1000,  100, 900"
    })
    public void severalSubstractions(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, ProjectDataReloader.substraction(first, second));
    }

    @Test
    @DisplayName("Testing operador %")
    @ParameterizedTest(name = "{0} % {1} == {2}")
    @CsvSource({
            "100,    2,    0,   true",
            "100,    3,    0,   false",
            "51,    2,    0,   false",
            "2,    2,    0,   true"
    })
    public void severalModulos(Long first, Long second,Long third, boolean expectedResult) {
        assertEquals(expectedResult, ProjectDataReloader.modulo(first.intValue(), second.intValue(),third.intValue()));
    }

    @Test
    @DisplayName("Testing igualdad de numeros")
    @ParameterizedTest(name = "{0} == {1}")
    @CsvSource({
            "2,    2,   true",
            "45,    45,   true",
            "2,    8,   false",
            "2,    1,   false"
    })
    public void severalEqualsNumber(Long first, Long second, boolean expectedResult) {
        assertEquals(expectedResult, ProjectDataReloader.equalsNumber(first, second));
    }

    @Test
    @DisplayName("Testing comparacion menor")
    @ParameterizedTest(name = "{0} < {1}")
    @CsvSource({
            "2,    2,   false",
            "45,    46,   true",
            "2,    8,   true",
            "2,    1,   false"
    })
    public void severalLessNumber(Long first, Long second, boolean expectedResult) {
        assertEquals(expectedResult, ProjectDataReloader.lessNumber(first, second));
    }

    @Test
    @DisplayName("Testing comparacion mayor")
    @ParameterizedTest(name = "{0} > {1}")
    @CsvSource({
            "2,    2,   false",
            "84,    46,   true",
            "2,    8,   false",
            "2,    1,   true"
    })
    public void severalGreaterNumber(Long first, Long second, boolean expectedResult) {
        assertEquals(expectedResult, ProjectDataReloader.greaterNumber(first, second));
    }
}
