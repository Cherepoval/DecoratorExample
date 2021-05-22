package app;

import decorators.*;

public class Application {
    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,5000\nSteven Braun,4000";

        DataSourceDecorator encoder = new CompressionDecorator(
                new EncryptionDecorator(new FileDataSource("out/example.txt")));

        encoder.writeData(salaryRecords);
        DataSource plaintext = new FileDataSource("out/example.txt");

        System.out.println("----------Input----------");
        System.out.println(salaryRecords);
        System.out.println("----------Encoded--------");
        System.out.println(plaintext.readData());
        System.out.println("----------Decoded--------");
        System.out.println(encoder.readData());
    }
}
