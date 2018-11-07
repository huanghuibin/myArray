/**
 * 循环队列
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    // front 表示记录出队索引  tail 入队索引
    private int front,tail;
    // 数组总元素
    private int size;

    public LoopQueue(int capacity) {
        this.data = (E[]) new Object[capacity +1 ];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    @Override
    public void enQueue(E e) {

    }

    @Override
    public E deQueue() {
        return null;
    }

    @Override
    public E getFront() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity(){
        return  data.length -1;
    }
}
