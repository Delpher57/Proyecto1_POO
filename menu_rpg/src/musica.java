import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class musica {
	
	public void playSound() {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("recursos/ShorelineShop.wav"));
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        FloatControl gainControl = 
	        (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	        gainControl.setValue(-10.0f);
	        clip.start();
	        clip.loop(Clip.LOOP_CONTINUOUSLY);
	    } catch(Exception ex) {
	        System.out.println("error con la musica.");
	    }
	}
	
	
	
	public void cling() {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("recursos/clin.wav"));
	        Clip ing = AudioSystem.getClip();
	        ing.open(audioInputStream);
	        ing.start();
	    } catch(Exception ex) {
	        System.out.println("error con sonido cling.");
	    }
	}
	
	
	
	public void comprado() {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("recursos/compra.wav"));
	        Clip cmp = AudioSystem.getClip();
	        cmp.open(audioInputStream);
	        cmp.start();
	    } catch(Exception ex) {
	        System.out.println("error con sonido compra.");
	    }
	}
	
	
	
	public void error() {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("recursos/error.wav"));
	        Clip err = AudioSystem.getClip();
	        err.open(audioInputStream);
	        err.start();
	    } catch(Exception ex) {
	        System.out.println("error con la sonido error.");
	    }
	}

}
