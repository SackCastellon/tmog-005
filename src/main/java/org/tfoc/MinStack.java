package org.tfoc;

import java.util.Deque;
import java.util.LinkedList;

/**
 * MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * int param_3 = obj.top()
 * int param_4 = obj.getMin()
 */
public class MinStack {
    private record MinValue(int value, int size) {}

    private final Deque<Integer> values = new LinkedList<>();
    private final Deque<MinValue> minValues = new LinkedList<>();

    public void push(int value) {
        values.push(value);
        if (minValues.isEmpty() || value < minValues.peek().value) {
            minValues.push(new MinValue(value, values.size()));
        }
    }

    public void pop() {
        values.pop();
        if (values.size() < minValues.peek().size) {
            minValues.pop();
        }
    }

    public int top() {
        return values.peek();
    }

    public int getMin() {
        return minValues.peek().value;
    }
}
