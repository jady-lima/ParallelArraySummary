public class ElementsThreads extends Thread{
    private int threadId;

    public ElementsThreads(int threadId)
    {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        System.out.println(threadId + " - Thread");
    }
}
