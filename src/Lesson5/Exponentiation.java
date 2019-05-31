package Lesson5;

public class Exponentiation {
    private int number;
    private int degree;

    private double calc(int deg, double rez) {
        if (deg == degree)
            return rez;
        else {
            if (degree >= 0) {
                rez = rez * number;
                deg++;
            } else {
                rez = rez / number;
                deg--;
            }
            rez = calc(deg, rez);
        }
        return rez;
    }

    public double raiseNumberToPower(int number, int power) {
        if (number == 0 & power < 0) {
            throw new IllegalArgumentException("Incorrect data for exponentiation: 0 is impossible to rains to a negative power.");
        }
        this.number = number;
        this.degree = power;
        return calc(0, 1d);
    }
}
