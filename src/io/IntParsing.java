package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by nicholas on 4/15/16.
 */
public class IntParsing {

    public static void main(String[] args) throws IOException {

        try (BufferedReader inputFile = new BufferedReader(new FileReader("inputs/integers.txt"))) {

            String line;

            while ((line = inputFile.readLine()) != null) {

                try {

                    float myInt = Float.valueOf(line);
                    System.out.println("before value: " + myInt);
                    System.out.println("after value: " + (myInt + 10));

                } catch (NumberFormatException ne) {

                    System.out.println("oops can't convert to integer. value is: " + line);

                }

            }

        }

    }

}
