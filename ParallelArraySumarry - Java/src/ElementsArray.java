import java.util.ArrayList;
import java.util.Random;

public class ElementsArray {
    private static ElementsArray instance;
    private static int elementId = 1;
    private Random random = new Random();
    private ArrayList<Element> elementsArrayList;
    private int grupo = 0;
    private double total = 0;

    public static ElementsArray getInstance()
    {
        if (instance == null)
        {
            instance = new ElementsArray();
        }
        return instance;
    }

    public ElementsArray()
    {
        elementsArrayList = new ArrayList<Element>();
    }

    public ArrayList<Element> returnArray()
    {
        return elementsArrayList;
    }

    public void elementAdd(int N)
    {
        for (int i = 0; i < N; i++) {
            total = random.nextDouble(10);
            grupo = random.nextInt(5) + 1;
            Element thisElement = new Element(elementId, total, grupo);
            elementsArrayList.add(thisElement);
            elementId++;
        }
    }

    public int elementsArrayListSize()
    {
        return elementsArrayList.size();
    }

    public void printElements()
    {
        for (int i = 0; i < elementsArrayListSize(); i++)
        {
            elementsArrayList.get(i).printElement();
        }
    }

}
