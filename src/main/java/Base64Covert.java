import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public class Base64Covert {

    public static byte[] getData() throws IOException {
        String s = new String(Base64.getEncoder().encode(file2Byte()));
        System.out.println(s);
        return null;
    }


    public static byte[] file2Byte() throws IOException {
        byte[] buffer = null;
        File file = new File("C:\\Users\\admin\\Desktop\\2020客户端\\语音助手\\nls-sample-16k.wav");
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        }
        return buffer;
    }

    public static void main(String[] args) throws IOException {
        getData();
    }

}
