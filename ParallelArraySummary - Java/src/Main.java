import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ElementsArray elementsArray = ElementsArray.getInstance();
        Sum sum = Sum.getInstance();

        ArrayList<Integer> floor = new ArrayList<Integer>();
        ArrayList<Integer> ceiling = new ArrayList<Integer>();
        int n = 0, t = 0, part = 0, numberElements = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("N: ");
        n = scanner.nextInt();
        System.out.println("T: ");
        t = scanner.nextInt();

        numberElements = (int) Math.pow(10, n);
        part = numberElements/t;

        elementsArray.elementAdd(numberElements);
        Thread[] thread = new ElementsThreads[t];

        for (int i = 0; i < t; i++)
        {
            thread[i] = new ElementsThreads(i, part, sum, floor, ceiling);
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

        elementsArray.printElements();
        sum.printTotais();
        System.out.println(floor);
        System.out.println(ceiling);
    }
}