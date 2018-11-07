package linkedlist;

import java.util.List;

/**
 *  链表
 */
public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;
        public Node(E e,Node node){
            this.e = e;
            this.next = node;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

//    private Node head;
    // 本来初始化得时候是没有节点得，现在初始化要弄一个虚拟得null节点头
    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    // 想链表得头部添加元素
    public void addFirst(E e){
        // 将新增节点得下一个元素指向头部
        // 将新增得节点赋值给头部
        /*
        Node node = new Node(e);
        node.next = head;
        head = node;*/
       add(0,e);
    }

    /**
     *   练习用：在链表中得某个索引位置添加位置  ！！！ 链表是没有索引得，不经常用
     */
    public void add(int index,E e){
        if(index<0 || index>size){
            throw  new IllegalArgumentException("fail illegal");
        }


            Node pre = dummyHead;
            for (int i = 0; i < index ; i++) {
                pre = pre.next;
            }
            /**
             *  Node node = new Node(e);
             *  node.next = pre.next;
             *  pre.next = node;
             */
            pre.next = new Node(e,pre.next);
            size++;

    }

    // 获得链表中第index个位置得元素
    public E get(int index){
        if(index< 0 || index >=size-1){
            throw new IllegalArgumentException("get Failed, Illegal index");
        }
        // 先获取到第一个元素
        Node cur = dummyHead.next;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    //获取表头得元素
    public E getFirst(){
        return  get(0);
    }

    // 获取表尾得元素
    public E getLast(){
        return get(size -1);
    }


    // 判断链表中是否存在某个元素
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // 从链表中删除某个元素
    public E remove(int index){

        Node pre = dummyHead;

        for (int i = 0; i <index ; i++) {
            pre = pre.next;
        }
        // 查找到索引对应得元素
        Node delNode = pre.next;
        pre.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }
  //删除链表头元素
    public E removeFirst(){
        return  remove(0);
    }

    // 删除链表尾元素
    public E removeLast(){
        return remove(size-1);
    }



    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur !=null){
            stringBuilder.append(cur+"->");
            cur = cur.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }

    // 在末尾添加元素
    public void addLast(E e){
        add(size,e);
    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i <5 ; i++) {
            linkedList.addLast(i);
            System.out.println(linkedList);
        }
        linkedList.add(2,666);
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);

    }

}
