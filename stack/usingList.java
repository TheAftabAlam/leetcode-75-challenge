import java.util.ArrayList;
import java.util.List;

public class StackUsingList<T> {
    private List<T> list;

    public StackUsingList() {
        list = new ArrayList<>();
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

    // Optional: for debugging
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        StackUsingList<Integer> stack = new StackUsingList<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack: " + stack); // [10, 20, 30]
        System.out.println("Pop: " + stack.pop()); // 30
        System.out.println("Peek: " + stack.peek()); // 20
        System.out.println("Stack: " + stack); // [10, 20]
    }
}
