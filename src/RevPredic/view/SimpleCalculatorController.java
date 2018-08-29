package RevPredic.view;

import RevPredic.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.text.DecimalFormat;

/**
 * fixed issue of image not loading.
 */

public class SimpleCalculatorController {
    @FXML
    TextField principal_tf;
    @FXML
    TextField interest_tf;
    @FXML
    TextField time_tf;
    @FXML
    Button calculate_Btn;
    @FXML
    Text result_Text;
    @FXML
    ImageView image;

    private static DecimalFormat percentFormat = new DecimalFormat("#0.0%");
    private static DecimalFormat dollarFormat = new DecimalFormat("$###,##0.00");


    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public SimpleCalculatorController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        //Set the image
        Image logoIcon = new Image("File:resources/images/RevPredic_SimpleCalc_Icon.png");
        image.setImage(logoIcon);
        //Clear the result text
        result_Text.setText("");
    }

    @FXML
    private void handleCalculateButton(){
        simpleInterest();
    }

    /**
     *Method for calculating the simple interest earned on an initial investment with the formula A = P(1 + rt)
     *
     *@param A	Total Accrued Amount(principal + interest)
     *@param P	Principal Amount
     *@param I	Interest Amount; r = R/100
     *@param r	Rate of Interest per year in decimal
     *@param R	Rate of Interest per year as a percent; R = r * 100
     *@param t	Time Period involved in months
     */
    private void simpleInterest(){
        double A,P,I,r,R,t;

        P = Double.parseDouble(principal_tf.getText());
        R = Double.parseDouble(interest_tf.getText());
        t = Double.parseDouble(time_tf.getText());
        r = R / 100;
        I = P * r * t;

        A = P * (1 + (r * t));

        result_Text.setText("A Principal investment of " + dollarFormat.format(P)
                + " with a Simple Interest rate at " + percentFormat.format(r)
                + " after " + t + " months, you have earned " + dollarFormat.format(I)
                + " of interest for a total value of " + dollarFormat.format(A) + "!");
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
