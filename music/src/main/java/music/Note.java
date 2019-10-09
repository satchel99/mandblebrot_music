package music;

public class Note implements Comparable{
    private double frequency;
    private double start;
    private double duration;
    public Note(double start, double frequency, double duration) {
        this.frequency = frequency;
        this.start = start;
        this.duration = duration;
    }
    public double getFrequency() {
        return this.frequency;
    }
    public double getDuration() {
        return this.duration;
    }
    public double getStart() {
        return this.start;
    }
    public void translate(double a, double b) {
       this.frequency = (this.frequency * a) + b;
    }
    public void translateStart(double a, double b) {
       this.start = (this.start * a) + b;
    }
    public int compareTo(Object o) {
        Note n = (Note)o;
        double s = n.getStart();
        if(start < s) {
            return -1;
        }
        else if(start > s) {
            return 1;
        }
        else {
            return 0;
        }
     }
}