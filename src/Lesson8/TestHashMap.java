package Lesson8;

public class TestHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMapImpl<>(10);
        map.put("Абрикосы", 150);
        map.put("Абрикосы", 150);
        map.put("Абрикосы", 150);
        map.put("Клубника", 200);
        map.put("Яблоки", 100);
        map.put("Черешня", 350);
        map.put("Огурцы", 100);
        map.put("Помидоры", 80);
        map.display();
        System.out.println("Size = " + map.size());
        map.delete(new String("Помидоры"));
        map.display();
        System.out.println("Size = " + map.size());

        System.out.println("Price of Черешня = " + map.get("Черешня"));
        System.out.println("Price of Арбуз = " + map.get("Арбуз"));


    }
}
