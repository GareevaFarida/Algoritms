package Lesson5;

public class Main5 {
    public static void main(String[] args) {
        Exponentiation ex = new Exponentiation();
        System.out.println("Число 2 в степени 10 = "+ex.raiseNumberToPower(2,10));
        System.out.println("Число 2 в степени 0 = "+ex.raiseNumberToPower(2,0));
        System.out.println("Число 0 в степени 5 = "+ex.raiseNumberToPower(0,5));
        System.out.println("Число 2 в степени -10 = "+ex.raiseNumberToPower(2,-10));
        System.out.println("Число 3 в степени -5 = "+ex.raiseNumberToPower(3,-5));
        System.out.println("Число 0 в степени -2 = "+ex.raiseNumberToPower(0,-2));

    }
}
