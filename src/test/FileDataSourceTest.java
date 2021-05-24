package test;

import decorators.DataSource;
import decorators.FileDataSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FileDataSourceTest {


    @Test
    @DisplayName("The source text was wrote to the file without changing.")
    public void writeAndReadTest() {
        DataSource fileDataSource = new FileDataSource("out/test.txt");

        fileDataSource.writeData("Some text to testing.");
        assert (fileDataSource.readData().equals("Some text to testing."));
    }
}
