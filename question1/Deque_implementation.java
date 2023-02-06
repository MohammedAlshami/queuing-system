import java.util.*;

public class Deque_implementation {
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
        System.out.println("Size: " + s.size());

        System.out.println("Dequeue: " + s.dequeue());
        System.out.println("Dequeue: " + s.dequeue());
        System.out.println("Stack: " + s.getQueue());
        System.out.println("Size: " + s.size());
    }
    
  }
  

interface IQueuable {
    // adds value to queue and returns new queue
    public Deque<String> enqueue(String value);

    // removes item from queue, and returns the item removed
    public String dequeue();

    // returns a list of all the items in the queue
    public Deque<String> getQueue();

    // returns the number of items in the queue
    public int size();

}

class QUEUE implements IQueuable {

    private Deque<String> queue;

    // initializing the queue
    public QUEUE() {
        queue =  new LinkedList<>();
    }

    // adds value to queue and returns new queue
    public Deque<String> enqueue(String value) {
        queue.push(value);
        return queue;
    }

    // removes item from queue, and returns the item removed
    public String dequeue() {
        if (!queue.isEmpty()) {
            String returnValue = queue.removeFirst();
            return returnValue;
        }
        return null;
    }

    // returns a list of all the items in the queue
    public Deque<String> getQueue() {
        return queue;
    }

    // returns the number of items in the queue
    public int size() {
        return queue.size();
    }

}

class STACK implements IQueuable {
    private Deque<String> stack;

    // initializing the queue
    public STACK() {
        stack =new LinkedList<>();
    }

    // adds value to queue and returns new queue
    public Deque<String> enqueue(String value) {
        stack.add(value);
        return stack;
    }

    // removes item from queue, and returns the item removed
    public String dequeue() {
        if (!stack.isEmpty()) {
            String returnValue = stack.removeLast();
            return returnValue;
        }
        return null;
    }

    // returns a list of all the items in the queue
    public Deque<String> getQueue() {
        return stack;
    }

    // returns the number of items in the queue
    public int size() {
        return stack.size();
    }
}