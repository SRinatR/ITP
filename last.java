import java.io.*;
import java.net.*;

public class ImageDownloader {
    
    public static void saveImage(String imageUrl) {
        InputStream is = null;
        OutputStream os = null;
        
        try {
            URL url = new URL(imageUrl);
            String fileName = url.getFile();
            String destName = "./figures" + fileName.substring(fileName.lastIndexOf("/"));
            System.out.println(destName);
            
            new File("./figures").mkdirs();
            
            is = url.openStream();
            os = new FileOutputStream(destName);
            
            byte[] b = new byte[2048];
            int length;
            
            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }
            
        } catch (MalformedURLException e) {
            System.err.println("Invalid URL: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        } finally {
            try {
                if (is != null) is.close();
                if (os != null) os.close();
            } catch (IOException e) {
                System.err.println("Error closing streams: " + e.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
        saveImage("https://example.com/image.jpg");
    }
}
