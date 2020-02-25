package logic.view.component;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import logic.control.Context;
import logic.control.NumButtons;

public class ButtonsController {
	
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	@FXML private Button bOne;
	@FXML private Button bTwo;
	@FXML private Button bThree;
	@FXML private Button bFour;
	@FXML private Button bFive;
	@FXML private Button bSix;
	@FXML private Button bSeven;
	@FXML private Button bEigth;
	@FXML private Button bNine;
	@FXML private Button bZero;
	@FXML private Button bCanc;
	@FXML private Button bAdd;
	@FXML private Button bSub;
	@FXML private Button bMul;
	@FXML private Button bDiv;
	@FXML private Button bEq;
	
	@FXML private void bOneHandler(Event event) {
		logger.log(Level.INFO, "button " + ((Button)event.getSource()).getText() + " fired");
		Context.getReference().onNumButtonClick(NumButtons.ONE);
		event.consume();
	}
	@FXML private void bTwoHandler(ActionEvent event) {
		logger.log(Level.INFO, "button " + ((Button)event.getSource()).getText() + " fired");
		Context.getReference().onNumButtonClick(NumButtons.TWO);
		event.consume();
	}
	@FXML private void bThreeHandler(ActionEvent event) {
		logger.log(Level.INFO, "button " + ((Button)event.getSource()).getText() + " fired");
		Context.getReference().onNumButtonClick(NumButtons.THREE);
		event.consume();
	}
	@FXML private void bFourHandler(ActionEvent event) {
		logger.log(Level.INFO, "button " + ((Button)event.getSource()).getText() + " fired");
		Context.getReference().onNumButtonClick(NumButtons.FOUR);
		event.consume();
	}
	@FXML private void bFiveHandler(ActionEvent event) {
		logger.log(Level.INFO, "button " + ((Button)event.getSource()).getText() + " fired");
		Context.getReference().onNumButtonClick(NumButtons.FIVE);
		event.consume();
	}
	@FXML private void bSixHandler(ActionEvent event) {
		logger.log(Level.INFO, "button " + ((Button)event.getSource()).getText() + " fired");
		Context.getReference().onNumButtonClick(NumButtons.SIX);
		event.consume();
	}
	@FXML private void bSevenHandler(ActionEvent event) {
		logger.log(Level.INFO, "button " + ((Button)event.getSource()).getText() + " fired");
		Context.getReference().onNumButtonClick(NumButtons.SEVEN);
		event.consume();
	}
	@FXML private void bEightHandler(ActionEvent event) {
		logger.log(Level.INFO, "button " + ((Button)event.getSource()).getText() + " fired");
		Context.getReference().onNumButtonClick(NumButtons.EIGHT);
		event.consume();
	}
	@FXML private void bNineHandler(ActionEvent event) {
		logger.log(Level.INFO, "button " + ((Button)event.getSource()).getText() + " fired");
		Context.getReference().onNumButtonClick(NumButtons.NINE);
		event.consume();
	}
	@FXML private void bZeroHandler(ActionEvent event) {
		logger.log(Level.INFO, "button " + ((Button)event.getSource()).getText() + " fired");
		Context.getReference().onNumButtonClick(NumButtons.ZERO);
		event.consume();
	}
	@FXML private void bCancHandler(ActionEvent event) {
		logger.log(Level.INFO, "button " + ((Button)event.getSource()).getText() + " fired");
		Context.getReference().onCancButtonClick();
		event.consume();
	}
	@FXML private void bAddHandler(ActionEvent event) {
		logger.log(Level.INFO, "button " + ((Button)event.getSource()).getText() + " fired");
		Context.getReference().onAddButtonClick();
		event.consume();
	}
	@FXML private void bSubHandler(ActionEvent event) {
		logger.log(Level.INFO, "button " + ((Button)event.getSource()).getText() + " fired");
		Context.getReference().onSubButtonClick();
		event.consume();
	}
	@FXML private void bMulHandler(ActionEvent event) {
		logger.log(Level.INFO, "button " + ((Button)event.getSource()).getText() + " fired");
		Context.getReference().onMulButtonClick();
		event.consume();
	}
	@FXML private void bDivHandler(ActionEvent event) {
		logger.log(Level.INFO, "button " + ((Button)event.getSource()).getText() + " fired");
		Context.getReference().onDivButtonClick();
		event.consume();
	}
	@FXML private void bEqHandler(ActionEvent event) {
		logger.log(Level.INFO, "button " + ((Button)event.getSource()).getText() + " fired");
		Context.getReference().onEqButtonClick();
		event.consume();
	}
	
}
