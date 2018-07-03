import java.util.HashSet;

public class Main {
    public static void main(String[] args) {



        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        Node node7 = new Node(7);

        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);


        node1.addSasiad(node2);
        node1.addSasiad(node8);
        node1.addSasiad(node9);

        node2.addSasiad(node3);
        node2.addSasiad(node4);

        node4.addSasiad(node5);
        node4.addSasiad(node6);

        node8.addSasiad(node9);
        node8.addSasiad(node10);

        node9.addSasiad(node10);

        System.out.println(node1.hasPathBFS(node7));

    }
}
