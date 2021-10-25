
public class Container {
	private int _content;
    private boolean _fullContainer = Boolean.FALSE;

    /**
     * Gets concurrently the element that is in the container 
     *
     * @return container content
     */
    public synchronized int get() {
        while (!_fullContainer) {
            try {
                wait();
            } catch(InterruptedException e) {
                System.err.println("Container: Error in get -> " + e.getMessage());
            }
        }
        _fullContainer = Boolean.FALSE;
        notifyAll();
        return _content;
    }

    /**
     * Puts concurrently an element in the container
     *
     * @param value: Element to put inside the container
     */
    public synchronized void put(int value) {
        while(_fullContainer) {
            try {
                wait();
            } catch(InterruptedException e) {
                System.err.println("Container: Error in put -> " + e.getMessage());
            }
        }
        _content = value;
        _fullContainer = Boolean.TRUE;
        notify();
    }
}
