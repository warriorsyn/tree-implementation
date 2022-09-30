import com.sun.jdi.request.DuplicateRequestException;

import java.util.Scanner;

public class App {
    private static void handleAddNodesToRoot(int value, Node root, Scanner scan) {
        boolean hasDuplicityError = false;

        do {
            if (hasDuplicityError) {
                System.out.print("enter value of the node: ");
                value = scan.nextInt();
            }

            Node<Integer> node = new Node<>(value, root);
            node.setRootNode(root);

            try {
                root.insertNodeToBranch(node);
                hasDuplicityError = false;
            } catch(DuplicateRequestException e) {
                System.out.println(e.getMessage());
                hasDuplicityError = true;
            }
        } while (hasDuplicityError);

        BTreePrinter.printNode(root);
    }

    private static void handleAddNodesToBranches(int value, Node root, Scanner scan, int j, int i) throws DuplicateRequestException {
        boolean firstExec = true;
        int branchNode = 0;

        if (j != i) {
            firstExec = false;
        }

        if (firstExec) {
            System.out.print("In which node do you want to insert this value to branch? : ");
            branchNode = scan.nextInt();
        }

        if (!firstExec) {
            System.out.print("enter value of the node: ");
            value = scan.nextInt();
            System.out.print("In which node do you want to insert this value to branch? : ");
            branchNode = scan.nextInt();
        }

        var foundNode = root.findElement(root, branchNode);

        if (foundNode != null) {
            boolean hasDuplicityError = false;
            do {
                if (hasDuplicityError) {
                    System.out.print("enter value of the node: ");
                    value = scan.nextInt();
                }

                var newNode = new Node<>(value, foundNode, root);

                try {
                    foundNode.insertNodeToBranch(newNode);
                    hasDuplicityError = false;
                } catch(DuplicateRequestException e) {
                    System.out.println(e.getMessage());
                    hasDuplicityError = true;
                }
            } while (hasDuplicityError);
            BTreePrinter.printNode(root);
        }
    }
    public static void main(String[] args) throws DuplicateRequestException {
        Scanner scan = new Scanner(System.in);

        System.out.print("enter the numbers of nodes: ");
        Integer NumberNodes = scan.nextInt();

        Node<Integer> root = new Node<Integer>();

        for (int i = 0; i < NumberNodes; i++) {
            System.out.print("enter value of the node: ");
            int value = scan.nextInt();

            if (i == 0) {
                root.setValue(value);
                root.setRootNode(root);
            } else {
                if (root.getLeft() != null && root.getCenter() != null && root.getRight() != null) {
                       for (int j = i; j < NumberNodes; j++){
                           handleAddNodesToBranches(value, root, scan, j, i);
                       }
                } else {
                    handleAddNodesToRoot(value, root, scan);
                }
           }
        }

        System.out.println("-----------------------------");
        System.out.println("Binary Tree");

        root.transformToBinary(root);
        BTreePrinter.printNode(root);

        System.out.println("-----------------------------");
        System.out.println("Search Binary Tree");

        Node.convertToSearchBinaryTree(root);
        BTreePrinter.printNode(root);
        
        System.out.println("-----------------------------");
        root.extractData(root);
        System.out.println("The tree degree is: " + root.getTreeDegree(root));
        System.out.println("The height of the tree is: " + root.findHeight(root, root.getValue()));
        System.out.println("The depth of the tree is: " + root.findDepth(root, root.getValue()));
        scan.close();
    }
}
