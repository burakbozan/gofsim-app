package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

import parameters.GofParameters;

/**
 * 
 * @author yko
 *
 */
public class Board extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5205371880273948744L;
	private Cell[][] cellBoard;

	public Board() {
		cellBoard = new Cell[GofParameters.CELL_MATRIX_SIZE][GofParameters.CELL_MATRIX_SIZE];

		for (int i = 0; i < GofParameters.CELL_MATRIX_SIZE; i++) {
			for (int j = 0; j < GofParameters.CELL_MATRIX_SIZE; j++) {
				double randomNumber = Math.random();

				cellBoard[i][j] = new Cell();
				cellBoard[i][j].setAlive(randomNumber > 0.6);
				add(getCellBoard()[i][j]);
			}
		}

		setLayout(new GridLayout(GofParameters.CELL_MATRIX_SIZE, GofParameters.CELL_MATRIX_SIZE));
	}

	public Cell[][] getCellBoard() {
		return cellBoard;
	}

	public void setCellBoard(Cell[][] cellBoard) {
		this.cellBoard = cellBoard;
	}
}
