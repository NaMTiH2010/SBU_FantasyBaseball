/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.gui;

import static WBDK.WBDK_StartupConstants.PATH_IMAGES;
import WBDK.controller.PlayersEditController;
import WBDK.data.Draft;
import WBDK.data.Player;
import WBDK.data.Team;
import WBDK.data.WBDK_DataManager;
import static WBDK.data.WBDK_DataView.CLASS_HEADING_LABEL;
import static WBDK.data.WBDK_DataView.CLASS_PROMPT_LABEL;
import static WBDK.data.WBDK_DataView.CLASS_SUBHEADING_LABEL;
import static WBDK.data.WBDK_DataView.PRIMARY_STYLE_SHEET;
import static WBDK.gui.YesNoCancelDialog.CANCEL;
import java.io.File;
import java.io.IOException;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import properties_manager.PropertiesManager;

/**
 *
 * @author MatthewLuce
 */
public class PlayersItemDialog extends Stage{
    MessageDialog messageDialog;
    private boolean foolproofChoices;
    private boolean fTeamComboChoice;
    private boolean posComboChoice;
    private boolean conComboChoice;
    private boolean salaryTextChoice;
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
    
    public PlayersItemDialog(Stage primaryStage, Draft draft, MessageDialog messageDialog) {
        this.messageDialog = messageDialog;
        fakeTeam = new Team();
        playerItem = new Player();
        this.draft = draft;
     // MAKE THIS DIALOG MODAL, MEANING OTHERS WILL WAIT
        // FOR IT WHEN IT IS DISPLAYED
        initModality(Modality.WINDOW_MODAL);
        initOwner(primaryStage);
    }

    public Player showEditPlayerItemDialog(Player itemToEdit) {
        fTeamComboChoice = false;
        posComboChoice = false;
        conComboChoice = false;
        salaryTextChoice = false;
        foolproofChoices = false;
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 20, 20, 20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        completeButton = new Button("Complete");
        cancelButton = new Button(CANCEL);
        // REGISTER EVENT HANDLERS FOR OUR BUTTONS
        EventHandler completeCancelHandler = (EventHandler<ActionEvent>) (ActionEvent ae) -> {
            
            if(contract_ComboBox.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("(Choose Contract)"))
                conComboChoice = false;
            else
                conComboChoice = true;
            
            if(ft_ComboBox.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("(Choose Team)")
                    || ft_ComboBox.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("(empty)"))
                fTeamComboChoice = false;
            else
                fTeamComboChoice = true;
            if(pos_ComboBox.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("(Choose Position)")
                    || pos_ComboBox.getSelectionModel().getSelectedItem().toString().equalsIgnoreCase("(empty)")) 
                posComboChoice = false;
            else
                posComboChoice = true;
            
            
            if(fTeamComboChoice == true && posComboChoice == true && conComboChoice == true && salaryTextChoice == true)
                foolproofChoices = true;
            
            if(fakeTeam.getTaxiTime() == true && draft.isItTaxiTime() == false){
                foolproofChoices = false;
                messageDialog.show("Starting Lineup is Full.\n"
                        + " It is Not time to Choose Taxi Squad Players Yet\n"
                        + "Please Choose Another Team or Hit Cancel");
                       
            }
                
            
            Button sourceButton = (Button)ae.getSource();
            PlayersItemDialog.this.selection = sourceButton.getText();
            if(selection.equals(COMPLETE) && foolproofChoices == true)
                PlayersItemDialog.this.hide();
            if(selection.equals(CANCEL))
                PlayersItemDialog.this.hide();
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
        salaryTextField.setText("(Choose Salary)");
        salaryTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            //StringProperty temp = null;
           // temp.set(newValue);
            itemToEdit.setSalary(newValue);
            if(newValue.equalsIgnoreCase(""))
                salaryTextChoice = false;
            else
                salaryTextChoice = true;
        });
        
        
        
        // SET UP THE FANTASY HBOX
        ft_Label = new Label("Fantasy Team: ");
        ft_ComboBox = new ComboBox();
        
        ft_ComboBox.setValue("(Choose Team)");
        //ft_ComboBox.setValue(fakeTeam);
        if(draft.getTeams().isEmpty())
            ft_ComboBox.setItems(fakeTeam.getEmptyList());
        else
            ft_ComboBox.setItems(draft.getTeams());
        
        // SET UP THE CONTRACT HBOX
        contract_Label = new Label("Contract: ");
        contract_ComboBox = new ComboBox();
        contract_ComboBox.setItems(draft.getContracts());
        contract_ComboBox.setValue("(Choose Contract)");
        contract_ComboBox.setOnAction((event) -> {
            itemToEdit.setContractStatus((String) contract_ComboBox.getSelectionModel().getSelectedItem());
            });
        // SET UP THE POSITION HBOX
        pos_Label = new Label("Position: ");
        pos_ComboBox = new ComboBox();
        pos_ComboBox.setValue("(Choose Position)");
        pos_ComboBox.setItems(fakeTeam.getEmptyList());
        
