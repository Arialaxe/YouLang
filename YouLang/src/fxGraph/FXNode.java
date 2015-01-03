package fxGraph;

import javafx.scene.Node;

public class FXNode {

    Node wrappedNode;

    FXGraph owner;

    double positionX;

    double positionY;

    FXNode(FXGraph aOwner, Node aNode) {
        wrappedNode = aNode;
        owner = aOwner;
        aNode.setUserData(this);
    }

    public void setPosition(double aPositionX, double aPositionY) {
        wrappedNode.relocate(aPositionX, aPositionY);
        positionX = aPositionX;
        positionY = aPositionY;

        owner.updateEdgeNodesFor(this);
    }

    public void translatePosition(double aMovementX, double aMovementY, double aZoomLevel) {
        wrappedNode.setLayoutX(wrappedNode.getLayoutX() + aMovementX);
        wrappedNode.setLayoutY(wrappedNode.getLayoutY() + aMovementY);

        positionX += aMovementX / aZoomLevel;
        positionY += aMovementY / aZoomLevel;

        owner.updateEdgeNodesFor(this);
    }

    public void setZoomLevel(double aZoomLevel) {
        wrappedNode.setLayoutX(positionX * aZoomLevel);
        wrappedNode.setLayoutY(positionY * aZoomLevel);
        wrappedNode.setScaleX(aZoomLevel);
        wrappedNode.setScaleY(aZoomLevel);

        owner.updateEdgeNodesFor(this, aZoomLevel);
    }
}
