package mandle;
import java.util.ArrayList;
import java.io.Serializable;
public class MSet implements Serializable{
    private ArrayList<MPoint> points;
    private int width;
    private int height;
    private double startX;
    private double startY;
    private double endX;
    private double endY;
    private int maxIterations;
    public MSet(double startX, double endX, double startY, double endY, int width, int height, int maxIterations) {
        this.width = width;
        this.height = height;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.maxIterations = maxIterations;
        this.points = new ArrayList<MPoint>(width*height);
    }
    public void addPoint(MPoint point) {
        this.points.add(point);
    }
    public ArrayList<MPoint> getPoints() {
        return this.points;
    }
    public int width() {
        return this.width;
    }
    public int height() {
        return this.height;
    }
    public double startX() {
        return this.startX;
    }
    public double startY() {
        return this.startY;
    }
    public double endX() {
        return this.endX;
    }
    public double endY() {
        return this.endY;
    }
    public int getMaxIt() {
        return this.maxIterations;
    }
}