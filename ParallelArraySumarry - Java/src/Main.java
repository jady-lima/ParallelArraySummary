import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ElementsArray elementsArray = new ElementsArray();
        Scanner scanner = new Scanner(System.in);

        int n = 0, t = 0;

        /**
        System.out.println("N: ");
        n = scanner.nextInt();

        for (int i = 0; i < Math.pow(10, n); i++)
        {
            elementsArray.elementAdd();
        }

        elementsArray.printElements();

        */

        System.out.println("T: ");
        t = scanner.nextInt();

        Thread[] thread = new ElementsThreads[t];
        for (int i = 0; i < t; i++)
        {
            thread[i] = new ElementsThreads(i);
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