package music;

import java.util.ArrayList;

public class Bar {
    private ArrayList<Note> notes;
    public Bar() {
        this.notes = new ArrayList<Note>();
    }
    public Bar(ArrayList<Note> notes) {
        this.notes = notes;
    }
    public ArrayList<Note> getNotes() {
        return this.notes;
    }
    public void addNote(Note n) {
        this.notes.add(n);
    }
    public void orient() {
        if(notes.size() > 0)  {
            double minStart = notes.get(0).getStart();
            for(Note n : notes) {
                if(n.getStart() < minStart) {
                    minStart = n.getStart();
                }
            }
            minStart*=-1;
            for(Note n : notes) {
                n.translateStart(1, minStart);
            }
        }
    }
}