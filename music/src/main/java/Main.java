import java.util.*;
import mandle.*;
import music.*;
import graphics.*;
public class Main {
    static int SOME_VAL = 200;
    public static void main(String [] args) {
        /*
        int [][] img = new int[20][50];
        for(int i = 0; i < img.length; i++) {
            for(int j = 0; j < img[0].length; j++) {
                img[i][j] = SOME_VAL;
            }
        }
        ImageGenerator gen = new ImageGenerator(img, "img/test1.png");
        gen.make();*/
        MSet set = Mandy.iterate(0.355, 0.36, 0.335, 0.34, 1000, 1000, 10000);
        //MSet set = Mandy.deserialize("iterations/Iterations_1000_0.3to0.4");
        int [][] arr = Mandy.translatePixelsSmoothe(set);
        ImageGenerator gen = new ImageGenerator(arr, "img/mandy15.png");
        gen.make();
        //Mandy.serialize(set, "iterations/Iterations_1000_0.3to0.4");
    }
}