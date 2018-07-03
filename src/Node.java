import java.util.*;

public class Node {
    int id;
    ArrayList<Node> sasiednie = new ArrayList<>();

    public Node(int id) {
        this.id = id;
    }

    public void addSasiad(Node node) {
        this.sasiednie.add(node);
        node.sasiednie.add(this);
    }

    public boolean hasPathDFS(Node destination) {

        if (this.sasiednie.contains(destination)) {
            return true;
        }
        HashSet<Integer> visited = new HashSet<>();
        visited.add(this.id);

        for (Node child : this.sasiednie) {
            if (child.hasPathDFS(destination, visited)) return true;
        }
        return false;
    }

    private boolean hasPathDFS(Node destination, HashSet<Integer> visited) {
        if (visited.contains(this.id)) {
            return false;
        }
        visited.add(this.id);

        if (this.sasiednie.contains(destination)) {
            return true;
        }
        for (Node child : this.sasiednie) {
            if (child.hasPathDFS(destination, visited)) return true;
        }
        return false;
    }


    public boolean hasPathBFS(Node destination) {
        if (this.sasiednie.contains(destination)) {
            return true;
        }
        List<Node> kolejka = new LinkedList<>();

        HashSet<Integer> visited = new HashSet<>();
        visited.add(this.id);


        for(Node child : this.sasiednie){
            kolejka.add(child);
        }
        while(!kolejka.isEmpty()){
            if(((LinkedList<Node>) kolejka).remove().hasPathBFS(destination,visited, kolejka)) return true;
        }
        return false;


    }

    private boolean hasPathBFS(Node destination, HashSet<Integer> visited, List<Node> kolejka) {
        if(visited.contains(this.id)){
            return false;
        }
        visited.add(this.id);
        if(this.sasiednie.contains(destination)) return true;

        while(!kolejka.isEmpty()){
            if(((LinkedList<Node>) kolejka).remove().hasPathBFS(destination,visited, kolejka)) return true;
        }

        for(Node child : this.sasiednie){
            kolejka.add(child);
        }
        return false;
    }
}
