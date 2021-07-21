package Design.LCCI_0301_Three_in_One;

import java.util.Arrays;

public class TripleInOne {

    private int[] data;
    private int[] p;
    private int stackSize;

    public TripleInOne(int stackSize) {
        this.stackSize = stackSize;
        p = new int[3];
        for (int i = 0; i < 3; i++) p[i] = i * stackSize - 1;
        data = new int[3 * stackSize];
    }

    public void push(int stackNum, int value) {
        if (p[stackNum] < ((stackNum + 1) * stackSize - 1))
            data[++p[stackNum]] = value;
    }

    public int pop(int stackNum) {
        if (p[stackNum] == stackNum * stackSize - 1) return -1;
        return data[p[stackNum]--];
    }

    public int peek(int stackNum) {
        if (p[stackNum] == stackNum * stackSize - 1) return -1;
        return data[p[stackNum]];
    }

    public boolean isEmpty(int stackNum) {
        return p[stackNum] == stackNum * stackSize - 1;
    }
}
