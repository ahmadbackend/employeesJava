package emplyoess;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
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



        String progRex="\\w+=(?<locpd>\\w+),\\w+=(?<yoe>\\w+),\\w+=(?<iq>\\w+)";
         Ipilot Pillot= new CEO("");
         Pillot.fly();
         /*
         * IT IS NOW A CEO WHO is allowed only to implement methods of Ipilot interface
         * this technique called composition  very suck method
         * use CTRL+ALT+B to see method implementation =>method source code
         * */
        int totalsalaries=0;
        IFemployee employee=null;
        try {
            while (peopleMat.find()) {
                employee = Employee.getText(peopleMat.group());
                /*
                 * if null used  while no match  then toString method will throw
                 * error as trying to point to nowhere.string
                 */
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());

            }
totalsalaries+= employee.getSalary();

        NumberFormat currency=  NumberFormat.getCurrencyInstance();
        System.out.printf("the total amout of  salaries  %s%n",currency.format(totalsalaries));
        bunchofbla test= new bunchofbla("ahmad","basher", LocalDate.of(1990, Month.JANUARY,28));

        System.out.println(test.dob());

    }


}
