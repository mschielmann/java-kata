package pl.mschielmann.javakata.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FizzBuzzTest
{
    @Test
    public void returns_string_1_for_input_1()
    {
        assertEquals("1", FizzBuzz.of(1));
    }

    @Test
    public void returns_string_2_for_input_2()
    {
        assertEquals("2", FizzBuzz.of(2));
    }

    @Test
    public void returns_string_Fizz_for_input_3()
    {
        assertEquals("Fizz", FizzBuzz.of(3));
    }

    @Test
    public void returns_string_Buzz_for_input_5()
    {
        assertEquals("Buzz", FizzBuzz.of(5));
    }

    @Test
    public void returns_string_Fizz_for_input_6()
    {
        assertEquals("Fizz", FizzBuzz.of(6));
    }

    @Test
    public void returns_string_Buzz_for_input_10()
    {
        assertEquals("Buzz", FizzBuzz.of(10));
    }

    @Test
    public void returns_string_FizzBuzz_for_input_15()
    {
        assertEquals("FizzBuzz", FizzBuzz.of(15));
    }

    @Test
    public void returns_string_FizzBuzz_for_input_30()
    {
        assertEquals("FizzBuzz", FizzBuzz.of(30));
    }

    @Test
    public void throws_exception_for_input_0()
    {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.of(0));
    }

    @Test
    public void throws_exception_for_input_less_than_0()
    {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.of(-1));
    }
}
