package Lesson7;

public class TestGraph {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Graph<String> graph = new GraphImpl<>(20);
        Vertex<String> Circle_Taganskaya = new Vertex<String>("Таганская кольцевая");
        Vertex<String> Circle_Pavel = new Vertex<String>("Павелецкая кольцевая");
        Vertex<String> Circle_Dobrynja = new Vertex<String>("Добрынинская кольцевая");
        Vertex<String> Circle_October = new Vertex<String>("Октябрьская кольцевая");

        Vertex<String> RedPres_Taganskaya = new Vertex<String>("Таганская краснопресненская");
        Vertex<String> RedPres_Kitay = new Vertex<String>("Китай-город краснопресненская");

        Vertex<String> Yellow_Mark = new Vertex<String>("Марксистская");
        Vertex<String> Yellow_Tretjak = new Vertex<String>("Третьякоская желтая");

        Vertex<String> Orange_Kitay = new Vertex<String>("Китай-город оранжевая");
        Vertex<String> Orange_Tretjak = new Vertex<String>("Третьяковская оранжевая");
        Vertex<String> Orange_October = new Vertex<String>("Октябрьская оранжевая");

        Vertex<String> Green_Novokuz = new Vertex<String>("Новокузнецкая");
        Vertex<String> Green_Pavel = new Vertex<String>("Павелецкая зеленая");

        graph.addVertex(Circle_Taganskaya);
        graph.addVertex(Circle_Pavel);
        graph.addVertex(Circle_Dobrynja);
        graph.addVertex(Circle_October);
        graph.addVertex(RedPres_Taganskaya);
        graph.addVertex(RedPres_Kitay);
        graph.addVertex(Yellow_Mark);
        graph.addVertex(Yellow_Tretjak);
        graph.addVertex(Orange_Kitay);
        graph.addVertex(Orange_Tretjak);
        graph.addVertex(Orange_October);
        graph.addVertex(Green_Novokuz);
        graph.addVertex(Green_Pavel);

        graph.addEdge(Circle_Taganskaya, Circle_Pavel, 3f);
        graph.addEdge(Circle_Taganskaya, Yellow_Mark, 3f);
        graph.addEdge(Circle_Taganskaya, RedPres_Taganskaya, 3f);
        graph.addEdge(Circle_Pavel, Circle_Dobrynja, 2f);
        graph.addEdge(Circle_Pavel, Green_Pavel, 2f);
        graph.addEdge(Circle_Dobrynja, Circle_October, 2f);
        graph.addEdge(Circle_October, Orange_October, 2f);

        graph.addEdge(Yellow_Mark, Yellow_Tretjak, 3f);
        graph.addEdge(Yellow_Mark, RedPres_Taganskaya, 3f);

        graph.addEdge(RedPres_Taganskaya, RedPres_Kitay, 2f);

        graph.addEdge(Green_Novokuz, Green_Pavel, 3f);

        graph.addEdge(Orange_Kitay, Orange_Tretjak, 2f);
        graph.addEdge(Orange_Kitay, RedPres_Kitay, 0.5f);
        graph.addEdge(Orange_Tretjak, Orange_October, 2f);
        graph.addEdge(Orange_Tretjak, Green_Novokuz, 2f);
        graph.addEdge(Orange_Tretjak, Yellow_Tretjak, 0.5f);
        graph.addEdge(Green_Novokuz, Yellow_Tretjak, 2f);

//        graph.addEdge(Circle_Taganskaya,Circle_Pavel,1f);
//        graph.addEdge(Circle_Taganskaya,Yellow_Mark,1f);
//        graph.addEdge(Circle_Taganskaya,RedPres_Taganskaya,1f);
//        graph.addEdge(Circle_Pavel,Circle_Dobrynja,1f);
//        graph.addEdge(Circle_Pavel,Green_Pavel,1f);
//        graph.addEdge(Circle_Dobrynja,Circle_October,1f);
//        graph.addEdge(Circle_October,Orange_October,1f);
//
//        graph.addEdge(Yellow_Mark,Yellow_Tretjak,1f);
//        graph.addEdge(Yellow_Mark,RedPres_Taganskaya,1f);
//
//        graph.addEdge(RedPres_Taganskaya,RedPres_Kitay,1f);
//
//        graph.addEdge(Green_Novokuz,Green_Pavel,1f);
//
//        graph.addEdge(Orange_Kitay,Orange_Tretjak,1f);
//        graph.addEdge(Orange_Kitay,RedPres_Kitay,1f);
//        graph.addEdge(Orange_Tretjak,Orange_October,1f);
//        graph.addEdge(Orange_Tretjak,Green_Novokuz,1f);
//        graph.addEdge(Orange_Tretjak,Yellow_Tretjak,1f);
//        graph.addEdge(Green_Novokuz,Yellow_Tretjak,1f);

  //      graph.display();

        graph.getTheShortestDistanceBetween(RedPres_Taganskaya, Circle_October);
        graph.getTheShortestDistanceBetween(Circle_Pavel, new Vertex<String>("Новокузнецкая"));
        graph.getTheShortestDistanceBetween(Circle_Pavel, Orange_Tretjak);


    }


}
