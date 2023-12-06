import org.example.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.swing.*;
import java.io.File;
import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculatorUnderTest;

    private static Instant startedAt;

    @BeforeAll
    public static void initStartingTime(){
        startedAt = Instant.now();
        System.out.println("Appel avant tous les tests");
    }

    @AfterAll
    public static void showTestDuration(){
        System.out.println("Appel après tous les tests");
        final Instant endTime = Instant.now();
        final long duration = Duration.between(startedAt, endTime).toMillis();
        System.out.println(MessageFormat.format("durée des Tests {0} ms", duration));
    }

    @BeforeEach
    public void initCalculator(){
        calculatorUnderTest = new Calculator();
        System.out.println("Appel avant chaque methode de test");
    }

    @AfterEach
    public void endEachMethodTest(){
        calculatorUnderTest = null;
        System.out.println("Appel après chaque méthode de test");
    }

    @Test
    public void sumOfTwoNumberTest() {
        //Arrange
        int a = 5;
        int b = 10;

        // act
        int result = calculatorUnderTest.sum(a, b);

        //assertEquals(15, result);
        //Assertions.assertTrue(result == 15);
        Assertions.assertEquals(15, result, "les valeurs ne sont pas égales");

    }

    @Test
    public void multiplyTwoNumber() {

        int a = 4;
        int b = 10;
        int expected = 40;

        int actual = calculatorUnderTest.multiply(a, b);

        assertEquals(expected, actual, "Resultat faux");
    }

    @ParameterizedTest(name = "{0} * 0 doit être égal à 0")
    @ValueSource(ints = {1, 5, 23, 64, 585})
    public void multiply_many_numberVerification(int arg){

        int actual = calculatorUnderTest.multiply(arg, 0);

        assertEquals(0, actual);
    }

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({"1,2,2", "2,2,4", "5,6,30", "7,7,49"})
    public void multi_testWithCsvData(int arg0, int arg1, int arg2){

        int actual = calculatorUnderTest.multiply(arg0, arg1);

        //assertEquals(arg2, actual);
        assertThat(actual).isEqualTo(arg2);
    }

    @Timeout(1)
    @Test
    public void testTimeOut(){
        calculatorUnderTest.longExcecution();
    }

    @Test
    public void listDigits_shouldReturnsTheListOfDigits_ofPositiveInteger() {
        // GIVEN
        int number = 95897;

        // WHEN
        Set<Integer> actualDigits = calculatorUnderTest.digitsSet(number);

        // THEN
        assertThat(actualDigits).containsExactlyInAnyOrder(5, 7, 8, 9);

        //Set<Integer> expectedDigits = Stream.of(5, 7, 8, 9).collect(Collectors.toSet());
        //assertEquals(expectedDigits, actualDigits);
    }

}
