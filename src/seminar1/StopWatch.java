package seminar1;

public class StopWatch
{

    private long period;
    private long startTime;
    private byte status; //0- stoped, 1-running

    public void start()
    {
        startTime = System.nanoTime();
        status = 1;
    }

    public void stop()
    {
        period += (System.nanoTime() - startTime);
        status = 0;
    }

    public void reset()
    {
        period = 0;
        startTime = System.nanoTime();
    }

    public long getPeriod()
    {
        switch (status) {
        case 0:
            return period;
        case 1:
            return period + (System.nanoTime() - startTime);
        }
        return period;
    }

}