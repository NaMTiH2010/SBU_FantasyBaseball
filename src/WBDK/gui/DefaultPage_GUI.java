/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WBDK.gui;

import static WBDK.WBDK_StartupConstants.PATH_CSS;
import WBDK.data.WBDK_DataView;
import java.awt.Button;
import javafx.stage.Stage;

/**
 *
 * @author MatthewLuce
 */
public class DefaultPage_GUI extends WBDK_DataView {

    public DefaultPage_GUI(Stage initPrimaryStage, Stage initSecondaryStage) {
        super(initPrimaryStage,initSecondaryStage);
        //primaryStage = initPrimaryStage;
        //secondaryStage = initSecondaryStage;
    }
}

