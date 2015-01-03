package fxGraph;

import java.util.ArrayList;
import java.util.List;

public class FXEdgeBuilder {

    private FXGraph graph;
    private FXNode source;
    private FXNode destination;
    private List<FXEdgeWayPoint> wayPoints = new ArrayList<FXEdgeWayPoint>();

    public FXEdgeBuilder(FXGraph aGraph) {
        graph = aGraph;
    }

    public FXEdgeBuilder source(FXNode aSource) {
        source = aSource;
        return this;
    }

    public FXEdgeBuilder destination(FXNode aDestination) {
        destination = aDestination;
        return this;
    }

    public FXEdgeBuilder wayPoint(FXEdgeWayPoint aWayPoint) {
        wayPoints.add(aWayPoint);
        return this;
    }

    public FXEdge build() {
        FXEdge theEdge = new FXEdge(graph, source, destination);
        theEdge.wayPoints.addAll(wayPoints);

        graph.addEdge(theEdge);
        return theEdge;
    }
}
