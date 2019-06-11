package Lesson8;

public class TestHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMapImpl<>(10);
        map.put("Абрикосы", 150);
        map.put("Абрикосы", 160);
        map.put("Абрикосы", 170);
        map.put("Клубника", 200);
        map.put("Яблоки", 100);
        map.put("Черешня", 350);
        map.put("Огурцы", 100);
        map.put("Помидоры", 80);
        map.put("Сливы", 200);
        map.put("Ананасы", 180);
        map.put("Мандарины", 170);
        map.put("Манго", 300);
        map.put("Виноград", 350);
        map.put("Кабачки", 50);
        map.put("Тыква", 80);
        map.put("Перец", 200);
        map.display();
        System.out.println("Size = " + map.size());
        map.delete(new String("Помидоры"));
        map.delete("Яблоки");
        map.display();
        System.out.println("Size = " + map.size());

        System.out.println("Price of Черешня = " + map.get("Черешня"));
        System.out.println("Price of Арбуз = " + map.get("Арбуз"));
        System.out.println("Price of Абрикосы = " + map.get("Абрикосы"));


    }
}
