public class test
{
    public static void main(String[] args) {
        long start = System.nanoTime();
        for(int count = 0; count < 99999999; count++)
        {
            Math.log(Math.sqrt(count));
        }
        long end = System.nanoTime();
        double timeDif = (end-start) / 1000000000.0;
        System.out.println( Math.round(timeDif*100)/100.0 );
    }
}