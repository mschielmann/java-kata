package pl.mschielmann.javakata.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    @Test
    public void returns_string_1_for_input_1() {
        assertEquals("1", FizzBuzz.of(1));
    }

    @Test
    public void returns_string_2_for_input_2() {
        assertEquals("2", FizzBuzz.of(2));
    }

    @Test
    public void returns_string_Fizz_for_input_3() {
        assertEquals("Fizz", FizzBuzz.of(3));
    }

    @Test
    public void returns_string_Buzz_for_input_5() {
        assertEquals("Buzz", FizzBuzz.of(5));
    }
}
