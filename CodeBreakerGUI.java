package codeBreaker;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class CodeBreakerGUI extends Application {

	private String secretNumber;
	private String guessNumber = "";
	private int guessLength = 0;
	private int maxGuesses = 16;
	private int wins = 0;
	private int losses = 0;
	private int inPos = 0;
	private int outPos = 0;

	private Label guessLab = new Label("");
	private Label yourEntryLab = new Label("Your \nEntry\n\n");
	private Label inPosLab = new Label("In \nPosition\n\n");
	private Label outPosLab = new Label("Out of \nPosition\n\n");
	private Label remaining = new Label("Guesses Remaining: " + this.maxGuesses);

	public void start(Stage primaryStage) {

		VBox vbox = new VBox(30);
		vbox.setAlignment(Pos.CENTER);
		HBox hbox = new HBox(10);
		hbox.setPrefWidth(70);
		hbox.setAlignment(Pos.CENTER);
		HBox statsBox = new HBox(10);
		statsBox.setAlignment(Pos.CENTER);
		VBox vboxN = new VBox(10);
		vboxN.setAlignment(Pos.TOP_CENTER);
		VBox vbox0 = new VBox(10);
		vbox0.setAlignment(Pos.TOP_CENTER);
		VBox vbox1 = new VBox(10);
		vbox1.setAlignment(Pos.TOP_CENTER);
		VBox vbox2 = new VBox(10);
		vbox2.setAlignment(Pos.TOP_CENTER);
		vbox2.setMinWidth(80);
		VBox vbox3 = new VBox(10);
		vbox3.setAlignment(Pos.TOP_CENTER);
		vbox3.setMinWidth(65);
		VBox vbox4 = new VBox(10);
		vbox4.setAlignment(Pos.TOP_CENTER);
		vbox4.setMinWidth(65);

		Label titleLab = new Label("Can you guess the 4 digit code?");

		Button viewStats = new Button("View Stats");
		viewStats.setOnAction(e -> viewStats());
		Button resetStats = new Button("Reset Stats");
		resetStats.setOnAction(e -> resetStats());

		HBox hbox1 = new HBox(10);
		hbox1.setAlignment(Pos.CENTER);
		HBox hbox2 = new HBox(10);
		HBox hbox3 = new HBox(10);
		HBox hbox4 = new HBox(10);
		HBox hbox5 = new HBox(10);
		HBox hbox6 = new HBox(10);
		HBox hbox7 = new HBox(10);
		HBox hbox8 = new HBox(10);

		Button but0 = new Button("0");
		but0.setMinWidth(hbox.getPrefWidth());
		but0.setOnAction(e -> addNumToGuess(but0, vboxN, but0));
		Button but1 = new Button("1");
		but1.setMinWidth(hbox.getPrefWidth());
		but1.setOnAction(e -> addNumToGuess(but1, vboxN, but0));
		Button but2 = new Button("2");
		but2.setMinWidth(hbox.getPrefWidth());
		but2.setOnAction(e -> addNumToGuess(but2, vboxN, but0));
		Button but3 = new Button("3");
		but3.setMinWidth(hbox.getPrefWidth());
		but3.setOnAction(e -> addNumToGuess(but3, vboxN, but0));
		Button but4 = new Button("4");
		but4.setMinWidth(hbox.getPrefWidth());
		but4.setOnAction(e -> addNumToGuess(but4, vboxN, but0));
		Button but5 = new Button("5");
		but5.setMinWidth(hbox.getPrefWidth());
		but5.setOnAction(e -> addNumToGuess(but5, vboxN, but0));
		Button but6 = new Button("6");
		but6.setMinWidth(hbox.getPrefWidth());
		but6.setOnAction(e -> addNumToGuess(but6, vboxN, but0));
		Button but7 = new Button("7");
		but7.setMinWidth(hbox.getPrefWidth());
		but7.setOnAction(e -> addNumToGuess(but7, vboxN, but0));
		Button but8 = new Button("8");
		but8.setMinWidth(hbox.getPrefWidth());
		but8.setOnAction(e -> addNumToGuess(but8, vboxN, but0));
		Button but9 = new Button("9");
		but9.setMinWidth(hbox.getPrefWidth());
		but9.setOnAction(e -> addNumToGuess(but9, vboxN, but0));

		Button butClear = new Button("CLR");
		butClear.setMinWidth(hbox.getPrefWidth());
		butClear.setOnAction(e -> clearEntry(vboxN, but0, but1, but2, but3, but4, but5, but6, but7, but8, but9));
		Button butCheck = new Button("Check");
		butCheck.setMinWidth(hbox.getPrefWidth());
		butCheck.setOnAction(e -> checkGuess(this.guessNumber, this.secretNumber, vboxN, but0, but1, but2, but3, but4, but5, but6, but7, but8, but9));
		Button butReveal = new Button("Reveal");
		butReveal.setMinWidth(hbox.getPrefWidth());
		butReveal.setOnAction(e -> revealAnswer(vboxN, but0, this.secretNumber));
		Button butNew = new Button("New");
		butNew.setMinWidth(hbox.getPrefWidth());
		butNew.setOnAction(e -> newGame(vboxN, but0, but1, but2, but3, but4, but5, but6, but7, but8, but9));
		Button butExit = new Button("Exit");
		butExit.setMinWidth(hbox.getPrefWidth());
		butExit.setOnAction(e -> exit());

		statsBox.getChildren().addAll(viewStats, resetStats);

		hbox1.getChildren().addAll(guessLab);
		hbox2.getChildren().addAll(but1, but2, but3);
		hbox3.getChildren().addAll(but4, but5, but6);
		hbox4.getChildren().addAll(but7, but8, but9);
		hbox5.getChildren().addAll(butClear, but0, butCheck);
		hbox6.getChildren().addAll(butReveal);
		hbox7.getChildren().addAll(butNew, butExit);
		hbox8.getChildren().addAll(remaining);

		vboxN.getChildren().addAll(hbox1, hbox2, hbox3, hbox4);
		vbox0.getChildren().addAll(hbox5, hbox6, hbox7, hbox8);
		vbox1.getChildren().addAll(vboxN, vbox0);
		vbox2.getChildren().add(yourEntryLab);
		vbox3.getChildren().add(inPosLab);
		vbox4.getChildren().add(outPosLab);

		hbox.getChildren().addAll(vbox1, vbox2, vbox3, vbox4);
		vbox.getChildren().addAll(titleLab, statsBox, hbox);

		createSecretNumber();

		Scene scene = new Scene(vbox, 500, 500);
		primaryStage.setTitle("CODE BREAKER");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	private void createSecretNumber() {
		List<String> nums = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			nums.add(Integer.toString(i));
		}

		Collections.shuffle(nums);
		ArrayList<String> newNums = new ArrayList<String>();
		for (int j = 0; j < 4; j++) {
			newNums.add(nums.get(j));
		}

		String text = "";
		for (int i = 0; i < newNums.size(); i++) {
			text = text + newNums.get(i);
			this.secretNumber = text;
		}
	}

	public void addNumToGuess(Button e, VBox vboxN, Button but0) {
		e.setDisable(true);
		this.guessLength = this.guessLength + 1;
		String text = this.guessLab.getText() + e.getText();
		this.guessNumber = this.guessNumber + e.getText();
		this.guessLab.setText(text);

		if (this.guessLength >= 4) {
			vboxN.setDisable(true);
			but0.setDisable(true);
		}

	}

	public void checkGuess(String guessNumber, String secretNumber, VBox vboxN, Button but0, Button but1, Button but2, Button but3, Button but4, Button but5, Button but6, Button but7, Button but8, Button but9) {
		this.maxGuesses -= 1;
		this.remaining.setText("Guess remaining: " + this.maxGuesses);
		this.inPos = 0;
		this.outPos = 0;
		if (guessNumber.equals(secretNumber)) {

			String entryText = this.yourEntryLab.getText() + guessNumber + "\n";
			String inPosText = this.inPosLab.getText() + "-";
			String outPosLab = this.outPosLab.getText() + "-";
			this.yourEntryLab.setText(entryText);
			this.inPosLab.setText(inPosText);
			this.outPosLab.setText(outPosLab);
			this.wins +=1;
			
			String text = this.secretNumber + ": Correct! \nYou win.  Do you want to play again?";
			Alert alert = new Alert(AlertType.CONFIRMATION, text);
			alert.setTitle("You win");
			alert.setHeaderText(null);
			alert.showAndWait().ifPresent(response -> {
				if(response == ButtonType.OK) {
					newGame(vboxN, but0, but1, but2, but3, but4, but5, but6, but7, but8, but9);
				} else {
					//System.exit(0);
					;
				}
			});
			
		} else {
			for (int i = 0; i < guessNumber.length(); i++) {
				char char1 = guessNumber.charAt(i);
				for (int j = 0; j < secretNumber.length(); j++) {
					char char2 = secretNumber.charAt(j);
					if ((char1 == char2) && (i == j)) {
						this.inPos += 1;
					} else if ((char1 == char2) && (i != j)) {
						this.outPos += 1;
					} else {
						;
					}
				}

			}

			String entryText = this.yourEntryLab.getText() + guessNumber + "\n";
			String inPosText = this.inPosLab.getText() + this.inPos + "\n";
			String outPosLab = this.outPosLab.getText() + this.outPos + "\n";
			this.yourEntryLab.setText(entryText);
			this.inPosLab.setText(inPosText);
			this.outPosLab.setText(outPosLab);
		}

		
		if(this.maxGuesses == 0) {
			this.losses +=1;
			String text = "No guesses remaining.  Do you want to play again?";
			Alert alert = new Alert(AlertType.CONFIRMATION, text);
			alert.setTitle("You lose");
			alert.setHeaderText(null);
			alert.showAndWait().ifPresent(response -> {
				if(response == ButtonType.OK) {
					newGame(vboxN, but0, but1, but2, but3, but4, but5, but6, but7, but8, but9);
				} else {
					
					System.exit(0);
				}
			});
			 
		}

	}

	public void revealAnswer(VBox vboxN, Button but0, String secretNumber) {
		this.losses += 1;
		vboxN.setDisable(true);
		but0.setDisable(true);
		String entryText = this.yourEntryLab.getText() + secretNumber;
		String inPosText = this.inPosLab.getText() + "-";
		String outPosLab = this.outPosLab.getText() + "-";
		this.yourEntryLab.setText(entryText);
		this.inPosLab.setText(inPosText);
		this.outPosLab.setText(outPosLab);
		
	}

	public void clearEntry(VBox vboxN, Button but0, Button but1, Button but2, Button but3, Button but4, Button but5,
			Button but6, Button but7, Button but8, Button but9) {
		this.guessNumber = "";
		this.guessLength = 0;
		this.guessLab.setText(this.guessNumber);
		vboxN.setDisable(false);
		but0.setDisable(false);
		but1.setDisable(false);
		but2.setDisable(false);
		but3.setDisable(false);
		but4.setDisable(false);
		but5.setDisable(false);
		but6.setDisable(false);
		but7.setDisable(false);
		but8.setDisable(false);
		but9.setDisable(false);

	}

	public void newGame(VBox vboxN, Button but0, Button but1, Button but2, Button but3, Button but4, Button but5,
			Button but6, Button but7, Button but8, Button but9) {
		
		this.guessNumber = "";
		this.guessLength = 0;
		this.maxGuesses = 16;
		this.guessLab.setText(this.guessNumber);
		this.yourEntryLab.setText("Your \nEntry\n\n");
		this.inPosLab.setText("In \nPosition\n\n");
		this.outPosLab.setText("Out of \nPosition\n\n");
		this.remaining.setText("Guesses Remaining: " + this.maxGuesses);
		vboxN.setDisable(false);
		but0.setDisable(false);
		but1.setDisable(false);
		but2.setDisable(false);
		but3.setDisable(false);
		but4.setDisable(false);
		but5.setDisable(false);
		but6.setDisable(false);
		but7.setDisable(false);
		but8.setDisable(false);
		but9.setDisable(false);
		createSecretNumber();
	}

	public void viewStats() {

		String text = "Wins: " + this.wins + "\nLosses: " + this.losses;
		Alert alert = new Alert(AlertType.INFORMATION, text);
		alert.setTitle("Statistics");
		alert.setHeaderText(null);
		alert.showAndWait();
	}

	public void resetStats() {
		this.wins = 0;
		this.losses = 0;
		String text = "Wins: 0 \nLosses: 0";
		Alert alert = new Alert(AlertType.INFORMATION, text);
		alert.setTitle("Reset Statistics");
		alert.setHeaderText(null);
		alert.showAndWait();
	}
	
	public void exit() {
		String text = "Are you sure you want to exit?";
		Alert alert = new Alert(AlertType.CONFIRMATION, text);
		alert.setTitle("Exit game");
		alert.setHeaderText(null);
		alert.showAndWait().ifPresent(response -> {
			if(response == ButtonType.OK) {
				System.exit(0);
			} else {
				;
			}
		});
		
		
	}

	public static void main(String[] args) {
		Application.launch(args);

	}
}
