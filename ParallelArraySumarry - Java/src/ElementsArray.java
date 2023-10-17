import java.util.ArrayList;
import java.util.Random;

public class ElementsArray {
    Random random = new Random();
    Element thisElement = new Element(0, 0, 0);
    public static int elementId = 1;
    ArrayList<Element> elementsArrayList;
    int grupo = 0;
    double total = 0;

    public ElementsArray()
    {
        elementsArrayList = new ArrayList<Element>();
    }

    public synchronized void elementAdd()
    {
        total = random.nextDouble(10);
        grupo = random.nextInt(5) + 1;
        thisElement = new Element(elementId, total, grupo);
        elementsArrayList.add(thisElement);
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

    public Element returnElement(int elementId)
    {
        for(Element element: elementsArrayList)
        {
            if (element.getElementId() == elementId)
            {
                return element;
            }
        }
        return null;
    }

    public Element returnThisElement()
    {
        return thisElement;
    }
}
