package BoardView;

import javafx.util.Duration;

import exception.IllegalValueException;
import gui.GameController;
import gui.HowToPlaySceneControl;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

	public final static int RESOLUTION_X = 1280;
	public final static int RESOLUTION_Y = 720;
	public static GameController gameController;
	public static HowToPlaySceneControl howToPlayControl;
	private final static int STARTTIME = 0;
	public int timeUse;

	@Override
	public void start(Stage stage) {
		// TODO Auto-generated method stub
		stage.setTitle("Sumonner CB");
		stage.setResizable(false);

		menuStart(stage);

	}

	// NEED TO FIX LAYOUT TO PUT A AUDIO CONTROL IN BOTTOM RIGHT
	public void menuStart(Stage primaryStage) {
		StackPane stackpaneRoot = new StackPane();
		stackpaneRoot.setAlignment(Pos.TOP_LEFT);
		stackpaneRoot.setPrefHeight(720);
		stackpaneRoot.setPrefWidth(1280);

		ImageView background = new ImageView(
				new Image(ClassLoader.getSystemResource("menu/background.jpg").toString()));
		background.setFitHeight(720);
		background.setFitWidth(1280);
		background.setPickOnBounds(true);
		background.setPreserveRatio(true);

		stackpaneRoot.getChildren().add(background);

		HBox hboxChild = new HBox();

		VBox vboxChild = new VBox();
		vboxChild.setPrefHeight(200);
		vboxChild.setPrefWidth(100);
		vboxChild.setPadding(new Insets(0, 0, 0, 50));

		ImageView logo = new ImageView(new Image(ClassLoader.getSystemResource("menu/logo.png").toString()));
		logo.setFitHeight(309);
		logo.setFitWidth(469);
		logo.setPickOnBounds(true);
		logo.setPreserveRatio(true);

		ImageView playImageButton = new ImageView(
				new Image(ClassLoader.getSystemResource("menu/playbutton.png").toString()));
		playImageButton.setFitHeight(150);
		playImageButton.setFitWidth(200);
		playImageButton.setPickOnBounds(true);
		playImageButton.setPreserveRatio(true);
		VBox.setMargin(playImageButton, new Insets(0, 0, 0, 125));

		ImageView helpImageButton = new ImageView(
				new Image(ClassLoader.getSystemResource("menu/helpbutton.png").toString()));
		helpImageButton.setFitHeight(150);
		helpImageButton.setFitWidth(200);
		helpImageButton.setPickOnBounds(true);
		helpImageButton.setPreserveRatio(true);
		VBox.setMargin(helpImageButton, new Insets(0, 0, 0, 125));

		ImageView creditsImageButton = new ImageView(
				new Image(ClassLoader.getSystemResource("menu/creditsbutton.png").toString()));
		creditsImageButton.setFitHeight(150);
		creditsImageButton.setFitWidth(200);
		creditsImageButton.setPickOnBounds(true);
		creditsImageButton.setPreserveRatio(true);
		VBox.setMargin(creditsImageButton, new Insets(0, 0, 0, 125));

		ImageView exitImageButton = new ImageView(
				new Image(ClassLoader.getSystemResource("menu/exitbutton.png").toString()));
		exitImageButton.setFitHeight(150);
		exitImageButton.setFitWidth(200);
		exitImageButton.setPickOnBounds(true);
		exitImageButton.setPreserveRatio(true);
		VBox.setMargin(exitImageButton, new Insets(0, 0, 0, 125));

		ImageView audioButton = new ImageView(
				new Image(ClassLoader.getSystemResource("object/audioon.png").toString()));
		audioButton.setFitHeight(150);
		audioButton.setFitWidth(100);
		audioButton.setPickOnBounds(true);
		audioButton.setPreserveRatio(true);
		HBox.setMargin(audioButton, new Insets(550, 0, 0, 550));

		AudioClip bgm = new AudioClip(ClassLoader.getSystemResource("sounds/menusound.mp3").toString());
		bgm.setCycleCount(MediaPlayer.INDEFINITE);
		bgm.setVolume(0.5D);
		bgm.stop();
		bgm.play();

		playImageButton.setOnMouseClicked(e -> {
			gameScreenStart(primaryStage);
			bgm.stop();
		});

		helpImageButton.setOnMouseClicked(e -> {
			howToPlayScene(primaryStage);
		});

		creditsImageButton.setOnMouseClicked(e -> {
			creditsScene(primaryStage);
		});

		exitImageButton.setOnMouseClicked(e -> {
			primaryStage.close();
		});

		audioButton.setOnMouseClicked(e -> {
            if (bgm.isPlaying()) {
                audioButton.setImage(new Image(ClassLoader.getSystemResource("object/audiooff.png").toString()));
                bgm.stop();
            } else {
                audioButton.setImage(new Image(ClassLoader.getSystemResource("object/audioon.png").toString()));
                bgm.play();
            }
        });

		vboxChild.getChildren().addAll(logo, playImageButton, helpImageButton, creditsImageButton, exitImageButton);
		hboxChild.getChildren().addAll(vboxChild, audioButton);
		stackpaneRoot.getChildren().add(hboxChild);

		primaryStage.setTitle("Summoner CB");
		primaryStage.setScene(new Scene(stackpaneRoot));
		primaryStage.setWidth(RESOLUTION_X);
		primaryStage.setHeight(RESOLUTION_Y);
		primaryStage.setResizable(false);

		primaryStage.show();
	}

	// set time
	public void gameScreenStart(Stage stage) {
		gameController = new GameController();
		StackPane root = new StackPane();
		root.setPrefHeight(720);
		root.setPrefWidth(1280);
		root.setAlignment(Pos.TOP_LEFT);

		ImageView background = new ImageView(
				new Image(ClassLoader.getSystemResource("menu/background.jpg").toString()));
		background.setFitHeight(720);
		background.setFitWidth(1280);
		background.setPickOnBounds(true);
		background.setPreserveRatio(true);
		background.setOpacity(0.8);

		root.getChildren().add(background);

		HBox hboxChild = new HBox();
		hboxChild.setPrefHeight(100);
		hboxChild.setPrefWidth(200);

		Pane paneLeftHboxChild = new Pane();
		paneLeftHboxChild.setPrefHeight(720);
		paneLeftHboxChild.setPrefWidth(800);
		paneLeftHboxChild.setPadding(new Insets(20, 20, 20, 20));

		ImageView board = new ImageView(new Image(ClassLoader.getSystemResource("play/board.png").toString()));
		board.setFitHeight(720);
		board.setFitWidth(800);
		board.setPickOnBounds(true);

		// new Class?
		FieldPane gridChild = new FieldPane();

		Pane paneRightHboxChild = new Pane();
		paneRightHboxChild.setPrefHeight(720);
		paneRightHboxChild.setPrefWidth(480);

		ImageView scoreFrame = new ImageView(new Image(ClassLoader.getSystemResource("play/framev2.png").toString()));
		scoreFrame.setFitHeight(720);
		scoreFrame.setFitWidth(480);
		scoreFrame.setPickOnBounds(true);

		VBox vboxChild = new VBox();
		vboxChild.setAlignment(Pos.TOP_CENTER);
		vboxChild.setPrefHeight(720);
		vboxChild.setPrefWidth(480);

		Label score = new Label();
		score.setAlignment(Pos.CENTER_LEFT);
		score.setPrefHeight(100);
		score.setPrefWidth(350);
		score.setTextFill(Color.HOTPINK);
		score.setFont(Font.font(40));

		GameController.setScoreLabelText(score);// GameController

		VBox.setMargin(score, new Insets(30, 0, 0, 0));

		Label balance = new Label();
		balance.setAlignment(Pos.CENTER_LEFT);
		balance.setPrefHeight(100);
		balance.setPrefWidth(350);
		balance.setTextFill(Color.HOTPINK);
		balance.setFont(Font.font(40));

		GameController.setBalanceLabelText(balance);// GameController

		VBox.setMargin(balance, new Insets(30, 0, 30, 0));

		// change set image to use method in GameControl
		ImageView weapon = new ImageView();// GameController
		GameController.initWeaponImage(weapon);
		weapon.setFitHeight(150);
		weapon.setFitWidth(200);
		weapon.setPickOnBounds(true);

		Label price = new Label();
		price.setAlignment(Pos.CENTER_LEFT);
		price.setPrefHeight(100);
		price.setPrefWidth(200);
		price.setTextFill(Color.HOTPINK);
		price.setFont(Font.font(40));
		price.setPadding(new Insets(0, 0, 30, 0));

		GameController.setPriceLabelText(price);// GameController

		VBox.setMargin(price, new Insets(0, 80, 0, 0));

		// GameController Change the image of weapon
		price.setOnMouseClicked(e -> {

			try {
				GameController.setWeaponImage(weapon);
				GameController.setBalanceLabelText(balance);
				GameController.setPriceLabelText(price);
			} catch (IllegalValueException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		AudioClip bgm = new AudioClip(ClassLoader.getSystemResource("sounds/ingamesound.mp3").toString());
		bgm.setCycleCount(MediaPlayer.INDEFINITE);
		bgm.setVolume(0.5D);
		bgm.play();

		HBox menu = new HBox();
		menu.setAlignment(Pos.CENTER_RIGHT);
		menu.setPrefHeight(220);
		menu.setPrefWidth(200);

		ImageView menuButton = new ImageView(
				new Image(ClassLoader.getSystemResource("play/menubutton.png").toString()));
		menuButton.setFitHeight(150);
		menuButton.setFitWidth(200);
		menuButton.setPickOnBounds(true);
		menuButton.setPreserveRatio(true);
		menuButton.setOnMouseClicked(e -> {
			bgm.stop();
			menuStart(stage);
			GameController.time.stop();
		});
		HBox.setMargin(menuButton, new Insets(0, 25, 0, 0));

		timeUse = STARTTIME;
		Label label = new Label("Time: " + Integer.toString(timeUse));
		label.setTextFill(Color.HOTPINK);
		label.setFont(Font.font(40));

		GameController.time = new Timeline();
		GameController.time.setCycleCount(Timeline.INDEFINITE);
		KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				timeUse++;
				label.setText("Time: " + Integer.toString(timeUse));
				if (timeUse % 2 == 0) {
					FieldPane.generateEnemy();
					Thread thread = new Thread(() -> {
						Platform.runLater(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								GameController.setBalanceLabelText(balance);
								GameController.setScoreLabelText(score);
							}
						});

					});
					thread.start();
				}
				if (FieldPane.isLost()) {
					Thread thread = new Thread(() -> {
						try {

							Platform.runLater(new Runnable() {
								@Override
								public void run() {
									// TODO Auto-generated method stub
									GameController.showWarning();
								}
							});
							Thread.sleep(1000);
							Platform.runLater(new Runnable() {
								@Override
								public void run() {
									// TODO Auto-generated method stub
									bgm.stop();
									menuStart(stage);
								}
							});

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					});
					thread.start();
					GameController.time.stop();

				}
			}
		});
		GameController.time.getKeyFrames().add(frame);
		GameController.time.playFromStart();

		menu.getChildren().addAll(label, menuButton);
		vboxChild.getChildren().addAll(score, balance, weapon, price, menu);
		paneRightHboxChild.getChildren().addAll(scoreFrame, vboxChild);
		paneLeftHboxChild.getChildren().addAll(board, gridChild);
		hboxChild.getChildren().addAll(paneLeftHboxChild, paneRightHboxChild);
		root.getChildren().add(hboxChild);

		stage.setScene(new Scene(root));
		stage.setWidth(RESOLUTION_X);
		stage.setHeight(RESOLUTION_Y);
		stage.setResizable(false);

		stage.show();
	}

	public void howToPlayScene(Stage stage) {
		
		howToPlayControl = new HowToPlaySceneControl();

		StackPane root = new StackPane();
		root.setPrefHeight(720);
		root.setPrefWidth(1280);
		root.setAlignment(Pos.TOP_LEFT);

		ImageView background = new ImageView(
				new Image(ClassLoader.getSystemResource("menu/background.jpg").toString()));
		background.setFitHeight(720);
		background.setFitWidth(1280);
		background.setPickOnBounds(true);
		background.setPreserveRatio(true);
		background.setOpacity(0.8);

		root.getChildren().add(background);

		VBox vboxChild = new VBox();
		vboxChild.setAlignment(Pos.TOP_CENTER);
		vboxChild.setPrefHeight(1280);
		vboxChild.setPrefWidth(720);

		ImageView frame = new ImageView();
		frame.setFitHeight(500);
		frame.setFitWidth(700);
		frame.setPickOnBounds(true);
		frame.setPreserveRatio(true);
		VBox.setMargin(frame, new Insets(50, 50, 10, 50));
		// GameControl
		frame.setImage(new Image(ClassLoader.getSystemResource("h2p/1-page.png").toString()));

		HBox hboxChild = new HBox();
		hboxChild.setAlignment(Pos.CENTER);
		hboxChild.setPrefHeight(120);
		hboxChild.setPrefWidth(200);

		ImageView prevbutton = new ImageView(new Image(ClassLoader.getSystemResource("object/prev.png").toString()));
		prevbutton.setFitHeight(100);
		prevbutton.setFitWidth(200);
		prevbutton.setPreserveRatio(true);
		prevbutton.setPickOnBounds(true);
		// GameControl
		prevbutton.setOnMouseClicked(e -> {
			HowToPlaySceneControl.prevPage(frame);
		});

		ImageView nextbutton = new ImageView(new Image(ClassLoader.getSystemResource("object/next.png").toString()));
		nextbutton.setFitHeight(100);
		nextbutton.setFitWidth(200);
		nextbutton.setPreserveRatio(true);
		nextbutton.setPickOnBounds(true);
		HBox.setMargin(nextbutton, new Insets(0, 50, 0, 50));
		// GameControl
		nextbutton.setOnMouseClicked(e -> {
			HowToPlaySceneControl.nextPage(frame);
		});

		ImageView menubutton = new ImageView(
				new Image(ClassLoader.getSystemResource("play/menubutton.png").toString()));
		menubutton.setFitHeight(150);
		menubutton.setFitWidth(200);
		menubutton.setPreserveRatio(true);
		menubutton.setPickOnBounds(true);
		// GameControl
		menubutton.setOnMouseClicked(e -> {
			menuStart(stage);
		});

		hboxChild.getChildren().addAll(prevbutton, nextbutton, menubutton);
		vboxChild.getChildren().addAll(frame, hboxChild);
		root.getChildren().add(vboxChild);

		stage.setScene(new Scene(root));
		stage.setWidth(RESOLUTION_X);
		stage.setHeight(RESOLUTION_Y);
		stage.setResizable(false);

		stage.show();
	}

	public void creditsScene(Stage stage) {

		StackPane root = new StackPane();
		root.setPrefHeight(720);
		root.setPrefWidth(1280);
		root.setAlignment(Pos.TOP_LEFT);

		ImageView background = new ImageView(
				new Image(ClassLoader.getSystemResource("menu/background.jpg").toString()));
		background.setFitHeight(720);
		background.setFitWidth(1280);
		background.setPickOnBounds(true);
		background.setPreserveRatio(true);
		background.setOpacity(0.8);

		root.getChildren().add(background);

		VBox vboxChild = new VBox();
		vboxChild.setAlignment(Pos.TOP_CENTER);
		vboxChild.setPrefHeight(1280);
		vboxChild.setPrefWidth(720);

		ImageView frame = new ImageView(new Image(ClassLoader.getSystemResource("object/credits.gif").toString()));
		frame.setFitHeight(500);
		frame.setFitWidth(700);
		frame.setPickOnBounds(true);
		frame.setPreserveRatio(true);
		VBox.setMargin(frame, new Insets(50, 50, 10, 50));

		ImageView menubutton = new ImageView(
				new Image(ClassLoader.getSystemResource("play/menubutton.png").toString()));
		menubutton.setFitHeight(150);
		menubutton.setFitWidth(200);
		menubutton.setPreserveRatio(true);
		menubutton.setPickOnBounds(true);
		// GameControl
		menubutton.setOnMouseClicked(e -> {
			menuStart(stage);
		});

		vboxChild.getChildren().addAll(frame, menubutton);
		root.getChildren().add(vboxChild);

		stage.setScene(new Scene(root));
		stage.setWidth(RESOLUTION_X);
		stage.setHeight(RESOLUTION_Y);
		stage.setResizable(false);

		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
