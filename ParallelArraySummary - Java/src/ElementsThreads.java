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
                    sum.setTotalSum(sum.getTotalSum() + elementsArray.returnArray().get(i).getTotalElement());

                    switch (elementsArray.returnArray().get(i).getGrupo()){
                        case 1:
                            sum.setSubTotal1(sum.getSubTotal1() + elementsArray.returnArray().get(i).getTotalElement());
                            break;
                        case 2:
                            sum.setSubTotal2(sum.getSubTotal2() + elementsArray.returnArray().get(i).getTotalElement());
                            break;
                        case 3:
                            sum.setSubTotal3(sum.getSubTotal3() + elementsArray.returnArray().get(i).getTotalElement());
                            break;
                        case 4:
                            sum.setSubTotal4(sum.getSubTotal4() + elementsArray.returnArray().get(i).getTotalElement());
                            break;
                        case 5:
                            sum.setSubTotal5(sum.getSubTotal5() + elementsArray.returnArray().get(i).getTotalElement());
                            break;
                        default:
                            System.out.println("Default");
                    }

                    if (elementsArray.returnArray().get(i).getTotalElement() < 5) {
                        floor.add(elementsArray.returnArray().get(i).getElementId());
                    } else {
                        ceiling.add(elementsArray.returnArray().get(i).getElementId());
                    }
                }
            }

            sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
