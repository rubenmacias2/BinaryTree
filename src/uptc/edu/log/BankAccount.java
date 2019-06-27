package uptc.edu.log;

import java.util.Comparator;

public class BankAccount {

    private String id;
    private int numberAccount;
    private String propietary;

    public BankAccount(int numberAccount,String id, String propietary) {
        this.id = id;
        this.numberAccount = numberAccount;
        this.propietary = propietary;
    }

    public static Comparator<BankAccount> compId = new Comparator<BankAccount>() {
        @Override
        public int compare(BankAccount o1, BankAccount o2) {
            return o1.getId().compareTo(o2.getId());
        }
    };

    public static Comparator<BankAccount> compNumbAcco = new Comparator<BankAccount>() {
        @Override
        public int compare(BankAccount o1, BankAccount o2) {
            return o1.getNumberAccount() - o2.getNumberAccount();
        }
    };

    public static Comparator<BankAccount> compPro = new Comparator<BankAccount>() {
        @Override
        public int compare(BankAccount o1, BankAccount o2) {
            return o1.getPropietary().compareTo(o2.getPropietary());
        }
    };

    public int getNumberAccount() {
        return numberAccount;
    }

    public String getId() {
        return id;
    }

    public String getPropietary() {
        return propietary;
    }

    @Override
    public String toString() {
        return "BankAccount{" + "id=" + id + ", numberAccount=" + numberAccount + ", propietary=" + propietary + '}';
    }

}
