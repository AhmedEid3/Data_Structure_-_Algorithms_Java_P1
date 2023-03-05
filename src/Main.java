import ds.Stack;

public class Main {
    public static void main(String[] args) {

        var stack = new Stack();

        stack.push(1);
        stack.push(12);
        stack.push(41);

        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        System.out.println(stack.isEmpty());
    }

}