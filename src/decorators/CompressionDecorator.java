package decorators;

import java.io.*;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class CompressionDecorator extends DataSourceDecorator{
    private int compressionLevel = 6;

    public CompressionDecorator(DataSource source) {
        super(source);
    }

    public int getCompressionLevel() {
        return compressionLevel;
    }

    public void setCompressionLevel(int value) {
        this.compressionLevel = value;
    }

    @Override
    public void writeData(String data) {
        super.writeData(compress(data));
    }

    private String compress(String data) {
        byte[] buffer = data.getBytes();
        try{
            ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
            DeflaterOutputStream dos = new DeflaterOutputStream(bout, new  Deflater(compressionLevel));
            dos.write(buffer);
            dos.close();
            bout.close();

            return Base64.getEncoder().encodeToString(bout.toByteArray());

        } catch (IOException ex){
            return null;
        }
    }

    @Override
    public String readData() {
        return decompress(super.readData());
    }

    private String decompress(String data) {
        byte[] buffer = Base64.getDecoder().decode(data);
        try {
            InputStream input = new ByteArrayInputStream(buffer);
            InflaterInputStream iin = new InflaterInputStream(input);
            ByteArrayOutputStream bout = new ByteArrayOutputStream(512);

            int b;
            while (( b = iin.read()) != -1){
                bout.write(b);
            }
            input.close();
            iin.close();
            bout.close();

            return bout.toString();

        } catch (IOException ex){
            return null;
        }
    }
}
