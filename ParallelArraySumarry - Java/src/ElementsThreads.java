public class ElementsThreads extends Thread{
    ElementsArray elementsArray = new ElementsArray();
    private int threadId;
    private int part;
    private int numberElements;
    private static double totalSum = 0, subTotal1 = 0, subTotal2 = 0, subTotal3 = 0, subTotal4 = 0, subTotal5 = 0;


    public ElementsThreads(int threadId, int part, int numberElements)
    {
        this.threadId = threadId;
        this.part = part;
        this.numberElements = numberElements;
    }

    @Override
    public void run()
    {
        synchronized (elementsArray)
        {
            for (int i = 0; i < part; i++)
            {
                elementsArray.elementAdd();
                totalSum += elementsArray.thisElement.getTotalElement();

                if (elementsArray.thisElement.getGrupo() == 1) {
                    subTotal1 += elementsArray.thisElement.getTotalElement();
                } else if (elementsArray.thisElement.getGrupo() == 2) {
                    subTotal2 += elementsArray.thisElement.getTotalElement();
                } else if (elementsArray.thisElement.getGrupo() == 3) {
                    subTotal3 += elementsArray.thisElement.getTotalElement();
                } else if (elementsArray.thisElement.getGrupo() == 4) {
                    subTotal4 += elementsArray.thisElement.getTotalElement();
                } else {
                    subTotal5 += elementsArray.thisElement.getTotalElement();
                }

            }
        }
        elementsArray.printElements();
        System.out.println("1. Somatório Total: " + totalSum);
        System.out.println("2. Somatório subtotais:" +
                "\nSubtotal 1: " + subTotal1 +
                "\nSubtotal 2: " + subTotal2 +
                "\nSubtotal 3: " + subTotal3 +
                "\nSubtotal 4: " + subTotal4 +
                "\nSubtotal 5: " + subTotal5 );

        //System.out.println(threadId + " - Thread");
    }
}
