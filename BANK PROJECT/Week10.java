import java.io.*;

public class Week10 {

public static void main(String[] args) {

    // Save data

    try {

        FileWriter writer =
                new FileWriter("bank.txt");

        writer.write("Heet,1001,5000");

        writer.close();

        System.out.println(
                "Data saved successfully."
        );

    } catch (Exception e) {

        System.out.println(
                "Error while saving."
        );
    }


    // Read data

    try {

        BufferedReader reader =
                new BufferedReader(
                        new FileReader("bank.txt")
                );

        String data = reader.readLine();

        reader.close();

        System.out.println(
                "Saved Data: " + data
        );

    } catch (Exception e) {

        System.out.println(
                "Error while reading."
        );
    }
}
}
