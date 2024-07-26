package 栈与队列;

@SuppressWarnings("unchecked")
public class MyStack<v> {

    private v[] data;
    private int capacity;  // 栈的容量
    private int count;     //  栈中元素的个数
    private int GROW_FACTOR = 2;  // 扩容因子

    public MyStack(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        this.capacity = capacity;
        this.data = (v[]) new Object[capacity];
        this.count = 0;
    }
    public MyStack() {
        this(8);
        GROW_FACTOR = 1;
    }

    // 入栈
    public void push(v value) {
        if (count == capacity) {
            if (GROW_FACTOR == 1) {
                throw new IllegalStateException("stack is full");
            }
            resize(GROW_FACTOR);  // 扩容
        }
        data[count++] = value;
    }

    public v pop() {
        if (count == 0) {
            throw new IllegalStateException("stack is empty");
        }
        return data[--count];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void resize(int GROW_FACTOR) {
        int newCapacity = this.capacity * GROW_FACTOR;
        v[] newData = (v[]) new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, capacity);
        this.data = newData;
        this.capacity = newCapacity;
    }


}
