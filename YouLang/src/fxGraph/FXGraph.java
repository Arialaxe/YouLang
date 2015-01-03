package fxGraph;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

public class FXGraph extends ScrollPane {

    static final double NODES_Z_OFFSET = 10;
    static final double EDGES_Z_OFFSET = 10;

    Pane contentPane;

    FXGraphModel model;
    FXGraphSelectionTool selectionTool;
    FXGraphZoomHandler zoomHandler;

    FXTool currentTool;

    private FXGraphMouseHandler mouseHandler;

    public FXGraph() {

        model = new FXGraphModel();

        setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
        contentPane = new Pane();
        setContent(contentPane);

        zoomHandler = new FXGraphZoomHandler(this);
        selectionTool = new FXGraphSelectionTool(contentPane, model, zoomHandler);
        mouseHandler = new FXGraphMouseHandler(this);

        mouseHandler.registerHandlerFor(contentPane);

        currentTool = selectionTool;
    }

    void updateEdge(FXEdge aEdge, double aZoomLevel) {
        aEdge.removeAllNodes(contentPane);
        aEdge.computeDisplayShape(aZoomLevel);
        aEdge.addAllNodes(contentPane, EDGES_Z_OFFSET);
        mouseHandler.registerNewEdge(aEdge);
    }

    void updateEdgeNodesFor(FXNode aNode, double aZoomLevel) {
        for (FXEdge theEdge : model.getEdges()) {
            if (theEdge.source == aNode || theEdge.destination == aNode) {
                updateEdge(theEdge, aZoomLevel);
            }
        }
    }

    void updateEdgeNodesFor(FXNode aNode) {
        updateEdgeNodesFor(aNode, zoomHandler.currentZoomLevel);
    }

    public void updateSelectionInScene() {
        selectionTool.updateSelectionInScene();
    }

    public void addNode(FXNode aNode) {

        aNode.wrappedNode.setTranslateZ(NODES_Z_OFFSET);

        contentPane.getChildren().add(aNode.wrappedNode);

        model.registerNewNode(aNode);
        mouseHandler.registerNewNode(aNode);
    }

    public void addEdge(FXEdge aEdge) {

        aEdge.computeDisplayShape(zoomHandler.currentZoomLevel);

        aEdge.addAllNodes(contentPane, EDGES_Z_OFFSET);
        model.registerNewEdge(aEdge);

        mouseHandler.registerNewEdge(aEdge);
    }
}
