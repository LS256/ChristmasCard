package pl.codeforfun;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class ChrismatsCard {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new CardFrame();	
				frame.setVisible(true);
			}		
		});
	}
}
