package fxGraph;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class FXGraphZoomHandler {

    private FXGraph graph;

    double currentZoomLevel;
    double targetZoomLevel;

    private Timeline zoomTimeLine;

    public FXGraphZoomHandler(FXGraph aGraph) {
        graph = aGraph;
        currentZoomLevel = 1;
        targetZoomLevel = 1;

        Duration theDuration = Duration.millis(1000 / 25);
        KeyFrame theOneFrame = new KeyFrame(theDuration, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                updateNodePositionsAndScale();
            }
        });

        zoomTimeLine = TimelineBuilder.create().cycleCount(Animation.INDEFINITE).keyFrames(theOneFrame).build();
        zoomTimeLine.play();

    }

    private void updateNodePositionsAndScale() {

        boolean evolvePosition = false;

        if (currentZoomLevel > targetZoomLevel) {
            currentZoomLevel -= (currentZoomLevel - targetZoomLevel) * 0.06;
            evolvePosition = true;
        }

        if (currentZoomLevel < targetZoomLevel) {
            currentZoomLevel += (targetZoomLevel - currentZoomLevel) * 0.06;
            evolvePosition = true;
        }

        if (evolvePosition) {

            for (FXNode theNode : graph.model.getNodes()) {
                theNode.setZoomLevel(currentZoomLevel);
            }

            graph.updateSelectionInScene();
        }

        if (Math.abs(currentZoomLevel - targetZoomLevel) < 0.01) {
            currentZoomLevel = targetZoomLevel;
        }
    }

    public void zoomOneStepIn() {
        targetZoomLevel -= 0.1;
        if (targetZoomLevel < 0.1) {
            targetZoomLevel = 0.1;
        }
        updateNodePositionsAndScale();
    }

    public void zoomOneStepOut() {
        targetZoomLevel += 0.1;

        updateNodePositionsAndScale();

    }
}