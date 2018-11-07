public interface Queue<E> {

    public void enQueue(E e);

    public E deQueue();

    public E getFront();

    public boolean isEmpty();

    public int getSize();
}
