package bags_queues_stacks;

public class TestResizingArray {
    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<>();

        System.out.println(stack.size());
        stack.push("hi");
        System.out.println(stack.size());
        stack.push("hi");
        System.out.println(stack.size());
        stack.push("hi");
        System.out.println(stack.size());
        stack.push("hi");
        System.out.println(stack.size());
        stack.push("hi");
        stack.push("hi");
        stack.push("hi");
        stack.push("hi");
        System.out.println(stack.size());
    }
}
