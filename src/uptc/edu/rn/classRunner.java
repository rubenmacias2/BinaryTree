package uptc.edu.rn;

import java.util.ArrayList;
import uptc.edu.log.BankAccount;
import uptc.edu.log.BinaryTree;

public class classRunner {

    private static BinaryTree a;

    public static void main(String[] args) {
        a = new BinaryTree(BankAccount.compId);

        a.addNode(new BankAccount(50, "a",""));
        a.addNode(new BankAccount(20, "f",""));
        a.addNode(new BankAccount(80, "b",""));
        a.addNode(new BankAccount(10, "d",""));
        a.addNode(new BankAccount(30, "e",""));
        a.addNode(new BankAccount(40, "f",""));
        a.addNode(new BankAccount(25, "g",""));
        a.addNode(new BankAccount(75, "h",""));
        a.addNode(new BankAccount(28, "i",""));

        ArrayList<BankAccount> out = a.listPresort();
        ArrayList<BankAccount> ino = a.listInsort();
        ArrayList<BankAccount> pos = a.listPosort();
        ArrayList<BankAccount> lisdow=a.listAmplitudeTop();
        
  
        for(BankAccount v:lisdow){
            System.out.println(v);
        }
        
        
        System.out.println("presort\n");
        for (BankAccount a : out) {
            System.out.println(a);
        }
        /*
        System.out.println("\ninsort \n");
        for (BankAccount b : ino) {
            System.out.println(b);
        }

        System.out.println("\npos\n");
        for (BankAccount c : pos) {
            System.out.println(c);
        }
///*/
        

    }

}
