package emplyoess;

import javax.swing.*;
import java.text.NumberFormat;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String people = """
            Flinstone, Fred, 1/1/1900, Programmer,  {lcpd=2000,yoe=100,iq=120}
            Rubble, Barney, 2/2/1905, Manager, {orgSize=100,dir=20}
            Flinstone, Wilma, 3/3/1910, Analyist {projectCount=50}
            Rubble, Betty, 4/4/1915, CEO {stockAvgPrice=5000}
            """;

        String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?\\n";
        Pattern peoplePat = Pattern.compile(peopleRegex);
        Matcher peopleMat = peoplePat.matcher(people);

        String mngrRex="\\w+=(?<orgsize>\\w+),\\w+=(?<dir>\\w+)";
        Pattern mngrPat=Pattern.compile(mngrRex);

        String progRex="\\w+=(?<locpd>\\w+),\\w+=(?<yoe>\\w+),\\w+=(?<iq>\\w+)";
        Pattern coderPat=Pattern.compile(progRex);
        int totalsalaries=0;
        Employee employee=null;
        while (peopleMat.find()) {
           employee= switch (peopleMat.group("role")) {

                case "Programmer" ->new Programmer(peopleMat.group());

                case "Manager" -> new Manager(peopleMat.group());

                case "Analyist" -> new Analyist(peopleMat.group());

                case "CEO" -> new CEO(peopleMat.group());
                default -> new Employee(peopleMat.group());
                /*
                * if null used  while no match  then toString method will throw
                * error as trying to point to nowhere.string
                */
            };
            if (employee!=null)
            {
                /*
                * another approach to solve null issue*/
                totalsalaries+=employee.getSalary();
                System.out.println(employee.toString());
            }

        }
        NumberFormat currency=  NumberFormat.getCurrencyInstance();
        System.out.printf("the total amout of  salaries  %s%n",currency.format(totalsalaries));


    }


}
