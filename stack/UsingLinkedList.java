import java.util.LinkedList;
import java.util.List;

public class StackUsingLinkedList<T> {
    private List<T> list;

    public StackUsingLinkedList() {
        list = new LinkedList<>();
    }

    public void push(T item) {
        list.add(item); // Add to end
    }

    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return list.remove(list.size() - 1); // Remove from end
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return list.get(list.size() - 1); // Peek at end
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
