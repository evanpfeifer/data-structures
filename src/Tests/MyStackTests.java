import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class MyStackTests {
    StackAPI<Integer> myStack = new MyStack<Integer>();
    Stack<Integer> javaStack = new Stack<Integer>();

    private void clearStacks() {
        myStack.clear();
        javaStack.clear();
    }
    @Test
    public void testPushPop() {
        clearStacks();
        for (int i = 0; i < 100; i++) {
            myStack.push(i);
            javaStack.push(i);
        }
        for (int i = 0; i < 100; i++) {
            int myRemove = myStack.pop();
            int javaRemove = javaStack.pop();
            Assert.assertEquals(myRemove, javaRemove);
        }
        Assert.assertEquals(myStack.size(), javaStack.size());
    }
    @Test
    public void testContains() {
        clearStacks();
        for (int i = 0; i < 100; i++) {
            myStack.push(i);
            javaStack.push(i);
        }
        for (int i = 0; i < 200; i++) {
            boolean myBool = myStack.contains(i);
            boolean javaBool = javaStack.contains(i);
            Assert.assertEquals(myBool, javaBool);
        }
    }
    @Test
    public void testRemove() {
        clearStacks();
        for (int i = 0; i < 100; i++) {
            myStack.push(i);
            javaStack.push(i);
        }
        for (int i = 0; i < 100; i++) {
            int myRemoved = myStack.pop();
            int javaRemoved = javaStack.pop();
            Assert.assertEquals(myRemoved, javaRemoved);
        }
    }
}
