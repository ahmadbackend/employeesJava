package emplyoess;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager extends Employee implements IFemployee{

    private int dir =0;
    private int orgSize=0;


    private final String mngrRex="\\w+=(?<orgsize>\\w+),\\w+=(?<dir>\\w+)";
   private final Pattern mngrPat=Pattern.compile(mngrRex);

    public Manager(String person) {
        super(person);
        Matcher mngrmat = mngrPat.matcher(peopleMat.group("details"));

        if(mngrmat.find())
        {
            this.dir=Integer.parseInt(mngrmat.group("dir"));
            this.orgSize=Integer.parseInt(mngrmat.group("orgsize"));

        }

    }




    public int getSalary()
    {
        return 3000+ orgSize *this.dir;
    }

    @Override
    public String toString() {
        return super.toString();

    }


}
