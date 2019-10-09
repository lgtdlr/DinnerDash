package Resources;


import Main.Handler;

import javax.sound.sampled.*;
import java.io.File;

public class MusicHandler {

    //Res.music
    private File audioFile;
    private AudioInputStream audioStream;
    private AudioFormat format;
    private DataLine.Info info;
    private Clip audioClip;



    //Inspired By ahmetcandiroglu' Music Handler

    private Handler handler;
    private Clip title;
    private long clipTime = 0;

    public MusicHandler(Handler handler){
        this.handler = handler;
        title = getClip(loadAudio("background"));
    }

    private AudioInputStream loadAudio(String url) {
        try {
            audioFile = new File("res/music/" + url + ".wav");
            audioStream = AudioSystem.getAudioInputStream(audioFile);
            format = audioStream.getFormat();
            info = new DataLine.Info(Clip.class, format);
            audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);

            return audioStream;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return null;
    }

    private Clip getClip(AudioInputStream stream) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(stream);
            return clip;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public void resumeBackground(){
        audioClip.setMicrosecondPosition(clipTime);
        audioClip.start();
    }

    public void pauseBackground(){
        clipTime = audioClip.getMicrosecondPosition();
        audioClip.stop();
    }

    public void restartBackground() {
        clipTime = 0;
        resumeBackground();
    }

    //Play special
    public void playMenu() {
    	audioClip.stop();
        title = getClip(loadAudio("background"));
        title.start();
    }
    
    public void playGame() {
    	audioClip.stop();
        Clip clip = getClip(loadAudio("game"));
        clip.start();
    }
    
    public void playLose() {
    	audioClip.stop();
        Clip clip = getClip(loadAudio("lose"));
        clip.start();
    }
    
    public void playWin() {
    	audioClip.stop();
        title = getClip(loadAudio("win"));
        title.start();
    }




}
