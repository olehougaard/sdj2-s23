package dk.via.exercise7_3;

public class Task
{
    private final String text;
    private long estimatedTime;

    public Task(String text, long estimatedTime)
    {
        this.text = text;
        this.estimatedTime = estimatedTime;
    }
    public String getText()
    {
        return text;
    }
    public long getEstimatedTime()
    {
        return estimatedTime;
    }
    public void setEstimatedTime(long estimatedTime)
    {
        this.estimatedTime = estimatedTime;
    }
    public String toString()
    {
        return text + ", (Estimated time = " + estimatedTime + ")";
    }
}
