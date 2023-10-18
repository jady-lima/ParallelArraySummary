public class Sum {
    private static Sum instance;
    private double totalSum = 0;
    private double subTotal1 = 0;
    private double subTotal2 = 0;
    private double subTotal3 = 0;
    private double subTotal4 = 0;
    private double subTotal5 = 0;

    public static Sum getInstance()
    {
        if (instance == null)
        {
            instance = new Sum();
        }
        return instance;
    }

    public void printTotais()
    {
        System.out.println("1. Somatório Total: " + totalSum);
        System.out.println("2. Somatório subtotais:" +
                "\nSubtotal 1: " + subTotal1 +
                "\nSubtotal 2: " + subTotal2 +
                "\nSubtotal 3: " + subTotal3 +
                "\nSubtotal 4: " + subTotal4 +
                "\nSubtotal 5: " + subTotal5 );
    }

    public double getTotalSum()
    {
        return totalSum;
    }

    public void setTotalSum(double totalSum)
    {
        this.totalSum = totalSum;
    }

    public double getSubTotal1()
    {
        return subTotal1;
    }

    public void setSubTotal1(double subTotal1)
    {
        this.subTotal1 = subTotal1;
    }

    public double getSubTotal2()
    {
        return subTotal2;
    }

    public void setSubTotal2(double subTotal2)
    {
        this.subTotal2 = subTotal2;
    }

    public double getSubTotal3()
    {
        return subTotal3;
    }

    public void setSubTotal3(double subTotal3)
    {
        this.subTotal3 = subTotal3;
    }

    public double getSubTotal4()
    {
        return subTotal4;
    }

    public void setSubTotal4(double subTotal4)
    {
        this.subTotal4 = subTotal4;
    }

    public double getSubTotal5()
    {
        return subTotal5;
    }

    public void setSubTotal5(double subTotal5)
    {
        this.subTotal5 = subTotal5;
    }
}
