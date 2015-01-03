package fxGraph;

public class FXGraphBuilder {

    public static FXGraphBuilder create() {
        return new FXGraphBuilder();
    }

    private FXGraphBuilder() {
    }

    public FXGraph build() {
        return new FXGraph();
    }
}
