import java.util.ArrayList;

public class Node<T> {
    private T value;
    private Node<T> right;
    private Node<T> center;
    private Node<T> left;
    private Node<T> parent;
    private Node<T> rootNode;
    private int height;

    public Node(T value, Node<T> parent) {
        this.value = value;
        this.parent = parent;

        this.right = this.center = this.left = null;
    }

    public Node(T value, Node<T> parent, Node<T> rootNode) {
        this.value = value;
        this.parent = parent;
        this.rootNode = rootNode;
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
     * @return parent of a node
     */
    public Node<T> getParent() {
        return parent;
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

    public void setRootNode(Node<T> root) {
        this.rootNode = root;
    }
    /**
     * @param node<T> the node to be set into a branch
     */
    public void insertNodeToBranch(Node<T> node) throws Exception {
        verifyDuplicatedValues(node.getValue());
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

    /**
     * @return boolean
     */

    public boolean isLeaf() {
        if (this.right == null && this.center == null && this.left == null) {
            return true;
        }

        return false;
    }

    /**
     * @return node degree
     */
    public int getNodeDegree() {
        int degree = 0;
        if (this.getLeft() != null) {
            degree++;
        }

        if (this.getCenter() != null) {
            degree++;
        }

        if (this.getRight() != null) {
            degree++;
        }

        return degree;
    }

    /**
     * @param node
     * @return tree degree
     */
    public int getTreeDegree(Node<T> node) {
        int treeDegree = 0;

        if (node != null) {
              getTreeDegree(node.getLeft());


            if (node.getLeft() != null) {
                if (node.getLeft().getNodeDegree() > treeDegree) {
                    treeDegree = node.getLeft().getNodeDegree();
                }
            }

            getTreeDegree(node.getCenter());
            if (node.getCenter() != null) {
                if (node.getCenter().getNodeDegree() > treeDegree) {
                    treeDegree = node.getCenter().getNodeDegree();
                }
            }


            getTreeDegree(node.getRight());
            if (node.getRight() != null) {
                if (node.getRight().getNodeDegree() > treeDegree) {
                    treeDegree = node.getRight().getNodeDegree();
                }
            }

        }

        return treeDegree;
    }

    /**
     * @return of node is root
     */
    public boolean isRoot(){
        return this.getParent() == null;
    }

    /**
     * @param root root node
     * @param x value of a node
     * @return depth number
     */
    public int findDepth(Node<T> root, T x) {
        if (root == null) {
            return -1;
        }

        int dist = -1;

        if (
                root.value == x ||(dist = findDepth(root.left, x)) >= 0 || (dist = findDepth(root.center, x)) >= 0 || (dist = findDepth(root.right, x)) >= 0
        ) {
            return dist + 1;
        }

        return dist;
    }

    private int findHeightUtil(Node root, T x)
    {
        // Base Case
        if (root == null)
        {
            return -1;
        }

        int leftHeight = findHeightUtil(root.left, x);

        int rightHeight = findHeightUtil(root.right, x);

        int ans = Math.max(leftHeight, rightHeight) + 1;

        if (root.value == x)
            height = ans;

        return ans;
    }

    /**
     * @return number of the height node
     */
    public int findHeight(Node root, T x)
    {
        findHeightUtil(root, x);

        return height;
    }

    /**
     * @return search element
     */
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

    /**
     * @return report of nodes
     */
    public void extractData(Node<T> node) {
        if (node != null) {
            if (node.isRoot()) {
                rootNode = node;
            }

            extractData(node.getLeft());

            if (node.getLeft() != null) {
                System.out.println("Depth of node " + node.getLeft() + ": " + rootNode.findDepth(rootNode, node.getLeft().getValue()));
                System.out.println("Height of node " + node.getLeft() + ": " + rootNode.findHeight(rootNode, node.getLeft().getValue()));
                System.out.println("Is node " + node.getLeft() + " a leaf?: " + (node.getLeft().isLeaf() ? "Is a leaf" : " Is internal node"));
                System.out.println("The degree of node " + node.getLeft() + " is: " + node.getLeft().getNodeDegree());
                System.out.println("-------------------------------------------------------------------------------------------------");
            }

            extractData(node.getCenter());

            if (node.getCenter() != null) {
                System.out.println("Depth of node " + node.getCenter() + ": " + rootNode.findDepth(rootNode, node.getCenter().getValue()));
                System.out.println("Height of node " + node.getCenter() + ": " + rootNode.findHeight(rootNode, node.getCenter().getValue()));
                System.out.println("Is node " + node.getCenter() + " a leaf?: " + (node.getCenter().isLeaf() ? "Is a leaf" : " Is internal node"));
                System.out.println("The degree of node " + node.getCenter() + " is: " + node.getCenter().getNodeDegree());
                System.out.println("-------------------------------------------------------------------------------------------------");
            }

            extractData(node.getRight());

            if (node.getRight() != null) {
                System.out.println("Depth of node " + node.getRight() + ": " + rootNode.findDepth(rootNode, node.getRight().getValue()));
                System.out.println("Height of node " + node.getRight() + ": " + rootNode.findHeight(rootNode, node.getRight().getValue()));
                System.out.println("Is node " + node.getRight() + " a leaf?: " + (node.getRight().isLeaf() ? "Is a leaf" : " Is internal node"));
                System.out.println("The degree of node " + node.getRight() + " is: " + node.getRight().getNodeDegree());
                System.out.println("-------------------------------------------------------------------------------------------------");
            }
        }
    }

    private void verifyDuplicatedValues(T element) throws Exception {
        if (findElement(this.rootNode, element) != null) {
          throw new Exception("The value of the node you trying to create already exists!");
        }
    }
    @Override
    public String toString() {
        return value.toString();
    }
}
