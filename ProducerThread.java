public class ProducerThread extends Thread {
    private SharedList sharedList;

    public ProducerThread(SharedList sharedList) {
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            sharedList.addValue(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
