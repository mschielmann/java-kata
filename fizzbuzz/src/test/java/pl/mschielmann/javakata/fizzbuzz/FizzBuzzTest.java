package pl.mschielmann.javakata.fizzbuzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    @Test
    public void returns_1_for_input_1() {
        assertEquals("1", FizzBuzz.of(1));
    }
}
