package sorting.generics;

public interface IStack<T> {

    public boolean isEmpty();

    public T top() throws Exception;

    public void push(T e) throws Exception;

    public T pop() throws Exception;

}
