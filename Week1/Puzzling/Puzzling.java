package Bootcamp.Java.Fundamentals.Puzzling;
import java.util.ArrayList;
import java.util.Arrays;

public class Puzzling {
    public static void main(String[] args) {
        PuzzleJava generator = new PuzzleJava();
        ArrayList<Integer> randomRolls = generator.getTenRolls();
        System.out.println(randomRolls);
        
        generator.getTenRolls();
        String x = generator.getRandomLetter();
        System.out.println(x);

        String y = generator.generatePassword();
        System.out.println(y);

        ArrayList<String> z = new ArrayList<String>();

        z = generator.getNewPasswordSet(9);

        System.out.println(z);


        ArrayList<Integer> p = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));


        ArrayList<Integer> array = generator.shuffleArray(p);
        System.out.println(array);


    }
}

