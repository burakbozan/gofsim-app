package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import parameters.GofParameters;
import rule.GameOfLifeRuleManager;

/**
 * 
 * @author yko
 *
 */
public class GofWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4308333756075893154L;
	private Board gofFrame;

	public GofWindow() {
		gofFrame = new Board();
		add(gofFrame, BorderLayout.CENTER);
		setVisible(true);
		setBounds(GofParameters.BOUNDS);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void start() {
		for (;;) {
			GameOfLifeRuleManager.run(gofFrame.getCellBoard());
			try {
				Thread.sleep(GofParameters.THREAD_SLEEP_MILLIS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
