package test;

import decorators.DataSource;
import decorators.DataSourceDecorator;
import decorators.EncryptionDecorator;
import decorators.FileDataSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class EncryptionDecoratorTest {

    DataSourceDecorator encoder = new EncryptionDecorator(new FileDataSource("out/test.txt"));
    DataSource fileSource = new FileDataSource("out/test.txt");

    @Test
    @DisplayName("Output: The text should be encrypted.")

    public void writeWithEncryption(){
        try {
            encoder.writeData("Some text to testing.");
            System.out.println(fileSource.readData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Output: The text should be decrypted.")

    public void readWithDecryption(){
        try {
           System.out.println(encoder.readData());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}



