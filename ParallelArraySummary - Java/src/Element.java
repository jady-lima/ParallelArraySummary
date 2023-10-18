public class Element {
    private int elementId;
    private double totalElement;
    private int grupo;

    public Element(int elementId, double totalElement, int grupo)
    {
        this.elementId = elementId;
        this.totalElement = totalElement;
        this.grupo = grupo;
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

    public int getGrupo()
    {
        return grupo;
    }

    public void setGrupo(int grupo)
    {
        this.grupo = grupo;
    }

    public void printElement()
    {
        System.out.println("ID: " + getElementId() +
                "\nTotal: " + getTotalElement() +
                "\nGrupo: " + getGrupo());
        System.out.println("-------------------------------------------------");
    }
}
