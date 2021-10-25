import java.util.Random;

public class Producer implements Runnable {
	private final Random _random;
    private final Container _container;
    private final int _idProducer;
    private final int WAITINGTIME = 1500;

    public Producer(Container container, int idProducer) {
        _container = container;
        _idProducer = idProducer;
        _random = new Random();
    }

    @Override
    public void run() {
        while(Boolean.TRUE) {
            int put = _random.nextInt(300);
            _container.put(put);
            System.out.println("The producer " + _idProducer + " puts: " + put);
            try {
                Thread.sleep(WAITINGTIME);
            } catch(InterruptedException e) {
                System.err.println("Producer " + _idProducer + ": Error in run -> " + e.getMessage());
            }
        }
    }
}
