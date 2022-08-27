public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        var firstNode = new Node<Integer>();
        firstNode.setValue(10);

        var secondNode = new Node<Integer>(16, firstNode);

        var thirdNode = new Node<Integer>(97, firstNode);

        var forthNode = new Node<Integer>(169, firstNode);

        var fiftyNode = new Node<>(666, secondNode);

        firstNode.insertNodeToBranch(secondNode);
        firstNode.insertNodeToBranch(thirdNode);
        firstNode.insertNodeToBranch(forthNode);

        secondNode.insertNodeToBranch(fiftyNode);

        BTreePrinter.printNode(firstNode);
    }
}
