package rule;

import gui.Cell;
import parameters.GofParameters;

public class GameOfLifeRuleManager {

	private static void resetAliveNeighbours(Cell[][] cellBoard) {
		for (int i = 0; i < GofParameters.CELL_MATRIX_SIZE; i++) {
			for (int j = 0; j < GofParameters.CELL_MATRIX_SIZE; j++) {
				Cell processingCell = cellBoard[i][j];
				processingCell.resetLiveNeigbourCounter();
			}
		}
	}

	private static void executeRules(Cell[][] cellBoard) {
		for (int i = 0; i < GofParameters.CELL_MATRIX_SIZE; i++) {
			for (int j = 0; j < GofParameters.CELL_MATRIX_SIZE; j++) {
				Cell processingCell = cellBoard[i][j];
				if (processingCell.isAlive()) {
					if (processingCell.getLiveNeigbourCounter() < 2
							|| processingCell.getLiveNeigbourCounter() > 3) {
						processingCell.setAlive(false);
					}
				} else {
					if (processingCell.getLiveNeigbourCounter() == 3) {
						processingCell.setAlive(true);
					}
				}
			}
		}
	}

	private static void countAliveNeighbours(Cell[][] cellBoard) {
		for (int i = 0; i < GofParameters.CELL_MATRIX_SIZE; i++) {
			for (int j = 0; j < GofParameters.CELL_MATRIX_SIZE; j++) {
				Cell processingCell = cellBoard[i][j];
				countAliveNeighbours(cellBoard, i, j, processingCell);
			}
		}
	}

	private static void countAliveNeighbours(Cell[][] cellBoard, int i, int j,
			Cell processingCell) {
		countNeighbour(cellBoard, i, j - 1, processingCell);
		countNeighbour(cellBoard, i + 1, j + 1, processingCell);
		countNeighbour(cellBoard, i - 1, j - 1, processingCell);
		countNeighbour(cellBoard, i + 1, j - 1, processingCell);
		countNeighbour(cellBoard, i - 1, j + 1, processingCell);
		countNeighbour(cellBoard, i + 1, j, processingCell);
		countNeighbour(cellBoard, i - 1, j, processingCell);
		countNeighbour(cellBoard, i, j + 1, processingCell);
	}

	private static void countNeighbour(Cell[][] cellBoard, int i, int j,
			Cell processingCell) {
		if (isAlive(cellBoard, i, j)) {
			processingCell.countLiveNeighbour();
		}
	}

	private static boolean isAlive(Cell[][] cellBoard, int x, int y) {
		return isOk(x) && isOk(y) && cellBoard[x][y].isAlive();
	}

	private static boolean isOk(int x) {
		return x >= 0 && x < GofParameters.CELL_MATRIX_SIZE;
	}

	public static void clearBoard(Cell[][] cellBoard) {
		for (int i = 0; i < GofParameters.CELL_MATRIX_SIZE; i++) {
			for (int j = 0; j < GofParameters.CELL_MATRIX_SIZE; j++) {
				Cell processingCell = cellBoard[i][j];
				processingCell.setAlive(false);
			}
		}
	}

	public static void inverseBoard(Cell[][] cellBoard) {
		for (int i = 0; i < GofParameters.CELL_MATRIX_SIZE; i++) {
			for (int j = 0; j < GofParameters.CELL_MATRIX_SIZE; j++) {
				Cell processingCell = cellBoard[i][j];
				processingCell.setAlive(!processingCell.isAlive());
			}
		}
	}

	public static void run(Cell[][] cellBoard) {
		countAliveNeighbours(cellBoard);
		executeRules(cellBoard);
		resetAliveNeighbours(cellBoard);
	}

	public static boolean isDeadAll(Cell[][] cellBoard) {
		for (int i = 0; i < GofParameters.CELL_MATRIX_SIZE; i++) {
			for (int j = 0; j < GofParameters.CELL_MATRIX_SIZE; j++) {
				Cell processingCell = cellBoard[i][j];
				if (processingCell.isAlive()) {
					return false;
				}
			}
		}
		return true;
	}
}
