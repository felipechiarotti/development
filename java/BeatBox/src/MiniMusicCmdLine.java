import javax.sound.midi.*;

public class MiniMusicCmdLine {
	public static void main(String[] args){
		MiniMusicCmdLine mini = new MiniMusicCmdLine();
		if(args.length < 2){
			System.out.println("Não se esqueça dos argumentos (Instrumento, nota).");
		}else{
			int instrument = Integer.parseInt(args[0]);
			int note = Integer.parseInt(args[1]);
			mini.play(instrument, note);
		}
	}
	
	public void play(int i, int n){
		try{
			Sequencer player = MidiSystem.getSequencer();
			player.open();
			Sequence seq = new Sequence(Sequence.PPQ,4);
			Track track = seq.createTrack();
			
			MidiEvent event = null;
			
			ShortMessage first = new ShortMessage();
			first.setMessage(192,1,i,0);
			MidiEvent changeInstrument = new MidiEvent(first,1);
			track.add(changeInstrument);
			
			for(int z = 0; z<30; z++){
				

			ShortMessage a = new ShortMessage();
			a.setMessage(144,1,n+z,100);
			MidiEvent noteOn = new MidiEvent(a,1);
			track.add(noteOn);
			
			ShortMessage b = new ShortMessage();
			b.setMessage(128,1,n+z,100);
			MidiEvent noteOff = new MidiEvent(b,16);
			track.add(noteOff);
			}
			player.setSequence(seq);
			player.start();
			
			Thread.sleep(1000*3);
			System.exit(0);
		}catch(Exception ex){ex.printStackTrace();}
	}
}
