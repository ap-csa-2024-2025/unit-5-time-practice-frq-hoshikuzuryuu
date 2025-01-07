public class Time
{
  private int hours;
  private int minutes;
  private int seconds;

  public Time(int hours, int minutes, int seconds)
  {
      this.hours = hours;
      this.minutes = minutes;
      this.seconds = seconds;
  }

 public Time()
  {
    this(0,0,0);
  }

  private String pad(int value)
  {
    String output = "";
    if (value < 10 && value > 0)
    {
      return output + "0" + value;
    }
    return output + value;
  }

  public String toString()
  {
    return pad(this.hours) + ";" + pad(this.minutes) + ";" + pad(this.seconds);
  }

  public void tick()
  {
    seconds++;
    if (seconds == 60)
    {
      seconds = 0;
      minutes++;
    }
    if (minutes == 60)
    {
      minutes = 0;
      hours++;
    }
    if (hours == 24)
    {
      hours = 0;
    }
  }

  public void add(Time offset)
  {
    seconds += offset.seconds; 
    minutes += offset.minutes + seconds/60;
    hours += offset.hours + minutes/60;

    seconds %= 60;
    minutes %= 60;
    hours %= 24;
  }
}
