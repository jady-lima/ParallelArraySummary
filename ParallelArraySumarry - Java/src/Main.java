import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = 1, t = 0, part = 0, numberElements = 0;

        System.out.println("N: ");
        n = scanner.nextInt();

        System.out.println("T: ");
        t = scanner.nextInt();

        Thread[] thread = new ElementsThreads[t];

        numberElements = (int) Math.pow(10, n);
        part = numberElements/t;

        for (int i = 0; i < t; i++)
        {
            thread[i] = new ElementsThreads(i, part, numberElements);
            thread[i].start();
        }

        for (int i = 0; i < t; i++)
        {
            try{
                thread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}