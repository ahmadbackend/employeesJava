package emplyoess;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CEO extends Employee implements IFemployee,Ipilot{
    public Ipilot Pilot=new pilot(100,true);

        private int stockAvgPrice =0;


        private final String CeoRegex ="\\w+=(?<stockAvgPrice>\\w+)";
        private final Pattern CeoPat =Pattern.compile(CeoRegex);

        public CEO(String person) {
            super(person);
            Matcher CeoMat = CeoPat.matcher(peopleMat.group("details"));

            if(CeoMat.find())
            {
                this.stockAvgPrice =Integer.parseInt(CeoMat.group("stockAvgPrice"));
            }

        }

    public void fly() {
        Pilot.fly();
    }

    public void setHour(int hour) {
        Pilot.setHour(hour);
    }

    public void setCrz(boolean crz) {
        Pilot.setCrz(crz);
    }

    public int getHour() {
        return Pilot.getHour();
    }

    public boolean isCrz() {
        return Pilot.isCrz();
    }

    public int getSalary()
    {
        return 3000+ stockAvgPrice *this.stockAvgPrice;
    }

    @Override
    public String toString() {
        return super.toString();

    }
}


