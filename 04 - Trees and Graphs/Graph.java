import java.util.ArrayList;
import java.util.List;

class Graph {
    List<Node> nodes;

    Graph() {
        this.nodes = new ArrayList<>();
    }
}

class Node {
    String name;
    List<Node> adj;

    Node(String name) {
        this.name = name;
        this.adj = new ArrayList<>();
    }

    void addAdj(Node node) {
        this.adj.add(node);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!getClass().isAssignableFrom(obj.getClass())) return false;

        Node other = (Node) obj;
        return this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
