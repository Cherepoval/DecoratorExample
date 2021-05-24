package test;

import decorators.DataSource;
import decorators.DataSourceDecorator;
import decorators.EncryptionDecorator;
import decorators.FileDataSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class EncryptionDecoratorTest {

    @Test
    @DisplayName("The source file was encrypted.")
    public void writeWithEncryption() {
        DataSourceDecorator encoder = new EncryptionDecorator(new FileDataSource("out/test.txt"));
        DataSource fileSource = new FileDataSource("out/test.txt");

        encoder.writeData("Some text to testing.");
        assert (fileSource.readData().equals("VHBuZiF1Znl1IXVwIXVmdHVqb2gv"));

    }

    @Test
    @DisplayName("The decrypted text is equals of the source.")

    public void readWithDecryption() {
        DataSourceDecorator encoder = new EncryptionDecorator(new FileDataSource("out/test.txt"));
        DataSource fileSource = new FileDataSource("out/test.txt");

        encoder.writeData("Some text to testing.");
        assert (encoder.readData().equals("Some text to testing."));

    }

}



