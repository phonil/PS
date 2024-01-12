package theme4;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int info;
    boolean visited;
    List<Node> neighbours;

    public Node(int info) {
        this.info = info;
        this.visited = false;
        this.neighbours = new ArrayList<>();
    }

    public void addNeighbours(Node neighboursNode) {
        this.neighbours.add(neighboursNode);
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Node> neighbours) {
        this.neighbours = neighbours;
    }

    public String toString() {
        return "" + info;
    }

}
