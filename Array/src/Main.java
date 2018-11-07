public class Main {

    public static void main(String[] args) {
        Array<Integer> array = new Array<Integer>();
        for(int i = 0;i <10;i++){
            array.addLast(i);
        }
        System.out.println(array);

        // 向指定位置插入元素
        array.addLast(1000);
        System.out.println(array);
        // 向最前面添加一个元素
        array.addFirst(-100);
        System.out.println(array);

        System.out.println(array.get(1));
        array.set(1,500);
        System.out.println(array);

        System.out.println(array.contains(1));
    }
}
