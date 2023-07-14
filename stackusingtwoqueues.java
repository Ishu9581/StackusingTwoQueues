import java.util.*;

public class stackusingtwoqueues {

    // Define the data members
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int size;

    /**
     * 
     */
    public stackusingtwoqueues() {
        // Implement the Constructor
        q1 = new java.util.LinkedList<Integer>();
        q2 = new java.util.LinkedList<Integer>();
        size = 0;
    }

    /*----------------- Public Functions of Stack -----------------*/

    public int getSize() {
        // Implement the getSize() function
        return size;
    }

    public boolean isEmpty() {
        // Implement the isEmpty() function
        return size == 0;
    }

    public void push(int element) {
        // Implement the push(element) function
        q1.add(element);
        size = size + 1;
    }

    public int pop() {
        // Implement the pop() function
        if (q1.isEmpty()) {
            return -1;
        }
        while (q1.size() != 1) {
            q2.add(q1.remove());
        }
        int top = q1.remove();

        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
        size = size - 1;
        return top;
    }

    public int top() {
        // Implement the top() function
        if (q1.isEmpty()) {
            return -1;
        }
        while (q1.size() != 1) {
            q2.add(q1.remove());
        }
        int top = q1.peek();
        q2.add(q1.remove());

        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        return top;
    }

    public static void main(String[] args) {
        stackusingtwoqueues s1 = new stackusingtwoqueues();
        s1.push(10);
        s1.push(20);
        s1.push(30);
        System.out.println(s1.top());
        s1.pop();
        System.out.println(s1.top());

    }
}
