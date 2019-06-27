
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import uptc.edu.log.BankAccount;
import uptc.edu.log.BinaryTree;

public class BinaryTreeTest {

    private BinaryTree<BankAccount> bt;

    public BinaryTreeTest() {

    }

    private void setupThree() {
        bt = new BinaryTree(BankAccount.compNumbAcco);
        bt.addNode(new BankAccount(30,"",""));
        bt.addNode(new BankAccount( 28,"",""));
        bt.addNode(new BankAccount(35,"",""));
        bt.addNode(new BankAccount( 23,"",""));
        bt.addNode(new BankAccount(37,"",""));
        bt.addNode(new BankAccount(10,"",""));
        bt.addNode(new BankAccount(24,"",""));
        bt.addNode(new BankAccount(36,"",""));
    }

    @Test
    public void testLevel() {
        setupThree();
        assertEquals(3, bt.levelNode(bt.findNode(new BankAccount(36,"",""))));
        assertEquals(0, bt.levelNode(bt.findNode(new BankAccount(30,"",""))));
    }

    private void setupOne() {
        bt = new BinaryTree(BankAccount.compNumbAcco);
        bt.addNode(new BankAccount(123, "","jose"));
        bt.addNode(new BankAccount(923, "","maria"));
        bt.addNode(new BankAccount(23,"", "daniel"));
        bt.addNode(new BankAccount(393, "","pedro"));
        bt.addNode(new BankAccount( 951, "","carlos"));
    }

    private void setupTwo() {
        bt = new BinaryTree(BankAccount.compNumbAcco);
        bt.addNode(new BankAccount(50,"", "a"));
        bt.addNode(new BankAccount(20,"", "b"));
        bt.addNode(new BankAccount(10,"", "c"));
        bt.addNode(new BankAccount(30, "","d"));
        bt.addNode(new BankAccount(80,"", "e"));
        bt.addNode(new BankAccount(70,"", "f"));
        bt.addNode(new BankAccount(75,"", "g"));
        bt.addNode(new BankAccount( 25,"", "g"));
        bt.addNode(new BankAccount( 28, "","g"));
    }

    @Test
    public void testListAmplitudeDown() {
        setupTwo();
        ArrayList<BankAccount> salida = bt.listAmplitudeDown();
        /*
        for (BankAccount out : salida) {
            System.out.println(out.toString());

        }
         */
    }

    @Test
    public void testWeight() {
        setupTwo();
        assertEquals(9, bt.weightTree());
    }

    @Test
    public void testHeightTree() {
        setupTwo();
        assertEquals(4, bt.heightNode(bt.findNode(new BankAccount(50,"", ""))));

    }

    @Test
    public void testFindNode() {
        setupOne();
        assertNotNull(bt.findNode(new BankAccount(623,"", "")));
        assertNull(bt.findNode(new BankAccount(23, "","")));
        assertEquals("jose", ((BankAccount) bt.findNode(new BankAccount( 123,"", "")).getInfo()).getPropietary());
    }

    @Test
    public void testFindFather() {
        setupOne();
        assertNull(bt.findFather(bt.findNode(new BankAccount(123,"", ""))));
        assertEquals(123, ((BankAccount) bt.findFather(bt.findNode(new BankAccount(923, "",""))).getInfo()).getNumberAccount());
    }

    public void setup() {
        bt = new BinaryTree(BankAccount.compNumbAcco);
        bt.addNode(new BankAccount(50, "","a"));
        bt.addNode(new BankAccount(70, "","b"));
        bt.addNode(new BankAccount(80, "","c"));
    }

    @Test
    public void testDeleteSheet() {
        setup();
        BankAccount aux = bt.deleteNode(bt.findNode(new BankAccount(80, "","")));
        assertEquals(80, aux.getNumberAccount());
        assertNull(bt.findNode(new BankAccount( 80,"", "")));
        assertEquals(2, bt.weightTree());
    }

    public void setupdeleted() {
        bt = new BinaryTree(BankAccount.compNumbAcco);
        bt.addNode(new BankAccount(50, "","a"));
        bt.addNode(new BankAccount(20,"", "b"));
        bt.addNode(new BankAccount(70, "","c"));
        bt.addNode(new BankAccount(10,"", "a"));
        bt.addNode(new BankAccount(40,"", "b"));
        bt.addNode(new BankAccount(85,"", "c"));
        bt.addNode(new BankAccount(5,"", "a"));
        bt.addNode(new BankAccount(15,"", "b"));
        bt.addNode(new BankAccount(35, "","a"));
        bt.addNode(new BankAccount(75, "","b"));
        bt.addNode(new BankAccount(90, "","c"));
        bt.addNode(new BankAccount(25, "","c"));
        bt.addNode(new BankAccount(30, "","c"));
    }

    @Test
    public void testDeleteNodeWithSons() {
        setupdeleted();
        assertEquals(14, bt.weightTree());
        bt.deleteNode(bt.findNode(new BankAccount(50,"", "")));
        assertEquals(85, bt.findNode(new BankAccount(70,"", "")).getRight().getInfo().getNumberAccount());
        assertEquals(20, bt.findNode(new BankAccount(70,"", "")).getLeft().getInfo().getNumberAccount());
        assertNull(bt.findNode(new BankAccount(50, "","")));
        assertEquals(13, bt.weightTree());
    }

}
