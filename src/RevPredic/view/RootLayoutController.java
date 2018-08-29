package RevPredic.view;

import RevPredic.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


public class RootLayoutController {
    // Reference to the main application
    private MainApp mainApp;

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Opens the Simple calculator tool
     */
    @FXML
    private void handleSimpleCalculator(){
        try{
            //Load the about page
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SimpleCalculator.fxml"));
            AnchorPane simpleCalc = loader.load();

            //Set about page to rootLayout
            mainApp.rootLayout.setCenter(simpleCalc);

            //Set the controller
            SimpleCalculatorController controller = loader.getController();
            controller.setMainApp(mainApp);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Opens the Compound calculator tool
     */
    @FXML
    private void handleCompoundCalculator(){
        try{
            //Load the about page
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/CompoundCalculator.fxml"));
            AnchorPane compoundCalc = loader.load();
            compoundCalc.setPadding(new Insets(-20,0,5,0));

            //Set about page to rootLayout
            mainApp.rootLayout.setCenter(compoundCalc);

            //Set the controller
            CompoundCalculatorController controller = loader.getController();
            controller.setMainApp(mainApp);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Opens the Amortized Loan Calculator
     */
    @FXML
    private void handleAmortizedLoan(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/AmortizedCalculator.fxml"));
            AnchorPane amortized = loader.load();

            mainApp.rootLayout.setCenter(amortized);

            AmortizedCalculatorController controller = loader.getController();
            controller.setMainApp(mainApp);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void handleNumericCalculator(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/TraditionalCalculator.fxml"));
            AnchorPane numeric = loader.load();

            mainApp.rootLayout.setCenter(numeric);

            TraditionalCalculatorController controller = loader.getController();
            controller.setMainApp(mainApp);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Opens an about page in main app.
     */
    @FXML
    private void handleAbout() {
        Scene previousScene = mainApp.rootLayout.getScene();
        try{
            //Load the about page
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/AboutPage.fxml"));
            AnchorPane aboutPage = loader.load();

            //Set about page to rootLayout
            mainApp.rootLayout.setCenter(aboutPage);

            //Set the controller
            AboutPageController controller = loader.getController();
            controller.setMainApp(mainApp);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    /**
     * closes the program
     */
    @FXML
    private void handleClose(){
        System.exit(0);
    }
}
