package mandle;
import java.io.*;
import java.io.Serializable;
public class MPoint implements Serializable{
    private Complex complex;
    private int iterations;
    public MPoint(Complex complex, int iterations) {
        this.complex = complex;
        this.iterations = iterations;
    }
    public Complex getComplex() {
        return this.complex;
    }
    public int getIterations() {
        return this.iterations;
    }
}