import java.util.Scanner; 

public class App {
    public static void main(String[] args) throws Exception {
<<<<<<< HEAD
        System.out.println("Hello, World!");
        
            Node<Integer> firstNode = new Node<Integer>();
            firstNode.setValue(10);

            Node<Integer> secondNode = new Node<Integer>(16, firstNode);

            Node<Integer> thirdNode = new Node<Integer>(97, firstNode);

            Node<Integer> forthNode = new Node<Integer>(169, firstNode);

            Node<Integer> fiftyNode = new Node<>(66, secondNode);

            Node<Integer> sixthNode = new Node<>(52, forthNode);
            Node<Integer> seventhNode = new Node<>(60, secondNode);

            firstNode.insertNodeToBranch(secondNode);
            firstNode.insertNodeToBranch(thirdNode);
            firstNode.insertNodeToBranch(forthNode);

            secondNode.insertNodeToBranch(fiftyNode);
            secondNode.insertNodeToBranch(seventhNode);
            
            forthNode.insertNodeToBranch(sixthNode);
            

            BTreePrinter.printNode(firstNode);
            System.out.println(firstNode.findHeight(secondNode));
        
        /*
         Scanner scan = new Scanner(System.in);
        

=======
        Scanner scan = new Scanner(System.in);
>>>>>>> 4b95880d023cb249371fbd7264b59dea1fc35e5c
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

        System.out.println("-----------------------------");
        System.out.println("Binary Tree");

        root.transformToBinary(root);

        BTreePrinter.printNode(root);
        root.findElement(root, 1);
        scan.close();
        */
    }
         
}
