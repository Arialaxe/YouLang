package fxGraph;

public class FXEdgeWayPoint {

    double positionX;
    double positionY;
    FXEdge edge;

    public FXEdgeWayPoint(FXEdge aEdge, double aPositionX, double aPositionY) {
        edge = aEdge;
        positionX = aPositionX;
        positionY = aPositionY;
    }

    public void translatePosition(double aMovementX, double aMovementY, double aZoomLevel) {
        positionX += aMovementX;
        positionY += aMovementY;

        edge.graph.updateEdge(edge, aZoomLevel);
    }
}