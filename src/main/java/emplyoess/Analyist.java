package emplyoess;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyist extends Employee {

    private int projectCount=0;

    private final String analysRegex="\\w+=(?<projectCount>\\w+)";
    private final Pattern analystPat=Pattern.compile(analysRegex);
    public Analyist(String person) {
        super(person);

    Matcher analystMat = analystPat.matcher(peopleMat.group("details"));
    if(analystMat.find())
    {
        projectCount=Integer.parseInt(analystMat.group("projectCount"));

    }



    }
    public int getSalary()
    {
        return 5000+projectCount*3;

    }

    @Override
    public String toString() {
        return super.toString();

    }
}
