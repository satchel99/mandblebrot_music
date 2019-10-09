package music;
import stdlib.*;
import java.util.concurrent.*;
import java.util.concurrent.TimeUnit.*;
public class Bach {
    private Bar bars;
    public Bach(Bar bars) {
        this.bars = bars;
    }
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
    
    public static void play() {
        ArrayList<Note> notes = bars.getNotes();
        HashMap<Double, ArrayList<Note>> muted = new HashMap<Integer, ArrayList<Note>>();
        for(Note n : notes) {
            double startTime = n.getStartTime();
            if(muted.hasKey(startTime)) {
                muted.get(startTime).add(n);
            }
            else {
                ArrayList<Note> newNo
            }
        }
        int i = 0;
        while(i < notes) {
            
        }
    }
        
    public static void recur(double freq, int depth) {
        playChord(depth, freq, freq/2, freq*2);
        if(depth > 0) {
            recur(freq/2, depth-1);
            recur(freq*2, depth-1);
        } 
    }
    
}