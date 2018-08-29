package RevPredic.view;

import RevPredic.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.text.DecimalFormat;

public class CompoundCalculatorController {
    @FXML
    TextField principal_tf;
    @FXML
    TextField interest_tf;
    @FXML
    TextField time_tf;
    @FXML
    ChoiceBox compoundBox;
    @FXML
    Button calculate_Btn;
    @FXML
    Text result_Text;
    @FXML
    ImageView image;

    private static DecimalFormat percentFormat = new DecimalFormat("#0.0%");
    private static DecimalFormat dollarFormat = new DecimalFormat("$###,##0.00");

    ObservableList<String> compoundRates =
            FXCollections.observableArrayList("Annually", "Semi-Annually","Monthly", "Daily");


    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public CompoundCalculatorController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        //Set the image
        Image logoIcon = new Image("File:resources/images/RevPredic_Coins_Image.png");
        image.setImage(logoIcon);
        //Set the combobox options
        compoundBox.setValue("Annually");
        compoundBox.setItems(compoundRates);
        //Clear the result text
        result_Text.setText("");
    }

    @FXML
    private void handleCalculateButton(){
        compoundInterest();
    }

    /**
     *Method for calculating the simple interest earned on an initial investment with the formula A = P(1 + rt)
     *
     *@param A = the future value of the investment/loan, including interest
     *@param P = the principal investment amount (the initial deposit or loan amount)
     *@param r = the annual interest rate (decimal)
     *@param R = Rate of Interest per year as a percent; R = r * 100
     *@param n = the number of times that interest is compounded per year
     *@param t = the number of years the money is invested or borrowed for
     */
    private void compoundInterest(){
        double A,P,I,r,R,t,n;

        P = Double.parseDouble(principal_tf.getText());
        R = Double.parseDouble(interest_tf.getText());
        t = Double.parseDouble(time_tf.getText());
        r = R / 100;
        if (compoundBox.getValue() == "Annually") n = 1;
        else if (compoundBox.getValue() == "Semi-Annually") n = 2;
        else if (compoundBox.getValue() == "Monthly") n = 12;
        else if (compoundBox.getValue() == "Daily") n = 365;
        else n = 0;
        I = (P * Math.pow(( 1 + (r / n)), (n * t) )) - P;
        //Total compounded interest = P (1 + r/n) (nt) - P

        A = P * Math.pow((1 + (r / n)) , (n*t));
        //A = P (1 + r/n)^ (nt)

        if(n == 1) {
            result_Text.setText("A Principal investment of " + dollarFormat.format(P)
                    + " with an annually compounded interest rate at " + percentFormat.format(r)
                    + " after " + t + " years, you have earned " + dollarFormat.format(I)
                    + " of interest for a total value of " + dollarFormat.format(A) + "!");
        }
        else if (n == 2){
            result_Text.setText("A Principal investment of " + dollarFormat.format(P)
                    + " with a semi-annually compounded interest rate at " + percentFormat.format(r)
                    + " after " + t + " years, you have earned " + dollarFormat.format(I)
                    + " of interest for a total value of " + dollarFormat.format(A) + "!");
        }
        else if (n == 12){
            result_Text.setText("A Principal investment of " + dollarFormat.format(P)
                    + " with an monthly compounded interest rate at " + percentFormat.format(r)
                    + " after " + t + " years, you have earned " + dollarFormat.format(I)
                    + " of interest for a total value of " + dollarFormat.format(A) + "!");
        }
        else if (n == 365){
            result_Text.setText("A Principal investment of " + dollarFormat.format(P)
                    + " with a daily compounded interest rate at " + percentFormat.format(r)
                    + " after " + t + " years, you have earned " + dollarFormat.format(I)
                    + " of interest for a total value of " + dollarFormat.format(A) + "!");
        }
        else{
            result_Text.setText("");
        }
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