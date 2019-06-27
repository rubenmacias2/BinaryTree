package uptc.edu.log;

import java.util.ArrayList;
import java.util.Comparator;

public class BinaryTree<T> {

    private Comparator<T> comparator;
    private int height;
    private TreeNode<T> root;
    private ArrayList<T> arrayAux;

    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void addNode(T info) {
        if (isEmpty()) {
            root = new TreeNode<>(info);
        } else {
            TreeNode<T> newNode = new TreeNode<>(info);
            TreeNode<T> aux = root;
            TreeNode<T> ant = null;
            while (aux != null) {
                ant = aux;
                aux = comparator.compare(aux.getInfo(), newNode.getInfo()) > 0 ? aux.getLeft() : aux.getRight();
            }
            if (comparator.compare(ant.getInfo(), newNode.getInfo()) < 0) {
                ant.setRight(newNode);
            } else {
                ant.setLeft(newNode);
            }
        }
    }

    public TreeNode<T> findNode(T info) {
        TreeNode<T> aux = root;
        while (aux != null) {
            if (comparator.compare(info, aux.getInfo()) == 0) {
                return aux;
            } else {
                aux = comparator.compare(info, aux.getInfo()) < 0 ? aux.getLeft() : aux.getRight();
            }
        }
        return null;
    }

    public int heightTree() {
        height = 0;
        height(root, 0);
        return height;
    }

    private void height(TreeNode<T> node, int value) {
        if (node != null) {
            height(node.getLeft(), value + 1);
            height = value > height ? value : height;
            height(node.getRight(), value + 1);
        }
    }

    public int weightTree() {
        return weight(root);
    }

    private int weight(TreeNode<T> node) {
        if (node != null) {
            return weight(node.getLeft()) + weight(node.getRight()) + 1;
        }
        return 0;
    }

    public int heightNode(TreeNode<T> node) {
        height = 0;
        height(node, 0);
        return height;
    }

    public int levelNode(TreeNode<T> info) {
        int cont = 0;
        TreeNode<T> aux = root;
        if (aux == info) {
            return 0;
        } else {
            while (info != aux) {
                if (aux == info) {
                    return cont;
                }
                aux = comparator.compare(aux.getInfo(), info.getInfo()) > 0 ? aux.getLeft() : aux.getRight();
                cont++;
            }
            return cont;
        }
    }

    public byte gradeNode(TreeNode<T> node) {
        byte grade = 0;
        if (node.getLeft() != null) {
            grade++;
        }
        if (node.getRight() != null) {
            grade++;
        }
        return grade;
    }

    public ArrayList<T> listPresort() {
        arrayAux = new ArrayList<>();
        presort(root);
        return arrayAux;
    }

    private void presort(TreeNode<T> node) {
        if (node != null) {
            arrayAux.add(node.getInfo());
            presort(node.getLeft());
            presort(node.getRight());
        }
    }

    public ArrayList<T> listInsort() {
        arrayAux = new ArrayList<>();
        insort(root);
        return arrayAux;
    }

    private void insort(TreeNode<T> node) {
        if (node != null) {
            insort(node.getLeft());
            arrayAux.add(node.getInfo());
            insort(node.getRight());

        }
    }

    public ArrayList<T> listPosort() {
        arrayAux = new ArrayList<>();
        posort(root);
        return arrayAux;
    }

    private void posort(TreeNode<T> node) {
        if (node != null) {
            posort(node.getLeft());
            posort(node.getRight());
            arrayAux.add(node.getInfo());
        }
    }

    public ArrayList<T> listAmplitudeDown() {
        arrayAux = new ArrayList<>();
        LinkedNodes<TreeNode<T>> tail = new LinkedNodes<>();
        tail.addEnd(root);
        while (!tail.isEmpty()) {
            TreeNode<T> aux = tail.pop();
            if (aux.getLeft() != null) {
                tail.addEnd(aux.getLeft());
            }
            if (aux.getRight() != null) {
                tail.addEnd(aux.getRight());
            }
            arrayAux.add(aux.getInfo());
        }
        return arrayAux;
    }

    public ArrayList<T> listAmplitudeTop() {
        arrayAux = new ArrayList<>();
        LinkedNodes<TreeNode<T>> tail = new LinkedNodes<>();
        tail.addEnd(root);
        while (!tail.isEmpty()) {
            TreeNode<T> aux = tail.pop();
            if (aux.getRight() != null) {
                tail.addEnd(aux.getRight());
            }
            if (aux.getLeft() != null) {
                tail.addEnd(aux.getLeft());
            }
            arrayAux.add(aux.getInfo());
        }

        ArrayList<T> array = new ArrayList<>();
        for (int i = (arrayAux.size()-1); i >= 0; i--) {
            array.add(arrayAux.get(i));
        }
        return array;
    }

    public TreeNode<T> findFather(TreeNode<T> info) {
        TreeNode<T> aux = root;
        TreeNode<T> ant = null;
        if (info == aux) {
            return null;
        } else {
            while (aux != null) {
                ant = aux;
                aux = comparator.compare(info.getInfo(), aux.getInfo()) < 0 ? aux.getLeft() : aux.getRight();
                if (aux == info) {
                    return ant;
                }
            }
            return null;
        }
    }

    public T deleteNode(TreeNode<T> node) {
        if (gradeNode(node) == 0) {
            return deleteSheet(node);
        }
        if (gradeNode(node) == 1) {
            return deleteWithSon(node);
        }
        if (gradeNode(node) == 2) {
            return deleteWithSons(node);
        }
        return null;
    }

    private T deleteSheet(TreeNode<T> node) {
        if (node == root) {
            root = null;
        } else {
            TreeNode<T> father = findFather(node);
            if (father.getLeft() == node) {
                father.setLeft(null);
            } else {
                father.setRight(null);
            }
        }
        return node.getInfo();
    }

    private T deleteWithSon(TreeNode<T> node) {
        if (node == root) {
            root = node.getLeft() != null ? root.getLeft() : root.getRight();
        } else {
            TreeNode<T> father = findFather(node);
            if (father.getRight() == node) {
                father.setRight(node.getLeft() != null ? node.getLeft() : node.getRight());
            } else {
                father.setLeft(node.getLeft() != null ? node.getLeft() : node.getRight());
            }
        }
        return node.getInfo();
    }

    private T deleteWithSons(TreeNode<T> node) {
        TreeNode<T> sustitute = node.getRight();
        TreeNode<T> fatherSustitute = null;
        while (sustitute.getLeft() != null) {
            fatherSustitute = sustitute;
            sustitute = sustitute.getLeft();
        }
        if (fatherSustitute != null) {
            fatherSustitute.setLeft(sustitute.getRight());
            sustitute.setRight(node.getRight());
        }
        sustitute.setLeft(node.getLeft());
        TreeNode<T> father = findFather(node);
        if (father != null) {
            if (father.getLeft() == node) {
                father.setLeft(sustitute);
            } else {
                father.setRight(sustitute);
            }
        } else {
            root = sustitute;
        }
        return node.getInfo();
    }

}
