package Lesson7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphImpl<E> implements Graph<E> {
    private ArrayList<Vertex<E>> vertexList;
    private Float[][] adjMat;
    private int size;
    private final int MAX_VERTEX_COUNT;

    public GraphImpl(int maxVertexCount) {
        this.MAX_VERTEX_COUNT = maxVertexCount;
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMat = new Float[maxVertexCount][maxVertexCount];
    }

    @Override
    public void addVertex(Vertex<E> vertex) {
        if (vertexList.contains(vertex)) {
            return;
        }
        vertexList.add(vertex);
        size++;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int indexOf(Vertex<E> vertex) {
        return vertexList.indexOf(vertex);
    }

    @Override
    public void display() {
        for (int i = 0; i < size; i++) {
            Vertex<E> currentVertex = vertexList.get(i);
            System.out.print(currentVertex + " --> ");
            for (int j = 0; j < size; j++) {
                if (adjMat[i][j] != null) {
                    System.out.print(vertexList.get(j) + "(" + adjMat[i][j] + ")  ");
                }
            }
            System.out.println("");
        }
    }

    public void addEdge(Vertex<E> vertexFrom, Vertex<E> vertexTo, float distance) {
        if (distance < 0)
            throw new IllegalArgumentException("Negative distance: " + distance);

        int indexFrom = vertexList.indexOf(vertexFrom);
        int indexTo = vertexList.indexOf(vertexTo);
        if (indexFrom < 0 || indexTo < 0)
            throw new IllegalArgumentException("Invalid name of vertex: " + vertexFrom.toString() + ", " + vertexTo.toString());

        adjMat[indexFrom][indexTo] = distance;
        adjMat[indexTo][indexFrom] = distance;
    }

    @Override
    public float getTheShortestDistanceBetween(Vertex<E> from, Vertex<E> to) {
        int indexFrom = vertexList.indexOf(from);
        int indexTo = vertexList.indexOf(to);
        if (indexFrom == -1 || indexTo == -1)
            throw new IllegalArgumentException("Invalid vertex: " + from + " and/or " + to);

        ArrayList<Node<E>> resultsArray = new ArrayList<>();

        Queue<Node<E>> queue = new LinkedList<>();
        createNewNode(from, queue);
        while (!queue.isEmpty()) {
            Node<E> currentNode = queue.peek();
            if (currentNode.getVertex().equals(to)) {
                resultsArray.add(queue.remove());
                continue;
            }
            Node<E> nextNode = getNearestNotVisitedVertex(currentNode, queue);
            if (nextNode == null) {
                queue.remove();
                System.out.println(queue.size());
            } else {
                queue.add(nextNode);
                System.out.println(queue.size());
            }
        }

        displayVarietyOfPath(from,to,resultsArray);
        return 0;
    }

    private void displayVarietyOfPath(Vertex<E> from, Vertex<E> to,ArrayList<Node<E>> resultsArray) {
        for (Node<E> node : resultsArray) {
            System.out.println("-------------------------------");
            System.out.print(from+"-->");
            Queue<Vertex<E>> path = node.getPath();
            while (!path.isEmpty()) {
                System.out.print(path.remove()+"-->");
            }
            System.out.println(to);
        }
    }

    private Node<E> getNearestNotVisitedVertex(Node<E> node, Queue<Node<E>> queue) {
        int index = node.getIndexInMatrix();
        for (int i = 0; i < MAX_VERTEX_COUNT; i++) {
            if (adjMat[index][i] != null) {
                Vertex<E> nextVertex = vertexList.get(i);
                if (!node.isContainedInPath(nextVertex)) {
                    node.markVisitedNeighbor(nextVertex);
                    createNewNode(nextVertex, queue);
                }
            }
        }
        return null;
    }

    private void createNewNode(Vertex<E> vertex, Queue<Node<E>> queue) {
        Node<E> node = new Node<>(vertex, MAX_VERTEX_COUNT, vertexList.indexOf(vertex));
        Node<E> previousNode = queue.peek();
        queue.add(node);
        if (previousNode != null) {
            //copy path of previous to new node
            node.setPathFromPrevious(previousNode);
        }
        //vertex.setVisited(true);
    }

}
