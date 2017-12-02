package pl.codeforfun;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * @author LS256
 *	Class responsible for playing music in background
 */
public class BackgroundMusic implements Runnable {
	
	private String soundFileName = "song1.mp3";
	private Player player;
	
	/*
	 * Method which stops playing music
	 */
	public void stops(){
		player.close();
	}
	
	/*
	 * Method which starts playing music
	 */
	public void play(){
		try {
			FileInputStream fileInputStream = new FileInputStream(soundFileName);
			BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);			
			player = new Player(bufferedInputStream);
			player.play();		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(JavaLayerException e){
			e.printStackTrace();
		} finally {
			if(player != null) {
				player.close();
			}
		}
	}
	
	/*
	 * Starts playing music in thread
	 */
	@Override
	public void run() {
		try {
			play();
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
		
		
		
		

}
