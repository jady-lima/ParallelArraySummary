import java.util.ArrayList;
import java.util.Random;

public class ElementsArray {
    Random random = new Random();
    public static int elementId = 1;
    ArrayList<Element> elementsArrayList;
    int grupo = 0;
    double total = 0;

    public ElementsArray()
    {
        elementsArrayList = new ArrayList<Element>();
    }

    public void elementAdd()
    {
        total = random.nextDouble(10) + 1;
        grupo = random.nextInt(5) + 1;
        elementsArrayList.add(new Element(elementId, total, grupo));
        elementId++;
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
