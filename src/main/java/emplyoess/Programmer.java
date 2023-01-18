package emplyoess;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programmer {
    private String lastName;
    private String firstName;
    private LocalDate dob;
    private int yoe=0;
    private int locpd=0;
    private int iq=0;
    private final String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?\\n";
    private final Pattern peoplePat = Pattern.compile(peopleRegex);
   private final String progRex="\\w+=(?<locpd>\\w+),\\w+=(?<yoe>\\w+),\\w+=(?<iq>\\w+)";
    private final Pattern coderPat=Pattern.compile(progRex);
    private final NumberFormat money= NumberFormat.getCurrencyInstance();
    DateTimeFormatter dtformat= DateTimeFormatter.ofPattern("M/d/yyyy");
    public Programmer(String person) {
        Matcher peopleMat = peoplePat.matcher(person);
        if(peopleMat.find())
        {
            this.lastName=peopleMat.group("lastName");
            this.firstName=peopleMat.group("firstName");
            this.dob=LocalDate.from(dtformat.parse(peopleMat.group("dob")));
            Matcher programmerMatcher = coderPat.matcher(peopleMat.group("details"));
            if(programmerMatcher.find())
            {
                this.locpd=Integer.parseInt(programmerMatcher.group("locpd"));
                this.iq=Integer.parseInt(programmerMatcher.group("iq"));
                this.yoe=Integer.parseInt(programmerMatcher.group("yoe"));
            }

        }

    }
    public int getSalary()
    {
        return 3000+ yoe*this.locpd+this.iq;
    }

    @Override
    public String toString() {
            return String.format("%s,  %s: %S%n",lastName, firstName,money.format(getSalary()));
    }
}
