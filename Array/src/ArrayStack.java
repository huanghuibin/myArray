public class ArrayStack<T> implements Stack<T> {

    private Array<T> array;

    public ArrayStack(int capacity) {
        this.array = new Array<>(capacity);
    }
    public ArrayStack(){
        this.array = new Array<>();
    }

    @Override
    public void push(T t) {
        array.addLast(t);
    }

    @Override
    public T pop() {
        return array.removeLast();
    }

    @Override
    public T peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("stack: [");

        for (int i = 0; i <array.getSize() ; i++) {
            res.append(i);
            if(i != array.getSize()-1){
                res.append(", ");
            }

        }
        res.append("]");
        return res.toString();
    }
}
