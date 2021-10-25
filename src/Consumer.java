
public class Consumer implements Runnable {
	private final Container _container;
    private final int _idConsumer;

    public Consumer(Container container, int idConsumer) {
        _container = container;
        _idConsumer = idConsumer;
    }

    @Override
    public void run() {
        while(Boolean.TRUE) {
            System.out.println("The consumer " + _idConsumer + " consumes: " + _container.get());
        }
    }
}
