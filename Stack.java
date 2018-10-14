import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stack <Item>{
    private class Node {
        Item value;
        Node next;
    }
    private Node first;
    private int N = 0;
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.value = item;
        first.next = oldFirst;
        N++;
    }
    public Item pop() {
        Item item = first.value;
        first = first.next;
        N--;
        return item;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public int size() {
        return N;
    }
    public static void main(String args[]) {
        Stack<String> s = new Stack<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            StdOut.println(item);
            if (item.equals("{") || item.equals("[") || item.equals("(")) {
                s.push(item);
            } else {
                Boolean flag;
                String last = s.pop();
                if (item.equals("{")) {
                    flag = last.equals("}");
                } else if(item.equals("[")) {
                    flag = last.equals("]");
                } else {
                    flag = last.equals(")");
                }
                if (!flag) {
                    StdOut.println(false);
                    return;
                }
            }
        }
        StdOut.println(true);
    }
}
