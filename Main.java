import java.util.Scanner;

public class Main
{
  public static void main(String[] args)
  {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the number of hours: ");
        int h = sc.nextInt();

        System.out.println("Please enter the number of minutes: ");
        int m = sc.nextInt();

        System.out.println("Please enter the number of seconds: ");
        int s = sc.nextInt();

        Time t = new Time(h, m, s);

        t.tick();

        testTick();
        testAdd();

        sc.close();
  }

  public static void testTick()
  {
    Time time = new Time(0, 0, 0);
    time.tick();
    System.out.println(
            "For (0,0,0) and tick() you got "
                    + time
                    + " which should be 00:00:01");

    time = new Time(0, 0, 58);
    time.tick();
    System.out.println(
            "For (0,0,58) and tick() you got "
                    + time
                    + " which should be 00:00:59");

    time = new Time(0, 0, 59);
    time.tick();
    System.out.println(
            "For (0,0,59) and tick() you got "
                    + time
                    + " which should be 00:01:00");

    time = new Time(0, 58, 59);
    time.tick();
    System.out.println(
            "For (0,58,59) and tick() you got "
                    + time
                    + " which should be 00:59:00");

    time = new Time(0, 59, 59);
    time.tick();
    System.out.println(
            "For (0,59,59) and tick() you got "
                    + time
                    + " which should be 01:00:00");

    time = new Time(23, 59, 59);
    time.tick();
    System.out.println(
            "For (23,59,59) and tick() you got "
                    + time
                    + " which should be 00:00:00");
  }

  public static void testAdd()
  {
    Time time1 = new Time(1, 1, 1);
    Time time2 = new Time(2, 2, 2);
    time1.add(time2);
    System.out.println(
            "The result of (1,1,1).add(2,2,2) is "
                    + time1
                    + " and should be (03:03:03)");

    time1 = new Time(0, 0, 59);
    time2 = new Time(0, 0, 1);
    time1.add(time2);
    System.out.println(
            "The result of (0,0,59).add(0,0,1) is "
                    + time1
                    + " and should be (00:01:00)");

    time1 = new Time(0, 59, 0);
    time2 = new Time(0, 0, 1);
    time1.add(time2);
    System.out.println(
            "The result of (0,59,0).add(0,0,1) is "
                    + time1
                    + " and should be (00:59:01)");

    time1 = new Time(0, 59, 59);
    time2 = new Time(0, 0, 1);
    time1.add(time2);
    System.out.println(
            "The result of (0,59,59).add(0,0,1) is "
                    + time1
                    + " and should be (01:00:00)");

    time1 = new Time(23, 0, 0);
    time2 = new Time(1, 0, 0);
    time1.add(time2);
    System.out.println(
            "The result of (23,0,0).add(1,0,0) is "
                    + time1
                    + " and should be (00:00:00)");

    time1 = new Time(9, 30, 30);
    time2 = new Time(2, 45, 45);
    time1.add(time2);
    System.out.println(
            "The result of (23,59,59).add(23,59,59) is "
                    + time1
                    + " and should be (23:59:58)");
  }
}
