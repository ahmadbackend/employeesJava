package emplyoess;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programmer extends Employee {

    private int yoe=0;
    private int locpd=0;
    private int iq=0;

   private final String progRex="\\w+=(?<locpd>\\w+),\\w+=(?<yoe>\\w+),\\w+=(?<iq>\\w+)";
    private final Pattern coderPat=Pattern.compile(progRex);

    public Programmer(String person) {
        super(person);

        Matcher programmerMatcher = coderPat.matcher(peopleMat.group("details"));
        if(programmerMatcher.find())
        {
            this.locpd=Integer.parseInt(programmerMatcher.group("locpd"));
            this.iq=Integer.parseInt(programmerMatcher.group("iq"));
            this.yoe=Integer.parseInt(programmerMatcher.group("yoe"));
        }



    }
    public int getSalary()
    {
        return 3000+ yoe*this.locpd+this.iq;

    }

}
