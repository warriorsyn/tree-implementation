import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Node<T> {
    private T value;
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

    public int findDepth(Node<T> root, T x) {
        if (root == null) {
            return -1;
        }

        int dist = -1;

        if (
                root.value == x ||(dist = findDepth(root.left, x)) >= 0 || (dist = findDepth(root.right, x)) >= 0
        ) {
            return dist + 1;
        }

        return dist;
    }

    public Node<T> findElement(Node<T> node, T element) {
        if (node != null) {
            if (element.equals(node.getValue())){
                return node;
            }

            var found = findElement(node.getLeft(), element);

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
