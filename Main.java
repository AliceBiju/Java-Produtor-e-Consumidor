public class Main {
    public static void main(String[] args) {
        SharedList sharedList = new SharedList();

        Thread producer = new ProducerThread(sharedList);
        Thread consumer = new ConsumerThread(sharedList);

        producer.start();
        consumer.start();
    }
}