        ft_ComboBox.setOnAction((event) -> {
            fakeTeam = (Team) ft_ComboBox.getSelectionModel().getSelectedItem();
            if(fakeTeam.getNumPlayersNeeded()>0)
                pos_ComboBox.setItems(fakeTeam.getPositionsNeeded(itemToEdit.getPositions()));
            else if(fakeTeam.getTaxiSquad().size()>=8)
                pos_ComboBox.setItems(fakeTeam.getPositions()); 
            else
                pos_ComboBox.setItems(fakeTeam.getEmptyList());
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
        playerItem.setFantasyTeam(ft_ComboBox.getSelectionModel().getSelectedItem().toString());
        return playerItem;
    }

    public boolean wasCompleteSelected() {
        return selection.equals(COMPLETE);
    }

    public Player getPlayerItem() {
        return playerItem;
    }

  

   

    public Player showAddPlayerDialog(){
       gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 20, 20, 20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
       completeButton = new Button("Complete");
        cancelButton = new Button(CANCEL);
        // REGISTER EVENT HANDLERS FOR OUR BUTTONS
        EventHandler completeCancelHandler = (EventHandler<ActionEvent>) (ActionEvent ae) -> {
            Button sourceButton = (Button)ae.getSource();
            PlayersItemDialog.this.selection = sourceButton.getText();
            PlayersItemDialog.this.hide();
        };
        completeButton.setOnAction(completeCancelHandler);
        cancelButton.setOnAction(completeCancelHandler);
        
        
        headingLabel = new Label("Player Details");
        headingLabel.getStyleClass().add(CLASS_HEADING_LABEL);
        int count =0;
        String positionsString = "";
        // SET THE DIALOG TITLE
        setTitle("Add New Player ");
        Label firstNameLabel = new Label("First Name: ");
        Label lastNameLabel = new Label("Last Name");
        Label proTeamLabel = new Label("Pro Team");
        HBox theChecks = new HBox();
        theChecks.setSpacing(5);
        CheckBox ss_CB = new CheckBox("SS");
        CheckBox c_CB = new CheckBox("C");
        CheckBox p_CB = new CheckBox("P");
        CheckBox of_CB = new CheckBox("OF");
        CheckBox firstBase_CB = new CheckBox("1B");
        CheckBox secondBase_CB = new CheckBox("2B");
        CheckBox thirdBase_CB = new CheckBox("3B");
        TextField firstNameText = new TextField();
        TextField lastNameText = new TextField();
        ComboBox proTeamComboBox = new ComboBox();
        //playerNameLabel.getStyleClass().add(CLASS_PROMPT_LABEL);
        // RESET THE LECTURE ITEM OBJECT WITH DEFAULT VALUES
        playerItem = new Player();
        
        proTeamComboBox.setItems(draft.getProTeams());
        gridPane.add(headingLabel, 0, 0, 1, 1);
        gridPane.add(firstNameLabel, 0, 1, 1, 1);
        gridPane.add(firstNameText, 1, 1, 1, 1);
        gridPane.add(lastNameLabel, 0, 2, 1, 1);
        gridPane.add(lastNameText, 1, 2, 1, 1);
        gridPane.add(proTeamLabel, 0, 3, 1, 1);
        gridPane.add(proTeamComboBox, 1, 3, 1, 1);
        
        theChecks.getChildren().add(c_CB);
        theChecks.getChildren().add(firstBase_CB);
        theChecks.getChildren().add(thirdBase_CB);
        theChecks.getChildren().add(secondBase_CB);
        theChecks.getChildren().add(ss_CB);
        theChecks.getChildren().add(of_CB);
        theChecks.getChildren().add(p_CB);
        gridPane.add(theChecks, 0, 4, 2, 1);
        gridPane.add(completeButton, 0, 12);
        gridPane.add(cancelButton, 1, 12);
        
        firstNameText.textProperty().addListener((observable, oldValue, newValue) -> {
            playerItem.setFirstName(newValue);
        });
        lastNameText.textProperty().addListener((observable, oldValue, newValue) -> {
            playerItem.setLastName(newValue);
        });
        
        // AND PUT THE GRID PANE IN THE WINDOW
        dialogScene = new Scene(gridPane);
        dialogScene.getStylesheets().add(PRIMARY_STYLE_SHEET);
        this.setScene(dialogScene);
        
        // AND OPEN IT UP
        this.showAndWait();
        
        
        if(c_CB.isSelected()){
            if(count>0)
               positionsString+= "_C";
            else
               positionsString+= "C";
                
            count+=1;
        }
        if(firstBase_CB.isSelected()){
            if(count>0)
               positionsString+= "_1B";
            else
               positionsString+= "1B";
                
            count+=1;
        }
        if(thirdBase_CB.isSelected()){
            if(count>0)
               positionsString+= "_3B";
            else
               positionsString+= "3B";
                
            count+=1;
        }
        if(secondBase_CB.isSelected()){
            if(count>0)
               positionsString+= "_2B";
            else
               positionsString+= "2B";
                
            count+=1;
        }
        if(ss_CB.isSelected()){
            if(count>0)
               positionsString+= "_SS";
            else
               positionsString+= "SS";
                
            count+=1;
        }
        if(of_CB.isSelected()){
            if(count>0)
               positionsString+= "_OF";
            else
               positionsString+= "OF";
                
            count+=1;
        }
        if(p_CB.isSelected()){
            if(count>0)
               positionsString+= "_P";
            else
               positionsString+= "P";
                
            count+=1;
        }
        
        playerItem.setQp(positionsString);
        playerItem.setTeam((String) proTeamComboBox.getSelectionModel().getSelectedItem());
        //int theIndex = draft.getTeams().indexOf(proTeamComboBox.getSelectionModel().getSelectedItem());
                
        //draft.getTeams().get(theIndex).addStartingLineupPlayer(playerItem);
        
        
        return playerItem;
    }
    
    public Team getFakeTeam() {
        return fakeTeam;
    }
public boolean getFoolProofChoices(){
    return foolproofChoices;
}
   
    

    
}
