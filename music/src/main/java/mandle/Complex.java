package mandle;

import java.io.Serializable;
public class Complex implements Serializable{
    private double real;
    private double imaginary;
    
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    
    public double sumSquare() {
        return this.real*this.real + this.imaginary*this.imaginary;
    }
    
    public double diffSquare() {
        return this.real*this.real - this.imaginary*this.imaginary;
    }
    
    public double imag() {
        return imaginary;
    }
    
    public double real() {
        return real;
    }
    
    public void setReal(double real) {
        this.real = real;
    }
    
    public void setImag(double imaginary) {
        this.imaginary = imaginary;
    }
    
    @Override
    public String toString() {
        return this.real + " + " + this.imaginary + "i";
    }
    
}