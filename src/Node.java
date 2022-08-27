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

    @Override
    public String toString() {
        return value.toString();
    }
}
