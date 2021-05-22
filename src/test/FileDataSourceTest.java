package test;

import decorators.DataSource;
import decorators.FileDataSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FileDataSourceTest {
    DataSource fileDataSource = new FileDataSource("out/test.txt");

    @Test
    @DisplayName("Source: Some text to testing.")
    public void writeTest(){
        try{
            fileDataSource.writeData("Some text to testing.");
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    @DisplayName("The output text should be the same")
    public void readTest(){
        System.out.println(fileDataSource.readData());
    }
}
