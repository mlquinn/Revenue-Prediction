package RevPredic.view;

import RevPredic.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.text.DecimalFormat;

public class AmortizedCalculatorController {
    @FXML
    TextField principal_tf;
    @FXML
    TextField interest_tf;
    @FXML
    TextField time_tf;
    @FXML
    Text result_text;
    @FXML
    ImageView image;

    private static DecimalFormat percentFormat = new DecimalFormat("#0.0%");
    private static DecimalFormat dollarFormat = new DecimalFormat("$###,##0.00");

    private MainApp mainApp;

    public AmortizedCalculatorController(){

    }

    @FXML
    private void initialize(){
        Image logo = new Image("File:resources/images/RevPredic_Amortized_Loan_Icon.png");
        image.setImage(logo);

        result_text.setText("");

    }

    @FXML
    private void handleCalcButton(){
        AmortizedLoan();
    }

    /**
     *     A = P ( (r(1+r)^n) / ( (1+ r)^n -1 ) )
     * @param A = Payment Amount
     * @param P = Principal Amount
     * @param r = Interest Rate
     * @param n = Number of Payments
     */
    private void AmortizedLoan() {
       double A,P,R,r,n;

       P = Double.parseDouble(principal_tf.getText());
       R = Double.parseDouble(interest_tf.getText());
       n = Double.parseDouble(time_tf.getText());
       r = R /100;

       A = P * ((r *Math.pow((1 + r), n)) / (Math.pow((1 + r), n) - 1));

       result_text.setText("With an amortized loan of " + dollarFormat.format(P) + " at an interest rate of " +
       percentFormat.format(r) + " for " + n + " months, your monthly payment will be " + dollarFormat.format(A));
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
