package gui;

import java.awt.Color;

import javax.swing.JButton;

import parameters.GofParameters;

/**
 * 
 * @author yko
 *
 */
public class Cell extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4863257463242576990L;
	private boolean alive;
	private int liveNeigbourCounter;

	public Cell() {
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
		setBackground(getCellColor());
	}

	public Color getCellColor() {
		return isAlive() ? GofParameters.LIVE_CELL_COLOR
				: GofParameters.DEAD_CELL_COLOR;
	}

	public int getLiveNeigbourCounter() {
		return liveNeigbourCounter;
	}

	public void resetLiveNeigbourCounter() {
		liveNeigbourCounter = 0;
	}

	public void countLiveNeighbour() {
		liveNeigbourCounter++;
	}
}
