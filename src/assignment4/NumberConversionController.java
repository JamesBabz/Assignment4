/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.Font;

/**
 *
 * @author James
 */
public class NumberConversionController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private Label lblResult;

    @FXML
    private TextField txtNumberInput;

    @FXML
    private Button btnCalcMilesToKm;

    @FXML
    private Button btnCalcKmToMiles;

    private final NumberConversionModel ncmodel = new NumberConversionModel();

    @FXML
    private void handleButtonAction(ActionEvent event)
    {

        event.toString();
        System.out.println(event.toString());
        double txtFieldValue = Double.parseDouble(txtNumberInput.getText());
        double result = 0;
        String resultAsString;
        String formatedString;
        if ("btnCalcMilesToKm".equals(getEventId(event)))
        {
            result = ncmodel.getKilometersFromMiles(txtFieldValue);
        }
        else if ("btnCalcKmToMiles".equals(getEventId(event)))
        {
            result = ncmodel.getMilesFromKilometers(txtFieldValue);
        }
        resultAsString = String.valueOf(result);
        formatedString = String.format("%.2f", result);
        lblResult.setText(formatedString);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        TextInputDialog dialog = new TextInputDialog("");

        dialog.setTitle("Text Input Dialog");
        dialog.setContentText("Please enter your name:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent())
        {
            String message = ncmodel.getGreetingsMessage(result.get());
            label.setText(message);
            label.setFont(Font.font("Arial", 24.0));
        }
    }

    public String getEventId(Object event)
    {
        String cutEvent = event.toString();
        int start = cutEvent.indexOf("btn");
        int end = cutEvent.indexOf(",");
        cutEvent = cutEvent.substring(start, end);
        return cutEvent;
    }
}
