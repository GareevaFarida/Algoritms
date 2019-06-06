package Lesson6;

public class Main6 {
    public static void main(String[] args) {
        Tree<Integer> tree = new TreeImpl<>();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(7);
        tree.add(3);
        tree.add(11);
        tree.add(25);
        tree.add(10);
        tree.add(9);
        tree.add(20);
        tree.add(29);
        tree.add(17);
        tree.add(13);
        System.out.println("Contains value = 5: "+tree.contains(5));
        System.out.println("Contains value = 35: "+tree.contains(35));
        System.out.println("Size of tree: " + tree.getSize());
        tree.display();
        tree.remove(15);
        System.out.println("Size of tree after removing value = 9: " + tree.getSize());
        tree.display();
    }
}
