package emplyoess;

public class pilot implements Ipilot {
    private int hour=0;
    private boolean crz=false;

    public pilot(int hour, boolean crz) {
        this.hour = hour;
        this.crz = crz;
    }
    @Override
    public void fly(){
        System.out.println("prepare to die");
    }

    @Override
    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public void setCrz(boolean crz) {
        this.crz = crz;
    }

    @Override
    public int getHour() {
        return hour;
    }

    @Override
    public boolean isCrz() {
        return crz;
    }
}
