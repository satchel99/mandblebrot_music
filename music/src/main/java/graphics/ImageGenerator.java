import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
public class ImageGenerator {
    private int [][] arr;
    private String filename;
    public ImageGenerator(int [][] arr, String filename) {
        this.arr = arr;
        this.filename = filename;
    }
    public BufferedImage create() {
        int length = arr.length;
        int width = arr[0].length;
        BufferedImage br = new BufferedImage(length, width, BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                int pixel = arr[i][j];
                br.setRGB(i, j, pixel);
            }
        }
        return br;
    }
    public boolean write(BufferedImage br) {
        try {
            ImageIO.write(br, "png", new File(this.filename));
            return true;
        } 
        catch (IOException e) {
            System.out.println("Some IO Error");
            return false;
        }
    }
    
    public void make() {
        write(create());
    }
    
}