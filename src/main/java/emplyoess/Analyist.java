package emplyoess;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyist {
    private String lastName;
    private String firstName;
    private LocalDate dob;
    private int projectCount=0;
    private int locpd=0;
    private int iq=0;
    private final String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?\\n";
    private final Pattern peoplePat = Pattern.compile(peopleRegex);
    private final String analysRegex="\\w+=(?<projectCount>\\w+)";
    private final Pattern analystPat=Pattern.compile(analysRegex);
    private final NumberFormat money= NumberFormat.getCurrencyInstance();
    DateTimeFormatter dtformat= DateTimeFormatter.ofPattern("M/d/yyyy");
    public Analyist(String person) {
        Matcher peopleMat = peoplePat.matcher(person);
        if(peopleMat.find())
        {
            this.lastName=peopleMat.group("lastName");
            this.firstName=peopleMat.group("firstName");
            this.dob=LocalDate.from(dtformat.parse(peopleMat.group("dob")));
            Matcher analystMat = analystPat.matcher(peopleMat.group("details"));
            if(analystMat.find())
            {
                projectCount=Integer.parseInt(analystMat.group("projectCount"));

            }

        }

    }
    public int getSalary()
    {
        return 5000+projectCount*3;

    }

    @Override
    public String toString() {
        return String.format("%s,  %s: %S%n",lastName, firstName,money.format(getSalary()));

    }
}
