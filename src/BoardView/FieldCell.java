package BoardView;

import entities.base.Enemy;
import entities.base.Interactable;
import gui.GameController;
import javafx.geometry.Insets;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class FieldCell extends Pane {

	private Enemy enemy;
	private Tooltip tooltip;

	public FieldCell() {
		this.setPrefHeight(200);
		this.setPrefWidth(200);

		this.setOnMouseClicked(e -> {
			onClickHandler();
		});

		this.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setBackgroundColor();
		this.setUpTooltip();
	}

	private void onClickHandler() {
		// TODO Auto-generated method stub
		if (enemy != null) {
			((Interactable) enemy).interact(GameController.getPlayer());
			getTooltip()
					.setText("Name: " + getEnemy().getEnemyName() + "\n" + "Lifepoint: " + getEnemy().getLifePoint());
			if (enemy.isDead()) {
				setBackgroundColor();
				this.enemy = null;
				if (getTooltip() != null) {
					getTooltip().hide();
				}
			}
		}

	}

	public void setBackgroundColor() {
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
	}

	public void setBackgroundColor(Image image) {
		BackgroundFill bgFill = new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = { bgFill };
		BackgroundSize bgSize = new BackgroundSize(200, 200, false, false, false, false);
		BackgroundImage bgImg = new BackgroundImage(image, null, null, null, bgSize);
		BackgroundImage[] bgImgA = { bgImg };
		this.setBackground(new Background(bgFillA, bgImgA));
	}

	private void setUpTooltip() {
		tooltip = new Tooltip();
		tooltip.setFont(new Font(12));
		this.setOnMouseMoved((MouseEvent e) -> {
			if (enemy != null)
				tooltip.show(this, e.getScreenX(), e.getScreenY() + 10);
		});
		this.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});
	}

	public Enemy getEnemy() {
		return enemy;
	}

	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}

	public Tooltip getTooltip() {
		return tooltip;
	}

}
