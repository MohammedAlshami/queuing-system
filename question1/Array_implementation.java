import java.util.*;

public class Array_implementation {
    public static void main(String[] args) {
        QUEUE q = new QUEUE();
        System.out.println("Queue implementation");
        System.out.println("Enqueue: " + q.enqueue("Person 1"));
        System.out.println("Enqueue: " + q.enqueue("Person 2"));
        System.out.println("Enqueue: " + q.enqueue("Person 3"));
        System.out.println("Size: " + q.size());

        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Queue: " + q.getQueue());
        System.out.println("Size: " + q.size());

        System.out.println("\nStack implementation");
        STACK s = new STACK();
        System.out.println("Enqueue: " + s.enqueue("Person 1"));
        System.out.println("Enqueue: " + s.enqueue("Person 2"));
        System.out.println("Enqueue: " + s.enqueue("Person 3"));
        System.out.println("Dequeue: " + s.dequeue());
        System.out.println("Dequeue: " + s.dequeue());
        System.out.println("Stack: " + s.getQueue());
        System.out.println("Size: " + s.size());
    }

}

interface IQueuable {
    // adds value to queue and returns new queue
    public ArrayList<String> enqueue(String value);

    // removes item from queue, and returns the item removed
    public String dequeue();

    // returns a list of all the items in the queue
    public ArrayList<String> getQueue();

    // returns the number of items in the queue
    public int size();

}

class QUEUE implements IQueuable {
    private ArrayList<String> queue;

    // initializing the queue
    public QUEUE() {
        queue = new ArrayList<String>();
    }

    // adds value to queue and returns new queue
    public ArrayList<String> enqueue(String value) {
        queue.add(value);
        return queue;
    }

    // removes item from queue, and returns the item removed
    public String dequeue() {
        if (!queue.isEmpty()) {
            String returnValue = queue.remove(0);
            return returnValue;
        }
        return null;
    }

    // returns a list of all the items in the queue
    public ArrayList<String> getQueue() {
        return queue;
    }

    // returns the number of items in the queue
    public int size() {
        return queue.size();
    }

}

class STACK implements IQueuable {
    private ArrayList<String> stack;

    // initializing the queue
    public STACK() {
        stack = new ArrayList<String>();
    }

    // adds value to queue and returns new queue
    public ArrayList<String> enqueue(String value) {
        stack.add(value);
        return stack;
    }

    // removes item from queue, and returns the item removed
    public String dequeue() {
        if (!stack.isEmpty()) {
            int index = stack.size() - 1;
            String returnValue = stack.remove(index);
            return returnValue;
        }
        return null;

    }

    // returns a list of all the items in the queue
    public ArrayList<String> getQueue() {
        return stack;
    }

    // returns the number of items in the queue
    public int size() {
        return stack.size();
    }
}