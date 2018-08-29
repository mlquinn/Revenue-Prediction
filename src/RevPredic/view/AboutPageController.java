package RevPredic.view;

import RevPredic.MainApp;
import RevPredic.util.tools;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;


import java.io.IOException;
import java.nio.charset.Charset;

public class AboutPageController {
    @FXML
    ImageView imageView;
    @FXML
    Text aboutLabel;
    @FXML
    Button okBtn;

    //Reference the file path for the about page text file
    final static private String aboutFileURL = "resources/About.txt";

    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public AboutPageController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        //Set the image
        Image logoIcon = new Image("File:resources/images/Quinnovations_Logo02_LowRes_Negative.png");
        imageView.setImage(logoIcon);

        //Set default about page if about text file is not found
        String aboutString = "Author: Michael Quinn\n" +
                "\nwww.Quinnovations.com";
        try {
            aboutString = tools.readFile(aboutFileURL, Charset.defaultCharset());
        }catch (IOException e){
            e.printStackTrace();
        }
        aboutLabel.setText(aboutString);
    }

    @FXML
    private void handleOkButton(){
        mainApp.showSimpleCalculator();
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
