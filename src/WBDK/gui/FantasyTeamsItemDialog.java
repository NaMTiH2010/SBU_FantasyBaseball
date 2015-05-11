/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.gui;

import static WBDK.WBDK_StartupConstants.PATH_IMAGES;
import WBDK.data.Draft;
import WBDK.data.Player;
import WBDK.data.Team;
import static WBDK.data.WBDK_DataView.CLASS_HEADING_LABEL;
import static WBDK.data.WBDK_DataView.CLASS_PROMPT_LABEL;
import static WBDK.data.WBDK_DataView.PRIMARY_STYLE_SHEET;
import static WBDK.gui.PlayersItemDialog.COMPLETE;
import static WBDK.gui.PlayersItemDialog.EDIT_PLAYER_TITLE;
import static WBDK.gui.YesNoCancelDialog.CANCEL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author MatthewLuce
 */
public class FantasyTeamsItemDialog extends Stage{
    String newOwner,newTeamName;
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
    String originalTeam;
    boolean finished;
    
    public FantasyTeamsItemDialog(Stage primaryStage, Draft draft, MessageDialog messageDialog) {
        fakeTeam = new Team();
       // originalTeam = new Team();
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
    public String getOrigTeam() {
        return originalTeam;
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

    public void showEditTeamDialog() {
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
        
        
        //fakeTeam = new Team("Default Name","Default Owner");
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
            newTeamName = newValue;
        });
        ownerNameText.textProperty().addListener((observable, oldValue, newValue) -> {
            newOwner = newValue;
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
        //return fakeTeam;
    }
    public String getnewOwnerName(){
        return newOwner;
    }
    public String getNewTeamName(){
        return newTeamName;
    }
    
    public Player showEditTeamPlayerItemDialog(Player itemToEdit) {
        finished = false;
       // originalTeam = itemToEdit.getFantasyTeam();
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 20, 20, 20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        completeButton = new Button("Complete");
        cancelButton = new Button(CANCEL);
        // REGISTER EVENT HANDLERS FOR OUR BUTTONS
        EventHandler completeCancelHandler = (EventHandler<ActionEvent>) (ActionEvent ae) -> {
            if(itemToEdit.getSalary().matches("-?\\d+(\\.\\d+)?")){
                Button sourceButton = (Button)ae.getSource();
                FantasyTeamsItemDialog.this.selection = sourceButton.getText();
                FantasyTeamsItemDialog.this.hide();
            }
            
            //if(finished){ 
                
            //}
            
        };
        completeButton.setOnAction(completeCancelHandler);
        cancelButton.setOnAction(completeCancelHandler);
        
        
        headingLabel = new Label("Player Details");
        headingLabel.getStyleClass().add(CLASS_HEADING_LABEL);
        playerItem = new Player();
        // NOW THE DESCRIPTION 
        salaryLabel = new Label("Salary: ");
       // descriptionLabel.getStyleClass().add(CLASS_PROMPT_LABEL);
        
        playerNameLabel = new Label();
        playerPosLabel = new Label();
        
        salaryTextField = new TextField();
        salaryTextField.setText(itemToEdit.getSalary());
        salaryTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            //StringProperty temp = null;
           // temp.set(newValue);
            itemToEdit.setSalary(newValue);
        });
        
        
        ObservableList fantasyDropDown = FXCollections.observableArrayList();
        Team freeAgentTeam = new Team();
        freeAgentTeam.setName("Free Agent");
        fantasyDropDown  = draft.getTeams();
        fantasyDropDown.add(freeAgentTeam);
        
        // SET UP THE FANTASY HBOX
        ft_Label = new Label("Fantasy Team: ");
        ft_ComboBox = new ComboBox();
        ft_ComboBox.setValue(draft.getFantasyTeamsPage().getSelectedTeam().getName());
        ft_ComboBox.setItems(fantasyDropDown);
        
        // SET UP THE CONTRACT HBOX
        contract_Label = new Label("Contract: ");
        contract_ComboBox = new ComboBox();
        contract_ComboBox.setValue(itemToEdit.getContractStatus());
        contract_ComboBox.setItems(draft.getContracts());
        contract_ComboBox.setOnAction((event) -> {
            itemToEdit.setContractStatus((String) contract_ComboBox.getSelectionModel().getSelectedItem());
            });
        // SET UP THE POSITION HBOX
        pos_Label = new Label("Position: ");
        pos_ComboBox = new ComboBox();
        pos_ComboBox.setValue(itemToEdit.getCurrentPosition());
        ft_ComboBox.setOnAction((event) -> {
            fakeTeam = (Team) ft_ComboBox.getSelectionModel().getSelectedItem();
            itemToEdit.setFantasyTeam(fakeTeam.getName());
            System.out.println(" fantasy team is now: "+ itemToEdit.getFantasyTeam());
            pos_ComboBox.setItems(fakeTeam.getPositionsNeeded(itemToEdit.getPositions()));
            });
        pos_ComboBox.setOnAction((event) -> {
            itemToEdit.setCurrentPosition((String) pos_ComboBox.getSelectionModel().getSelectedItem());
            });
        

        // SET THE DIALOG TITLE
        setTitle(EDIT_PLAYER_TITLE);
        ImageView iv = new ImageView();
        ImageView iv2 = new ImageView();
        image = new Image("file:" + PATH_IMAGES+itemToEdit.getLastName()+itemToEdit.getFirstName()+".jpg");
        image2 = new Image("file:" + PATH_IMAGES+itemToEdit.getPlaceOfBirth()+".png");
        iv.setImage(image);
        iv2.setImage(image2);
        playerNameLabel = new Label(itemToEdit.getFirstName()+" "+itemToEdit.getLastName());
        playerNameLabel.getStyleClass().add(CLASS_PROMPT_LABEL);
        playerPosLabel = new Label(itemToEdit.getPossiblePositions());
        VBox vbox = new VBox();
        vbox.setSpacing(20);
        vbox.getChildren().add(iv2);
        vbox.getChildren().add(playerNameLabel);
        vbox.getChildren().add(playerPosLabel);
        gridPane.add(iv, 0, 1);
        gridPane.add(vbox,1,1);
                
        
        // NOW LET'S ARRANGE THEM ALL AT ONCE
        gridPane.add(headingLabel, 0, 0, 2, 1);
        gridPane.add(ft_Label, 0, 3, 1, 1);
        gridPane.add(ft_ComboBox, 1, 3, 1, 1);
        gridPane.add(pos_Label, 0,4,1,1);
        gridPane.add(pos_ComboBox, 1,4,1,1);
        gridPane.add(contract_Label, 0,5,1,1);
        gridPane.add(contract_ComboBox, 1,5,1,1);
        gridPane.add(salaryLabel, 0, 6, 1, 1);
        gridPane.add(salaryTextField, 1, 6, 1, 1);
        gridPane.add(completeButton, 1, 7, 1, 1);
        gridPane.add(cancelButton, 2, 7, 1, 1);
                
        
        // RESET THE SCHEDULE ITEM OBJECT WITH DEFAULT VALUES
        
        //playerItem = new Player();
        playerItem = itemToEdit;
        //fakeTeam = new Team();
        
        // LOAD THE UI STUFF
        //salaryTextField.setText(playerItem.getNotes());
        
        // AND PUT THE GRID PANE IN THE WINDOW
        dialogScene = new Scene(gridPane);
        dialogScene.getStylesheets().add(PRIMARY_STYLE_SHEET);
        this.setScene(dialogScene);
        // AND OPEN IT UP
        this.showAndWait();
        
        return playerItem;
    }
    
}
