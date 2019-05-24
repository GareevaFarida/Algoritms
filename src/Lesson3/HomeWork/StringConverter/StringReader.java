package Lesson3.HomeWork.StringConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringReader {
    public String getString() {
        System.out.println("Введите строку:");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String str = "";

        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
