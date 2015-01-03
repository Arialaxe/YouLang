package fxGraph;

import javafx.scene.Node;

public class FXNodeBuilder {

    private FXGraph graph;
    private Node node;
    private double positionX;
    private double positionY;

    public FXNodeBuilder(FXGraph aGraph) {
        graph = aGraph;
    }

    public FXNodeBuilder node(Node aNode) {
        node = aNode;
        return this;
    }

    public FXNodeBuilder x(double aX) {
        positionX = aX;
        return this;
    }

    public FXNodeBuilder y(double aY) {
        positionY = aY;
        return this;
    }

    public FXNode build() {
        FXNode theNode = new FXNode(graph, node);
        theNode.setPosition(positionX, positionY);

        graph.addNode(theNode);

        return theNode;
    }
}

