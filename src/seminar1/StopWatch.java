package seminar1;

public class StopWatch
{

    private long period = 0;
    private long startTime = System.nanoTime();
    private boolean status = false; //false = Stoped, true = Running

    public void start()
    {
        startTime = System.nanoTime();
        status = true; //Running
    }

    public void stop()
    {
        period += (System.nanoTime() - startTime);
        status = false; //Stoped
    }

    public void reset()
    {
        period = 0;
        startTime = System.nanoTime();
    }

    public long getPeriod()
    {
        if (status) { //Running
            return period + (System.nanoTime() - startTime);
        } else { //Stoped
            return period;
        }
    }
    
    public long getStartPeriod(){ //give you the time from last time start called without adding pervoise periods
        if (status) { //Running
            return (System.nanoTime() - startTime);
        } else { //Stoped
            return 0;
        }
    }
}
