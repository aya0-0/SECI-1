import java.io.*;

public class FileReader {
    public String readFile(String filePath) throws IOException {
        InputStream in = new FileInputStream(filePath);
        int n = in.read();
        StringBuffer sb = new StringBuffer();
        while (n!=-1){
            sb.append((char)n);
            n = in.read();
        }
        return sb.toString();
    }
}
