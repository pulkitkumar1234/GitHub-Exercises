class Seventh {

    private int day;
    private float hour;
    private float minutes;

    public void SectoDay (int n)
        {
            day = n / (24 * 3600);
            n = n % (24 * 3600);
            hour = n / 3600;

            n %= 3600;
            minutes = n / 60;

            n %= 60;
            int seconds = n;

            System.out.println(day + " " + "days " + hour + " " + "hours " + minutes + " "+ "minutes " + seconds + " "+ "seconds ");
        }

      public static void main (String[] args)
        {
            Seventh s1 = new Seventh();
            s1.SectoDay(129600);

        }
    }
