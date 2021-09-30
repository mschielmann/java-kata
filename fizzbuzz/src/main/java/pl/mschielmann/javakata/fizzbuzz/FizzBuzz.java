package pl.mschielmann.javakata.fizzbuzz;

public class FizzBuzz {

    public static String of(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Input has to be greater than 0.");
        }
        if (i % 15 == 0) {
            return "FizzBuzz";
        }
        if (i % 3 == 0) {
            return "Fizz";
        } else if (i % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(i);
    }
}
