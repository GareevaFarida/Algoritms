package Lesson7;

import java.util.ArrayList;

class Node<E> {
    private final Vertex<E> vertex;
    private final int indexInMatrix;
    private ArrayList<Vertex<E>> listOfVisitedNeighbors;
    private ArrayList<Vertex<E>> path;
    private float distance;

    Node(Vertex<E> vertex, int maxCountOfVertexes, int indexInMatrix) {
        this.vertex = vertex;
        this.indexInMatrix = indexInMatrix;
        this.listOfVisitedNeighbors = new ArrayList<>(maxCountOfVertexes);
        this.path = new ArrayList<>(maxCountOfVertexes);
    }

    int getIndexInMatrix() {
        return indexInMatrix;
    }

    Vertex<E> getVertex() {
        return vertex;
    }

    ArrayList<Vertex<E>> getPath() {
        return path;
    }

    void setPathFromPrevious(Node<E> previousNode, Float distancePrevious) {
        if (previousNode == null)
            return;
        path = new ArrayList<>(previousNode.path);
        path.add(previousNode.vertex);
        distance = previousNode.distance + distancePrevious;
    }

    boolean isContainedInPath(Vertex<E> findVertex) {
        for (Vertex<E> vertex : path) {
            if (vertex == null)
                return false;
            if (vertex.equals(findVertex))
                return true;
        }
        return false;
    }

    void markVisitedNeighbor(Vertex<E> nextVertex) {
        listOfVisitedNeighbors.add(nextVertex);
    }

    @Override
    public String toString() {
        return "Node{" +
                "vertex=" + vertex +
                '}';
    }

    public boolean wasNeighborVisited(Vertex<E> nextVertex) {
        return listOfVisitedNeighbors.contains(nextVertex);
    }

    public Float getDistance() {
        return distance;
    }
}
