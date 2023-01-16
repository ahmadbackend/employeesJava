package emplyoess;

import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String people = """
            Flinstone, Fred, 1/1/1900, Programmer
            Rubble, Barney, 2/2/1905, Manager
            Flinstone, Wilma, 3/3/1910, Analyist
            Rubble, Betty, 4/4/1915, CEO
            """;

        String regex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)\\n";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(people);
        int totalsalaries=0;
        while (mat.find()) {
            totalsalaries+= switch (mat.group("role")) {

                case "Programmer" -> 3000;
                case "Manager" -> 35000;
                case "Analyist" ->5000;
                case "CEO" -> 100000;
                default -> 0;
            };
        }
        NumberFormat currency=  NumberFormat.getCurrencyInstance();
        System.out.printf("the total amout of  salaries  %s%n",currency.format(totalsalaries));


    }


}
