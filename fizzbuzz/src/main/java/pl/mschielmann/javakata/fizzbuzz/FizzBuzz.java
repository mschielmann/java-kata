package pl.mschielmann.javakata.fizzbuzz;

public class FizzBuzz
{
    public static String of(int i)
    {
        if (i < 1)
        {
            throw new IllegalArgumentException("Input has to be greater than 0.");
        }

        String result = "";
        if (i % 3 == 0)
        {
            result += "Fizz";
        }
        if (i % 5 == 0)
        {
            result += "Buzz";
        }
        if (result.isEmpty())
        {
            result = String.valueOf(i);
        }

        return result;
    }
}
