package Lesson7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node<E> {
    private final Vertex<E> vertex;
    private final int indexInMatrix;
    private ArrayList<Vertex<E>> visitedNeighbors;
    private Queue<Vertex<E>> path;

    Node(Vertex<E> vertex, int maxCountOfVertexes, int indexInMatrix) {
        this.vertex = vertex;
        this.indexInMatrix = indexInMatrix;
        this.visitedNeighbors = new ArrayList<>(maxCountOfVertexes);
        this.path = new LinkedList<>();
    }

    int getIndexInMatrix() {
        return indexInMatrix;
    }

    Vertex<E> getVertex() {
        return vertex;
    }

    Queue<Vertex<E>> getPath() {
        return path;
    }

    void setPathFromPrevious(Node<E> previousNode) {
        if (previousNode == null)
            return;
        while (!previousNode.path.isEmpty()) {
            path.add(previousNode.path.remove());
        }
        path.add(previousNode.vertex);
    }

    boolean isContainedInPath(Vertex<E> nextVertex) {
        return path.contains(nextVertex);
    }

    void markVisitedNeighbor(Vertex<E> nextVertex) {
        visitedNeighbors.add(nextVertex);
    }

    @Override
    public String toString() {
        return "Node{" +
                "vertex=" + vertex +
                '}';
    }
}
