package fxGraph;

import javafx.scene.input.MouseEvent;

public abstract class FXTool {

    public abstract void mousePressedOnNode(MouseEvent aEvent, FXNode aNode);

    public abstract void mousePressedOnEdge(MouseEvent aEvent, FXEdge aEdge);

    public abstract void mousePressedOnEdgeWayPoint(MouseEvent aEvent, FXEdgeWayPoint aWayPoint);

    public abstract void mousePressed(MouseEvent aEvent);

    public abstract void mouseDragged(MouseEvent aEvent);

    public abstract void mouseReleased(MouseEvent aEvent);
}
