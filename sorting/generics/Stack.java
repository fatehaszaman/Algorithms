package sorting.generics;

public class Stack<T> implements IStack<T> {
    private T [] data;
    private int top;

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        this.data = (T []) new Object[size];
        this.top = -1;
    }

    @Override
    public boolean isEmpty() {
        return (this.top < 0);
    }

    @Override
    public T top() throws Exception{
        if (this.isEmpty())
            throw new Exception("Stack is empty!");

        return this.data[this.top];
    }

    @Override
    public void push(T e) throws Exception {
        if (this.top == this.data.length - 1)
            throw new Exception("Stack is full!");

        this.data[++this.top] = e;
    }

    @Override
    public T pop() throws Exception {
        if (this.isEmpty())
            throw new Exception("Stack is empty!");

        return this.data[this.top--];
    }
}

