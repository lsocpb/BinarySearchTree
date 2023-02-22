import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestBST {
    @Test
    public void testInsert(){
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(7);
        bst.insert(12);
        bst.insert(20);
        bst.insert(3);
        bst.insert(8);
        bst.insert(13);
        bst.insert(18);
        bst.insert(25);
        List<Integer> expected = Arrays.asList(10, 5, 15, 3, 7, 12, 20, 8, 13, 18, 25);
        assertArrayEquals(expected.toArray(), bst.levelOrderTraversalToList().toArray());
    }

    @Test
    public void testDelete(){
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(7);
        bst.insert(12);
        bst.insert(20);
        bst.insert(3);
        bst.insert(8);
        bst.insert(13);
        bst.insert(18);
        bst.insert(25);
        bst.deleteKey(20);
        bst.deleteKey(5);
        bst.deleteKey(7);
        List<Integer> expected = Arrays.asList(10, 3, 15, 8, 12, 18, 25);
        assertArrayEquals(expected.toArray(), bst.levelOrderTraversalToList().toArray());
    }

}
