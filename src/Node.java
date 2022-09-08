import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> 4b95880d023cb249371fbd7264b59dea1fc35e5c

public class Node<T> {
    private T value;
    private boolean isRoot;
    private Node<T> right;
    private Node<T> center;
    private Node<T> left;
    private Node<T> parent;

    public Node(T value, Node<T> parent) {
        this.value = value;
        this.parent = parent;

        this.right = this.center = this.left = null;
    }

    public Node() {
    }

    /**
     * @return T return the value
     */
    public T getValue() {
        return value;
    }

    /**
     * @param value the value to set
     * @param root
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * @return Node<T> return the right
     */
    public Node<T> getRight() {
        return right;
    }

    /**
     * @param right the rigth to set
     */
    public void setRight(Node<T> right) {
        this.right = right;
    }


    public Node<T> getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    /**
     * @return Node<T> return the center
     */
    public Node<T> getCenter() {
        return center;
    }

    /**
     * @param center the center to set
     */
    public void setCenter(Node<T> center) {
        this.center = center;
    }

    /**
     * @return Node<T> return the left
     */
    public Node<T> getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(Node<T> left) {
        this.left = left;
    }

    /**
     * @param node<T> the node to be set into a branch
     */
    public void insertNodeToBranch(Node<T> node) {
        if (this.left == null) {
            this.setLeft(node);
            return;
        }

        if (this.right == null) {
            this.setRight(node);
            return;
        }

        if (this.center == null) {
            this.setCenter(node);
        }
    }

    /**
     * @param node<t> root node
     * Removes center node to transform a tree into a binary tree
     */
    public void transformToBinary(Node<T> node) {
        node.setCenter(null);
        Thread thread1 = new Thread (
                new Runnable() {
                    public void run() {
                        doTransform(node);
                    }

                    private void doTransform(Node<T> node2) {
                        node2.setCenter(null);
                        if (node2.left == null) {
                           return;
                        }

                        doTransform(node2.left);
                    }
                }
        );

        Thread thread2 = new Thread (
                new Runnable() {
                    public void run() {
                        doTransform(node);
                    }
                    private void doTransform(Node<T> node2) {
                        node2.setCenter(null);
                        if (node2.right == null) {
                            return;
                        }

                        doTransform(node2.right);
                    }
                }
        );

        thread1.start();
        thread2.start();
    }
<<<<<<< HEAD

    ArrayList<Node<T>> LeafList = new ArrayList<Node<T>>();
    /**
     * @param node
     * @return
     */
    public ArrayList<Node<T>> findLeaf(Node<T> node) {

        if (node == null) {
            return  null;
        } else if (node.getLeft() != null && node.getRight() != null && node.getCenter() != null){
            if (node.left != null) {
                LeafList.add(node.left);
            }

            if (node.right != null) {
                LeafList.add(node.right);
            }

            if (node.center != null) {
                LeafList.add(node.center);
            }
            

            return LeafList;
        }else{
            return findLeaf(node);
        }

    }

    public Node<T> isRoot(Node<T> root){
        if (root.getParent() == null) {
            return root;
        } else{
            return null;
        }

    }

    /*
     * public int quantLeaf(Node<T> node) {

        if (node == null) {
            return  0;
        } else if (node.getLeft() == null && node.getRight() == null && node.getCenter() == null){
            return 1;
        }else{
            return quantLeaf(node.left) + quantLeaf(node.right) + quantLeaf(node.center);
        }

    }
     */

     public int findDepth (Node<T> node, Node<T> parent){

        if (node.getParent() == null) {
            return 0;
        }else{
            return 1 + findDepth(node, node.parent);
        }
        

        

     }


     public int findHeight(Node<T> node){
        

        if (node == null) {
            return -1;
        }
        else{
            int left = findHeight(node.left);
            int right = findHeight(node.right);
            int center = findHeight(node.center);
            if (left > right) {
                return left +1;                
            } else {
                return right+1;
            }
        }
     }


    



=======
>>>>>>> 4b95880d023cb249371fbd7264b59dea1fc35e5c
    public Node<T> findElement(Node<T> node, T element) {
        if (node != null) {
            if (element.equals(node.getValue())){
                return node;
            }

<<<<<<< HEAD
            Node<T> found = findElement(node.getLeft(), element);
=======
            var found = findElement(node.getLeft(), element);
>>>>>>> 4b95880d023cb249371fbd7264b59dea1fc35e5c

            if (found != null) {
                return found;
            }

            found = findElement(node.getCenter(), element);

            if (found != null) {
                return found;
            }

            found = findElement(node.getRight(), element);

            if (found != null) {
                return found;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
