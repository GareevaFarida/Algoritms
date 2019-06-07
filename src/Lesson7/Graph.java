package Lesson7;

public interface Graph<E> {
    void addVertex(Vertex<E> vertex);
    int getSize();
    int indexOf(Vertex<E> vertex);
    void display();
    void addEdge(Vertex<E> from, Vertex<E> to, float distance);
    float getTheShortestDistanceBetween(Vertex<E> from, Vertex<E> to);
}
