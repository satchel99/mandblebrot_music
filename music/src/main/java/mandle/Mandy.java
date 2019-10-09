package mandle;
import java.util.ArrayList;
import java.io.*;
public class Mandy {
    //,mandlebrot
    public static int mandlebrot(Complex c, int esc) {
        int i = 0;
        Complex r = new Complex(0, 0);
        while((i < esc) && (r.sumSquare() < 4.0)) {
            double x = r.diffSquare() + c.real(); 
            r.setImag(2*r.real()*r.imag() + c.imag());
            r.setReal(x);
            i++;
        }
        return i;
    }
    public static MSet iterate(double startR, double endR, double startI, double endI, int width, int height, int esc) {
        ArrayList<Double> set1 = linspace(startR, endR, width);
        ArrayList<Double> set2 = linspace(startI, endI, height);
        MSet set = new MSet(startR, endR, startI, endI, width, height, esc);
        for (double re : set1) {
            for (double im: set2) {
                Complex c = new Complex(re, im);
                int x = mandlebrot(c, esc);
                MPoint point = new MPoint(c, x);
                set.addPoint(point);
            }
        }
        return set;
    }
    public static ArrayList<Double> linspace(double start,double end,int num) {
        double d = Math.abs(end - start);
        double delim = d/num;
        ArrayList<Double> nums = new ArrayList<Double>();
        for(int i = 0; i < num; i++) {
            double nv = start + (delim*i);
            nums.add(nv);
        }
        return nums;
    };
    public static void loop() {
        ArrayList<Integer> vals = new ArrayList<Integer>();
        ArrayList<Double> set1 = linspace(-2, 1, 20);
        ArrayList<Double> set2 = linspace(-2, 1, 20);
        ArrayList<Double> set3 = linspace(-1, 1, 10);
        ArrayList<Double> set4 = linspace(-1, 1, 10);
        System.out.println(set1);
        for (double re : set2) {
            for (double im: set4) {
                System.out.println("-");
                System.out.println(re);
                System.out.println(im);
                Complex c = new Complex(re, im);
                System.out.println(c);
                int x = mandlebrot(c, 100);
                System.out.println(x);
                vals.add(x);
            }
        }
        System.out.println(vals);
    }
    public static void serialize(MSet set, String filename) {
        try
        {    
            FileOutputStream outPutFile = new FileOutputStream(filename); 
            ObjectOutputStream outputStream = new ObjectOutputStream(outPutFile); 
            outputStream.writeObject(set); 
            outputStream.close(); 
            outPutFile.close();     
        } 
          
        catch(IOException ex) 
        { 
            System.err.println(ex);
            System.out.println("an IO error occured"); 
        }
    }
    public static MSet deserialize(String filename) {
        MSet set = null;
        try
        {    
            FileInputStream inputFile = new FileInputStream(filename); 
            ObjectInputStream inputStream = new ObjectInputStream(inputFile); 
            try {
                set = (MSet)inputStream.readObject(); 
            }
            catch(ClassNotFoundException e) {
                System.err.println(e);
                System.out.println("MSet class not found");
            }
            inputStream.close(); 
            inputFile.close();     
        } 
          
        catch(IOException ex) 
        { 
            System.err.println(ex);
            System.out.println(filename + " not found/unreadable"); 
        }
        return set;
    }
    
    public static int scaleX(double x, double startX, double endX, int width) {
        double xRange = endX - startX;
        double scale = width/xRange;
        double newVal = x - startX;
        return (int)(newVal * scale);
    }
    
    public static int scaleY(double y, double startY, double endY, int height) {
        double yRange = endY - startY;
        double scale = height/yRange;
        double newVal = y - startY;
        return (int)(newVal * scale);
    }
    
    public static int[][] translatePixels(MSet set) {
        double endX = set.endX();
        double endY = set.endY();
        double startX = set.startX();
        double startY = set.startY();
        int width = set.width();
        int height = set.height();
        int [][] arr = new int[set.width()][set.height()];
        for(MPoint point : set.getPoints()) {
            Complex c = point.getComplex();
            int val = point.getIterations();
            double x = c.real();
            double y = c.imag();
            int xS = scaleX(x, startX, endX, width);
            int yS = scaleY(y, startY, endY, height);
            arr[xS][yS]= val;
        }
        return arr;
    }
    public static int linearInterpolate(int x1, int x2, double x3) {
        return (int)(x1 + x3 * (x2 - x1));
    }
    public static int[][] translatePixelsSmoothe(MSet set) {
        double endX = set.endX();
        double endY = set.endY();
        double startX = set.startX();
        double startY = set.startY();
        int width = set.width();
        int height = set.height();
        int [][] arr = new int[set.width()][set.height()];
        for(MPoint point : set.getPoints()) {
            Complex c = point.getComplex();
            int val = point.getIterations();
            double x = c.real();
            double y = c.imag();
            int xS = scaleX(x, startX, endX, width);
            int yS = scaleY(y, startY, endY, height);
            double valU = val * 1.0;
            if(val < set.getMaxIt()) {
                double log_zn = Math.log(x*x + y*y)/2;
                double nu = Math.log(log_zn / Math.log(2)) / Math.log(2);
                valU = (val + 1 - nu);
            }
            int color1 = (int)valU;
            int color2 = ((int)valU) + 1;
            double color3 = valU % 1;
            arr[xS][yS]= linearInterpolate(color1, color2, color3);
        }
        return arr;
    }
}