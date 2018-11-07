public class StackMain {

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();

        for (int i = 0; i <6 ; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }

        arrayStack.pop();
        System.out.println(arrayStack);
    }
}
