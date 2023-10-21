public class Element {
    private int elementId;
    private double totalElement;
    private int group;

    public Element(int elementId, double totalElement, int group)
    {
        this.elementId = elementId;
        this.totalElement = totalElement;
        this.group = group;
    }

    public int getElementId()
    {
        return elementId;
    }

    public void setElementId(int elementId)
    {
        this.elementId = elementId;
    }

    public double getTotalElement()
    {
        return totalElement;
    }

    public void setTotalElement(double totalElement)
    {
        this.totalElement = totalElement;
    }

    public int getGroup()
    {
        return group;
    }

    public void setGroup(int group)
    {
        this.group = group;
    }

    public void printElement()
    {
        System.out.println("ID: " + getElementId() +
                "\nTotal: " + getTotalElement() +
                "\nGrupo: " + getGroup());
        System.out.println("-------------------------------------------------");
    }
}
