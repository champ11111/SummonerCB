package BoardView;

import java.util.Random;

import gui.GameController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;


public class FieldPane extends GridPane {

	private static ObservableList<FieldCell> fieldCells = FXCollections.observableArrayList();
	private static int low = 0;
	private static int high = 5;
	private static int lowbox = 0;
	private static int highbox = 10;

	public FieldPane() {
		this.setHgap(50.0);
		this.setVgap(50.0);
		this.setPrefHeight(720);
		this.setPrefWidth(800);
		this.setAlignment(Pos.TOP_LEFT);
		this.setPadding(new Insets(110, 100, 110, 100));

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				FieldCell cell = new FieldCell();
				fieldCells.add(cell);
				this.add(cell, j, i);
			}
		}
	}

	public static void generateEnemy() {
		Random r = new Random();
		int result = r.nextInt(high - low) + low;
		int x = randomBoxNumber();
		int y = randomBoxNumber();
		for (FieldCell cell : fieldCells) {
			if (cell.getEnemy() == null) {
				if ((x + y) % 2 == 0) {
					cell.setEnemy(GameController.randomEnemy(result));
					Image image = new Image(ClassLoader.getSystemResource(cell.getEnemy().getUrl()).toString());
					cell.setBackgroundColor(image);
					cell.getTooltip().setText("Name: " + cell.getEnemy().getEnemyName() + "\n" + "Lifepoint: "
							+ cell.getEnemy().getLifePoint());
					x = randomBoxNumber();
					y = randomBoxNumber();
				}
			}
		}
	}

	public static int randomBoxNumber() {
		Random r = new Random();
		int result = r.nextInt(highbox - lowbox) + lowbox;
		return result;
	}

	public static boolean isLost() {
		for (FieldCell cell : fieldCells) {
			if (cell.getEnemy() == null) {
				return false;
			}
		}
		return true;
	}
}
