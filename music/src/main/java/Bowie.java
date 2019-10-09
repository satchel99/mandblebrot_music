import stdlib.*;
import mandle.*;
import java.util.concurrent.*;
import java.util.concurrent.TimeUnit.*;
public class Bowie {
    
    private static void playChord(double duration, double... frequencies) {
		final int sliceCount = (int) (StdAudio.SAMPLE_RATE * duration);
		final double[] slices = new double[sliceCount+1];
		for (int i = 0; i <= sliceCount; i++) {
			for (double frequency: frequencies) {
				slices[i] += Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
			}
			slices[i] /= frequencies.length;
		}
		StdAudio.play(slices);
	}
    
    /*
    SCHEMA:
    
    
    */
    
    public static void playArr(int [][] arr) {
        
    }
    public static boolean playse() {
        playChord(2, 627.27, 497.87, 418.65, 313.64);
        return true;
    }
    
    public static void recur(double freq, int depth) {
        playChord(depth, freq, freq/2, freq*2);
        if(depth > 0) {
            recur(freq/2, depth-1);
            recur(freq*2, depth-1);
        } 
    }

	public static void main(String[] args) {
        System.out.println("here");
        int baseFreq = 3;
        //recur(527.47, 4);
        playChord(2, 527.47, 418.65, 352.04, 263.74);
        long delay = 2000;
        final Runnable beeper = new Runnable() {
            public void run() { 
                System.out.println("beep"); 
                playChord(2, 627.27, 497.87, 418.65, 313.64);
            }
        };
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.schedule(beeper, delay, TimeUnit.MILLISECONDS);
	}

}
