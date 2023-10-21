import java.util.ArrayList;

public class ElementsThreads extends Thread{
    private ArrayList<Integer> floor;
    private ArrayList<Integer> ceiling;
    private ElementsArray elementsArray = ElementsArray.getInstance();
    private Sum sum = Sum.getInstance();
    private int threadId, part;
    private static double totalSum = 0, subTotal1 = 0, subTotal2 = 0, subTotal3 = 0, subTotal4 = 0, subTotal5 = 0;

    public ElementsThreads(int threadId, int part, Sum sum, ArrayList<Integer> floor, ArrayList<Integer> ceiling)
    {
        this.threadId = threadId;
        this.part = part;
        this.sum = sum;
        this.floor = floor;
        this.ceiling = ceiling;
    }

    @Override
    public void run()
    {
        try {
            synchronized (elementsArray) {
                for (int i = (threadId * part); i < ((threadId + 1) * part); i++)
                {
                    sum.Total(elementsArray.returnArray().get(i));
                    splitElements(elementsArray.returnArray().get(i));
                }
            }

            sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void splitElements(Element element)
    {
        if (element.getTotalElement() < 5) {
            floor.add(element.getElementId());
        } else {
            ceiling.add(element.getElementId());
        }
    }
}
