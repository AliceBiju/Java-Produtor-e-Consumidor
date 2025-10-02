public class ConsumerThread extends Thread {
    private SharedList sharedList;

    public ConsumerThread(SharedList sharedList) {
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            sharedList.consumeValue();
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
