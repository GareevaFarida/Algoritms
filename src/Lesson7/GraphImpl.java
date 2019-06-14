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
        createNewNode(from, queue, 0f);
        while (!queue.isEmpty()) {
            Node<E> currentNode = queue.peek();
            if (currentNode.getVertex().equals(to)) {
                resultsArray.add(queue.remove());
                continue;
            }
            findNearestNotVisitedVertexesAndPutItInQueue(currentNode, queue);
            queue.remove();
        }

        //displayVarietyOfPath(resultsArray, to);
        return selectTheShortestPath(resultsArray, to);
    }

    private float selectTheShortestPath(ArrayList<Node<E>> resultArray, Vertex<E> finish) {
        if (resultArray.isEmpty())
            return 0f;
        float minDistance = resultArray.get(0).getDistance();
        Node<E> shortestNode = resultArray.get(0);
        for (int i = 1; i < resultArray.size(); i++) {
            float currentDistance = resultArray.get(i).getDistance();
            if (currentDistance < minDistance) {
                minDistance = currentDistance;
                shortestNode = resultArray.get(i);
            }
        }
        displayPath(shortestNode.getPath(), finish, minDistance);

        return minDistance;
    }

    private void displayVarietyOfPath(ArrayList<Node<E>> resultsArray, Vertex<E> finish) {
        for (Node<E> node : resultsArray) {
            System.out.println("-------------------------------");
            ArrayList<Vertex<E>> path = node.getPath();
            displayPath(path, finish, node.getDistance());
        }
    }

    private void displayPath(ArrayList<Vertex<E>> path, Vertex<E> finish, float distance) {
        System.out.println("The shortest distance between " + path.get(0) + " and " + finish + " = " + distance + ": ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "-->");
        }
        System.out.println(finish);
    }

    private void findNearestNotVisitedVertexesAndPutItInQueue(Node<E> node, Queue<Node<E>> queue) {
        int index = node.getIndexInMatrix();
        for (int i = 0; i < MAX_VERTEX_COUNT; i++) {
            Float distance = adjMat[index][i];
            if (distance == null)
                continue;
            Vertex<E> nextVertex = vertexList.get(i);
            if (!node.isContainedInPath(nextVertex)
                    && !node.wasNeighborVisited(nextVertex)) {
                node.markVisitedNeighbor(nextVertex);
                createNewNode(nextVertex, queue, distance);
            }
        }
    }

    private void createNewNode(Vertex<E> vertex, Queue<Node<E>> queue, Float distance) {
        Node<E> node = new Node<>(vertex, MAX_VERTEX_COUNT, vertexList.indexOf(vertex));
        Node<E> previousNode = queue.peek();
        queue.add(node);
        if (previousNode != null) {
            //copy path of previous to new node
            node.setPathFromPrevious(previousNode, distance);
        }
    }

}
