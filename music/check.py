import numpy as np
import matplotlib.pyplot as plt

#the essence of te mandlebrot set is how many steps (iterations) does it take to reach |Z| = 2, where Z is some complex number (remember the formula for absolute value of a complex number?)  

#takes a real number, an imaginary number, and the max number of iterations
def mandlebrot_set(re, im, esc):
    i = 0
    rR = 0
    rI = 0
    #while the complex numbers abs value is less than 2 in otherwords
    while( (i < esc) and ((rR*rR + rI*rI)  < 4.0)):
        x = rR*rR - rI*rI + re
        rI = 2*rR*rI + im
        rR = x
        i+=1
    return i

        
#remember we are plotting complex numbers
#so the x axis is the real number and the y axis is the complex number

def plot_mandlebrot(width, height):
    rows = width
    cols = height
    #creates a matrix of rows by cols every cell initialized to zero
    matrix = np.zeros([rows, cols])
    #real number axis loop (ri: row index, re: real number)(btw enumerate is like range but makes it easier to iterate over linepsaces since range has a min incrementer of
    for ri, re in enumerate(np.linspace(-2, 1, num=rows)):
        #this inner loop is for the imaginary axis (ci: column index, im: imaginary number)
        for ci, im in enumerate(np.linspace(-1, 1, num=cols)):
            x = mandlebrot_set(re, im, 100)
            #print(x)
            matrix[ri, ci] = x
    plt.figure(dpi=100)
    plt.imshow(matrix.T, cmap='hot', interpolation='bilinear', extent=[-2,-1, -1, 1])
    plt.xlabel('Real numbers')
    plt.ylabel('Imaginary numbers')
    plt.show()
    
def plot_julia(width, height):
    rows = width
    cols = height
    #creates a matrix of rows by cols every cell initialized to zero
    matrix = np.zeros([rows, cols])
    #real number axis loop (ri: row index, re: real number)(btw enumerate is like range but makes it easier to iterate over linepsaces since range has a min incrementer of
    for ri, re in enumerate(np.linspace(-2, 1, num=rows)):
        #this inner loop is for the imaginary axis (ci: column index, im: imaginary number)
        for ci, im in enumerate(np.linspace(-1, 1, num=cols)):
            x = julia_set(re, im, 300)
            matrix[ri, ci] = x
    plt.figure(dpi=100)
    plt.imshow(matrix.T, cmap='hot', interpolation='bilinear', extent=[-2,-1, -1, 1])
    plt.xlabel('Real numbers')
    plt.ylabel('Imaginary numbers')
    plt.show()
    

#the mandlebrot set is very similar and related to the julia_set however one key differnce, rather than the +c in the equation(where c is a complex number) being related to the point on the complex plane we are plotting, it is a constant and the type of julia plot changes based on the constant for c you would use
def julia_set(re, im, esc):
    i = 0
    rR = re
    rI = im
    #while the complex numbers abs value is less than 2 in otherwords
    while( (i < esc) and ((rR*rR + rI*rI)  < 4.0)):
        #so this would be represente as c = -0.7 - 0.3482i
        #compare this to the mandlebrot set at the top
        x = rR*rR - rI*rI - 0.7
        rI = 2*rR*rI - 0.3482
        rR = x
        i+=1
    return i

def mandlebrot_warmup():
    l = []
    for ri, re in enumerate(np.linspace(-2, 1, 20)):
        for ci, im in enumerate(np.linspace(-1, 1, 10)):
            x = mandlebrot_set(re, im, 100)
            l.append(x)
    return l
def main():
    #lets start with some practice iterations as requested in question 1
    print("100 iterations of mandlebrot...")
    #print(mandlebrot_warmup())
    #print(mandlebrot_set(0.5499999999999998,-0.3999999999999999, 100));
    
    #lets call the plot mandlebrot function
    #plot_mandlebrot(100,100)
    
    #lets call the julia set plot
    plot_julia(200,200)
    
main()