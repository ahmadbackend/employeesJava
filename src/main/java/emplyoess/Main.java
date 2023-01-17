package emplyoess;

import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String people = """
            Flinstone, Fred, 1/1/1900, Programmer,  {lcpd=2000,yoe=100,iq=120}
            Rubble, Barney, 2/2/1905, Manager
            Flinstone, Wilma, 3/3/1910, Analyist
            Rubble, Betty, 4/4/1915, CEO
            """;

        String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?\\n";
        String progRex="\\w+=(?<locpd>\\w+),\\w+=(?<yoe>\\w+),\\w+=(?<iq>\\w+)";
        Pattern peoplePat = Pattern.compile(peopleRegex);
        Pattern coderPat=Pattern.compile(progRex);
        Matcher peopleMat = peoplePat.matcher(people);
        int totalsalaries=0;
        while (peopleMat.find()) {
            totalsalaries+= switch (peopleMat.group("role")) {

                case "Programmer" ->
                {
                    String details= peopleMat.group("details");
                    Matcher coderMat= coderPat.matcher(details);
                    int salary=0;
                    if(coderMat.find()) {
                        //System.out.println(peopleMat.group("details"));
                        int locpd =Integer.parseInt( coderMat.group("locpd"));
                        int iq =Integer.parseInt( coderMat.group("iq"));
                        int yoe =Integer.parseInt( coderMat.group("yoe"));
                        System.out.printf("programmer locpd is %s, years of experience %s and his iq is %s%n", locpd, yoe, iq);
                         salary = 3000 +locpd + iq * yoe / 1000;


                    }
                    else {
                        salary=3000;
                    }
                    yield salary;
                }
                case "Manager" -> {
                    yield 35000;
                }
                case "Analyist" -> {
                    yield 5000;
                }
                case "CEO" -> {
                    yield 100000;
                }
                default -> {
                    yield 0;
                }
            };
        }
        NumberFormat currency=  NumberFormat.getCurrencyInstance();
        System.out.printf("the total amout of  salaries  %s%n",currency.format(totalsalaries));


    }


}
