package fr.anthonyquere.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static void main(String[] args) {
        System.out.println("FizzBuzz!");
        System.out.println(startFizzBuzz(20));
    }

    public static List<String> startFizzBuzz(int count) {

        List<String> list = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            if (i % 15 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(Integer.toString(i));
            }
        }

        return list;
    }
}
