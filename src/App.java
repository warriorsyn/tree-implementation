import java.util.Scanner; 

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        /* 
            Node<Integer> firstNode = new Node<Integer>();
            firstNode.setValue(10);

            Node<Integer> secondNode = new Node<Integer>(16, firstNode);

            Node<Integer> thirdNode = new Node<Integer>(97, firstNode);

            Node<Integer> forthNode = new Node<Integer>(169, firstNode);

            Node<Integer> fiftyNode = new Node<>(666, secondNode);

            firstNode.insertNodeToBranch(secondNode);
            firstNode.insertNodeToBranch(thirdNode);
            firstNode.insertNodeToBranch(forthNode);

            secondNode.insertNodeToBranch(fiftyNode);

            BTreePrinter.printNode(firstNode);
        */
        Scanner scan = new Scanner(System.in);
        

        System.out.print("enter the numbers of nodes: ");
        Integer NumberNodes = scan.nextInt();
        

        Node<Integer> root = new Node<Integer>();

        for (int i = 0; i < NumberNodes; i++) {
            System.out.print("enter value of the node: ");
            Integer nodes = scan.nextInt();

            if (i == 0) {
                root.setValue(nodes);
            } else {
                Node<Integer> node = new Node<Integer>(nodes, root);
                root.insertNodeToBranch(node);
           }
        }

        BTreePrinter.printNode(root);
        scan.close();
    }
}
