package pl.codeforfun;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * Class where all components of Christmas card are added
 */
public class CardFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;

	private CardPanel cardPanel = new CardPanel();
	private JPanel buttonsPanel = new JPanel();
	private TimeMaker timeMaker = new TimeMaker();
	private BackgroundMusic backgroundMusic = new BackgroundMusic();
	
	private final int frameWidth = 610;
	private final int frameHeight = 500;
	private final int xFrameCoordinate = 100;
	private final int yFrameCoordinate = 100;	
	Runnable executeRunnable;
	Thread executeThread;
	
	Runnable musicRunnable;
	Thread musicThread;
	
	JButton stopButton;
	JSlider snowingSpeed;
	
	/*
	 * Constructor for creating main window of Christmas Card
	 */
	CardFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(frameWidth, frameHeight);
		this.setLocation(xFrameCoordinate, yFrameCoordinate);
		this.setResizable(false);
		this.setTitle("Merry Christmas");
		this.add(cardPanel, BorderLayout.CENTER);		
		
		/*
		 * Button for snowing activation
		 */
		JButton startSnowingButton = new JButton("Start Snowing");
		startSnowingButton.addActionListener(action-> {
				timeMaker.setShouldSnowing(true);
				executeRunnable = new ExecuteRunnable(cardPanel, timeMaker);
				executeThread = new Thread(executeRunnable);
				executeThread.start();
				
				Thread musicThread = new Thread(backgroundMusic);
				musicThread.start();
				
				startSnowingButton.setEnabled(false);;
				stopButton.setEnabled(true);
		});
	
		buttonsPanel.add(startSnowingButton);
		
		
		/*
		 * Slider for changing amount of generated snow flakes
		 */
		snowingSpeed = new JSlider(JSlider.HORIZONTAL, 10, 100, 55);
		snowingSpeed.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
				timeMaker.setBetweenSnowingTime(snowingSpeed.getValue());
			}
		});
		buttonsPanel.add(snowingSpeed);
		
		/*
		 * Create button which will interrupt generation of new snow flakes and also stop playing music
		 */
		stopButton = new JButton("STOP Snowing");
		stopButton.addActionListener(action -> {
			timeMaker.setShouldSnowing(false);
			startSnowingButton.setEnabled(true);
			stopButton.setEnabled(false);
			backgroundMusic.stops();
		});
		buttonsPanel.add(stopButton);
		this.add(buttonsPanel, BorderLayout.SOUTH);
	
		this.setVisible(true);	
	}
}
