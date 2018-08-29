package RevPredic;

import RevPredic.view.RootLayoutController;
import RevPredic.view.SimpleCalculatorController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * need to fix issue of imagea and files not building into the JAR file for deployment.
 * also think about adding new calculation feature
 */

public class MainApp extends Application {
    Stage primaryStage;
    public BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("RevPredic");
        this.primaryStage.getIcons().add(new Image("File:resources/images/RevPredic_App_Icon.png"));

        initRootLayout();
        showSimpleCalculator();
    }

    /**
     * Initialize the SimpleCalculator FXML file
     */
    public void showSimpleCalculator(){
        try {
            // Load Simple Calculator.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SimpleCalculator.fxml"));
            AnchorPane simpleCalculator = loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(simpleCalculator);

            //Give the controller access to the main app.
            SimpleCalculatorController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes the root layout
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
