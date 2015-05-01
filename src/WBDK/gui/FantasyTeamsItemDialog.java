/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.gui;

import WBDK.data.Draft;
import WBDK.data.Player;
import WBDK.data.Team;
import static WBDK.data.WBDK_DataView.CLASS_HEADING_LABEL;
import static WBDK.data.WBDK_DataView.PRIMARY_STYLE_SHEET;
import static WBDK.gui.PlayersItemDialog.COMPLETE;
import static WBDK.gui.YesNoCancelDialog.CANCEL;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author MatthewLuce
 */
public class FantasyTeamsItemDialog extends Stage{
    
    public static final String COMPLETE = "Complete";
    Player playerItem;
    GridPane gridPane;
    Scene dialogScene;
    Label headingLabel;
    Label pageHeadingLabel;
    Label salaryLabel;
    Label ft_Label;
    Label pos_Label;
    Label contract_Label;
    TextField salaryTextField;
    //Label dateLabel;
    //DatePicker datePicker;
    //Label urlLabel;
    //TextField urlTextField;
    Button completeButton;
    Button cancelButton;
    ComboBox ft_ComboBox;
    ComboBox pos_ComboBox;
    ComboBox contract_ComboBox;
    HBox ft_HBox;
    HBox pos_HBox;
    HBox contract_HBox;
    Image image;
    Image image2;
    String selection;
    Label playerPosLabel;
    Label playerNameLabel;
    public static final String EDIT_PLAYER_TITLE = "Edit Player";
    Draft draft;
    Team fakeTeam;
    
    public FantasyTeamsItemDialog(Stage primaryStage, Draft draft, MessageDialog messageDialog) {
        fakeTeam = new Team();
        playerItem = new Player();
        this.draft = draft;
     // MAKE THIS DIALOG MODAL, MEANING OTHERS WILL WAIT
        // FOR IT WHEN IT IS DISPLAYED
        initModality(Modality.WINDOW_MODAL);
        initOwner(primaryStage);
    }
    
     public Team showAddTeamDialog() {
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 20, 20, 20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        completeButton = new Button("Complete");
        cancelButton = new Button(CANCEL);
        // REGISTER EVENT HANDLERS FOR OUR BUTTONS
        EventHandler completeCancelHandler = (EventHandler<ActionEvent>) (ActionEvent ae) -> {
            Button sourceButton = (Button)ae.getSource();
            FantasyTeamsItemDialog.this.selection = sourceButton.getText();
            FantasyTeamsItemDialog.this.hide();
        };
        completeButton.setOnAction(completeCancelHandler);
        cancelButton.setOnAction(completeCancelHandler);
        
        
        fakeTeam = new Team("Default Name","Default Owner");
        Label teamName = new Label("Name: ");
        Label ownerName = new Label("Owner: ");
        TextField teamNameText = new TextField();
        TextField ownerNameText = new TextField();
        HBox nameBox = new HBox();
        HBox ownerBox =  new HBox();
        HBox completeCancelBox = new HBox();
        headingLabel = new Label("Fantasy Team Details");
        headingLabel.getStyleClass().add(CLASS_HEADING_LABEL);
        //headingLabel.setText("Fantasy Team Details");
        
        
        teamNameText.textProperty().addListener((observable, oldValue, newValue) -> {
            fakeTeam.setName(newValue);
        });
        ownerNameText.textProperty().addListener((observable, oldValue, newValue) -> {
            fakeTeam.setOwner(newValue);
        });
        nameBox.getChildren().add(teamName);
        nameBox.getChildren().add(teamNameText);
        ownerBox.getChildren().add(ownerName);
        ownerBox.getChildren().add(ownerNameText);
        completeCancelBox.getChildren().add(completeButton);
        completeCancelBox.getChildren().add(cancelButton);
        gridPane.add(headingLabel, 0, 0, 1, 1);
        gridPane.add(nameBox, 0, 1, 1, 1);
        
        gridPane.add(ownerBox, 0, 2, 1, 1);
        gridPane.add(completeCancelBox, 0, 3, 1, 1);
        
        // AND PUT THE GRID PANE IN THE WINDOW
        dialogScene = new Scene(gridPane);
        dialogScene.getStylesheets().add(PRIMARY_STYLE_SHEET);
        this.setScene(dialogScene);
        // AND OPEN IT UP
        this.showAndWait();
        return fakeTeam;
    }

    public Team getFakeTeam() {
        return fakeTeam;
    }
    public boolean wasCompleteSelected() {
        return selection.equals(COMPLETE);
    }

    public void showRemoveTeamDialog() {
        
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 20, 20, 20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        completeButton = new Button("Complete");
        cancelButton = new Button(CANCEL);
        // REGISTER EVENT HANDLERS FOR OUR BUTTONS
        EventHandler completeCancelHandler = (EventHandler<ActionEvent>) (ActionEvent ae) -> {
            Button sourceButton = (Button)ae.getSource();
            FantasyTeamsItemDialog.this.selection = sourceButton.getText();
            FantasyTeamsItemDialog.this.hide();
        };
        completeButton.setOnAction(completeCancelHandler);
        cancelButton.setOnAction(completeCancelHandler);
        
        
        
        
        
        
        // AND PUT THE GRID PANE IN THE WINDOW
        dialogScene = new Scene(gridPane);
        dialogScene.getStylesheets().add(PRIMARY_STYLE_SHEET);
        this.setScene(dialogScene);
        // AND OPEN IT UP
        this.showAndWait();
    }
    
}
