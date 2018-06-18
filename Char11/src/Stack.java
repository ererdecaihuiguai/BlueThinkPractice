import java.util.EmptyStackException;

public class Stack {

    //存放对象
    private Object[] elements;
    private int size = 0;
    //堆栈的容量增长步长
    private int capacityIncrement = 10;

    //参数initialCapacity为堆栈的初始容量
    public Stack(int initialCapacity) {
        elements = new Object[initialCapacity];
    }

    public Stack(int initialCapacity, int capacityIncrement) {
        this(initialCapacity);
        this.capacityIncrement = capacityIncrement;
    }

    //向堆栈中加入一个对象
    public void push(Object object) {
        ensureCapacity();
        elements[size++] = object;
    }
/*
    //未完善版
    //从堆栈中取出一个对象
    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }
*/

    //完善版
    //从堆栈中取出一个对象
    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object object = elements[--size];
        //清除数组中已经出栈的对象引用
        elements[size] = null;
        return object;
    }

    //增加堆栈的容量
    private void ensureCapacity() {
        if (elements.length == size) {
            Object[] oldElements = elements;
            elements = new Object[elements.length + capacityIncrement];
            //把原数组的内容复制到新数组中
            System.arraycopy(oldElements, 0, elements, 0, size);
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(1000);
        for (int a = 0; a < 1000; a++) {
            stack.push(a);
        }
        System.out.println("stack的长度是" + stack.size);
        for (int a = 0; a < 1000; a++) {
            System.out.println(stack.pop());
        }
    }
}
