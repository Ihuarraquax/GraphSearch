import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

import MaciezListowy.*;

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



        LGraph graph = new LGraph(11);

        graph.connect(0, 2);
        graph.connect(1, 2);
        graph.connect(2, 3);
        graph.connect(3, 1);
        graph.connect(2, 4);
        graph.connect(5, 5);
        graph.connect(5, 6);
        graph.connect(6, 5);
        graph.connect(3, 7);
        graph.connect(7, 3);
        graph.connect(7, 8);
        graph.connect(8, 7);
        graph.connect(8, 9);
        graph.connect(9, 8);
        graph.connect(9, 10);
        graph.connect(10, 9);
        graph.connect(10, 1);
        graph.connect(1, 10);

        graph.writeMatrix();





        System.out.println("Ma sciezke: " + graph.hasPathDFS(2, 9));
        System.out.println("Ma sciezke: " + graph.hasPathBFS(2, 9));

    }
}
