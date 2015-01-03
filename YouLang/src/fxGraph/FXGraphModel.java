package fxGraph;

import javafx.scene.Node;

import java.util.*;

public class FXGraphModel {

    private Map<Node, FXNode> nodes;
    private Set<FXEdge> edges;

    public FXGraphModel() {
        nodes = new HashMap<Node, FXNode>();
        edges = new HashSet<FXEdge>();
    }

    public void registerNewNode(FXNode aNode) {
        nodes.put(aNode.wrappedNode, aNode);
    }

    public Collection<FXNode> getNodes() {
        return nodes.values();
    }

    public void registerNewEdge(FXEdge aEdge) {
        edges.add(aEdge);
    }

    public Set<FXEdge> getEdges() {
        return edges;
    }
}
