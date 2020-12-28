import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MyLinkedListTests {
    LinkedListAPI<Integer> myLL = new MyLinkedList();
    List<Integer> javaLL = new ArrayList<Integer>();

    private void clearLists() {
        myLL.clear();
        javaLL.clear();
    }

    @Test
    public void testAddRemove() {
        clearLists();
        for (int i = 0; i < 50; i++) {
            myLL.add(1);
            javaLL.add(1);
        }
        for (int i = 0; i < 10; i++) {
            myLL.remove(20);
            javaLL.remove(20);
        }
        Assert.assertEquals(javaLL.size(), myLL.size());
    }

    @Test
    public void testRemove() {
        clearLists();
        for (int i = 0; i < 100; i++) {
            myLL.add(i);
            javaLL.add(i);
        }
        for (int i = 0; i < 100; i++) {
            int myRemoved = myLL.remove(0);
            int javaRemoved = javaLL.remove(0);
            Assert.assertEquals(myRemoved, javaRemoved);
        }
    }

    @Test
    public void testContains() {
        clearLists();
        for (int i = 0; i < 100; i++) {
            myLL.add(i);
            javaLL.add(i);
        }
        for (int i = 0; i < 200; i++) {
            boolean myBool = myLL.contains(i);
            boolean javaBool = javaLL.contains(i);
            Assert.assertEquals(myBool, javaBool);
        }
    }
}
