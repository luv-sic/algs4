public class FixedCapacityStackOfStrings {
    private int N = 0;
    private String[]items;
    FixedCapacityStackOfStrings(int cap) {
        items = new String[cap];
    }
    public void push(String item) {
        items[N++] = item;
    }
    public String pop() {
        return items[--N];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public int size() {
        return N;
    }
    public boolean isFull() {
        return items.length == N;
    }
    public static void main(String args[]) {
        FixedCapacityStackOfStrings a = new FixedCapacityStackOfStrings(3);
        a.push("11");
        a.push("22");
        a.push("33");
        a.pop();
        a.push("33");
        System.out.println(a.isFull());
        System.out.println(a.size());
    }
}
