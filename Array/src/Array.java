import java.util.Objects;

/**
 * 二次封装自己得数组
 *
 *    拓展数组为泛型
 */
public class Array<T> {

    private T[] arr;
    //数组中有效长度
    private int size;

    //创建一个有参数得构造方法来初始化这个数组
    public Array(int capacity){
        arr =(T[]) new Object[capacity];
        size = 0;
    }

    // 申明一个无参数得构造方法， 来初始化一个容量为10得数组
    public Array(){
        this(10);
    }

    //获得数组得长度
    public int getSize(){
        return size;
    }

    // 获取数组得容量
    public int getCapacity(){
        return arr.length;
    }

    // 判断数组是否为空
    public boolean isEmpty(){
        return size==0;
    }

    // 像数组末尾添加元素
    public void addLast(T e){
        // 判断当前数组长度是否足够存放
//        if(size == arr.length){
//            throw  new IllegalArgumentException("addLast fail,this arr is full");
//        }
//        arr[size] = e;
//        size++;
        add(size,e);
    }

    // 在数组第一位插入元素
    public void addFirst(T e){
        add(0,e);
    }


    // 向数组得指定内位置插入元素
    public void add(int index, T e){
        if(index<0 || index>size){
            throw  new IllegalArgumentException("this index too large");
        }
        if(size == arr.length){
            // 扩容数组得数量
            resize(2 * arr.length);
        }
        for(int i = size-1 ;i>=index ;i--){
            arr[i+1] =arr[i];
        }
        arr[index] = e;
        size ++;

    }

    private void resize(int capacity) {
        T[] newData =(T[]) new Object[capacity];
        for (int i = 0; i <size ; i++) {
            newData[i] = arr[i];
        }
        arr = newData;
    }

    // 获取某个索引对应得值
    public T get(int index){
        if(index < 0 || index>=size){
            throw  new IllegalArgumentException("get fail,index is illegal");
        }
        return arr[index];
    }

    // 判断数组中是否包含某个值
    public boolean contains(T e){
        for (int i = 0; i <size ; i++) {
            if(arr[i].equals(e)){
                return true;
            }
        }
        return  false;
    }
    // 找出元素所对应得索引，如果存在返回对应索引得值，不存在就返回-1
    public int find(T e){
        for (int i = 0; i <size ; i++) {
            if(arr[i] .equals(e)){
                return i;
            }
        }
        return -1;
    }

    // 根据索引删除某个元素，并且返回这个元素得值
    public T remove(int index){
        if(index < 0 || index>=size){
            throw  new IllegalArgumentException("get fail,index is illegal");
        }
        T res = arr[index];
        for (int i = index+1; i <size ; i++) {
            arr[i-1] = arr[i];
        }
        size--;
        arr[size] = null; // 放这个size指定得对象变为null，自动回收垃圾
         if(size == arr.length/4 && arr.length /2 != 0){
             resize(arr.length /2 );
         }
        return res;
    }

    // 删除数组中得第一个元素
    public T removeFirst(){
        return  remove(0);
    }
    // 删除数组中最后一个元素
    public T removeLast(){
        return remove(size-1);
    }

    // 删除某个元素
    public boolean removeElement(T e){
        int i = find(e);
        return i != -1;
    }

    // 修改某个索引对应得值
    public void set(int index, T e){
        if(index < 0 || index>=size){
            throw  new IllegalArgumentException("get fail,index is illegal");
        }
        arr[index] = e;
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d ,capacity=%d \n",size,arr.length));
        res.append("[");
        for(int i=0;i<size;i++){
            res.append(arr[i]);
            if(i != size-1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    // 获取最后一个元素
    public T getLast(){
        return get(size-1);
    }

    // 获取第一个元素
    public T getFirst(){
        return  get(0);
    }

}
