
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
       array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array  = new Array<>();
    }

    @Override
    public void enQueue(E e) {
        array.addLast(e);
    }

    @Override
    public E deQueue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue : Front [");
        for(int i=0;i<array.getSize();i++){
            res.append(array.get(i));
            if(i != array.getSize()-1){
                res.append(", ");
            }
        }
        res.append("] tail ");
        return res.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> array = new ArrayQueue<>();

        for (int i = 0; i <10 ; i++) {
            array.enQueue(i);
            System.out.println(array);
            if(i%3 == 2){
                array.deQueue();
                System.out.println(array);
            }
        }
    }

}
