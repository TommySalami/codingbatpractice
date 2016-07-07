package tommy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by nicholas on 6/18/16.
 */


public class InsurancePrac {
    public static void main(String[] args) {

        // Connection connection = new Conne

        try (BufferedReader br = new BufferedReader(new FileReader("/home/nicholas/insurance-linux.csv"))) {
            br.readLine();

            for (int i = 0;i<100;i++) {
                String poop = br.readLine();
                String[] poopy = poop.split(",", 4);
                System.out.println(poopy[0]);
            }


        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("some other bullshit");
        }
    }
}
