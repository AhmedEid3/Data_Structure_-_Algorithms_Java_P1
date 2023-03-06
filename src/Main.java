import ds.ArrayQueue;
import ds.PriorityQueue;
import ds.QueueWithTwoStack;

import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        var queue = new PriorityQueue(5);
        queue.enqueue(30);
        queue.enqueue(10);
        queue.enqueue(50);
        queue.enqueue(40);
        queue.enqueue(20);

        System.out.println(queue.peek());

        System.out.println(queue);

        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println(queue);
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
    }

    public static void reverseQueue(Queue<Integer> queue) {
        var stack = new Stack<Integer>();

        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

    }

}