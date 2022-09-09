import java.util.Scanner; 

public class App {
    public static void main(String[] args) throws Exception {

        

        
        Scanner scan = new Scanner(System.in);

        System.out.print("enter the numbers of nodes: ");
        Integer NumberNodes = scan.nextInt();

        Node<Integer> root = new Node<Integer>();

        for (int i = 0; i < NumberNodes; i++) {
            System.out.print("enter value of the node: ");
            int value = scan.nextInt();

            if (i == 0) {
                root.setValue(value);
            } else {
                if (root.getLeft() != null && root.getCenter() != null && root.getRight() != null) {
                       for (int j = i; j < NumberNodes; j++){
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
                                       var newNode = new Node<>(value, foundNode);
                                       foundNode.insertNodeToBranch(newNode);

                                       BTreePrinter.printNode(root);
                               }
                       }
                } else {

                    Node<Integer> node = new Node<Integer>(value, root);
                    root.insertNodeToBranch(node);
                    BTreePrinter.printNode(root);
                }

           }
        }

        // System.out.println("-----------------------------");
        // System.out.println("Binary Tree");

        // root.transformToBinary(root);

        // BTreePrinter.printNode(root);
        // root.findElement(root, 1);
    /*   System.out.println(root.findLeafLeft(root));
       System.out.println(root.findLeafRight(root));
       System.out.println(root.findDepth(root, 5));
       System.out.println(root.findHeight(root, 5));*/

        root.extractData(root);
        System.out.println("The tree degree is: " + root.getTreeDegree(root));
        System.out.println("The height of the tree is: " + root.findHeight(root, root.getValue()));
        System.out.println("The depth of the tree is: " + root.findDepth(root, root.getValue()));
        scan.close();
        
    }
         
}
