
public class ProducerConsumer {
	private static Container container;
    private static Thread producer;
    private static Thread[] consumers;
    private static final int CONSUMERSQUANTITY = 5;

    public static void main(String[] args) {
        container = new Container();
        producer = new Thread(new Producer(container, 1));
        consumers = new Thread[CONSUMERSQUANTITY];
        
        for (int i = 0; i < CONSUMERSQUANTITY; i++) {
        	consumers[i] = new Thread(new Consumer(container, i));
            consumers[i].start();
        }

        producer.start();
    }
}
