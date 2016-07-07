package dates;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by nicholas on 4/15/16.
 */
public class DatePractice {

    public static void main(String[] args) throws IOException {

        try (BufferedReader inputFile = new BufferedReader(new FileReader("inputs/dates.txt"))) {

            String line;

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy");

            int count = 1;
            while ((line = inputFile.readLine()) != null) {


                if (count == 4) {
                    LocalDate localDate = LocalDate.parse(line, dateTimeFormatter);
                    LocalDate localedate2 = localDate.minusDays(20);
                    System.out.println(localDate);
                    System.out.println(localedate2);

                }

                count++;
            }

        }

    }

}


