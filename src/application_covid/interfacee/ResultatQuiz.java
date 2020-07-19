package application_covid.interfacee;

import application_covid.services.SMSAPIService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class ResultatQuiz extends Parent implements Initializable {

    @FXML
    private Button validateButton;

    @FXML
    private TextField phoneTextFiled;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        final Pattern pattern = Pattern.compile("^[0-9]*$");
        TextFormatter<String> formatter = new TextFormatter<String>((change -> {
            if (pattern.matcher(change.getControlNewText()).matches()) {
                return change;
            }else {
                return null;
            }
        }));
        phoneTextFiled.setTextFormatter(formatter);
    }

    public void initializeButtonClick(String result) {
        validateButton.setOnAction((actionEvent -> {
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultatQuiz2.fxml"));
                Parent root = loader.load();
                if(phoneTextFiled.getText().length() == 8) {
                    SMSAPIService.sendSMS(
                            "21654549928",
                            "216" + phoneTextFiled.getText(),
                            result
                    );
                    phoneTextFiled.getScene().setRoot(root);
                } else {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Invalid Number");
                    alert.setContentText("The number should composed by 8 digits to be valid");
                    alert.setHeaderText("This is no a valid number in Tunisia");
                    alert.showAndWait();
                }

            }catch (IOException ex) {
                ex.printStackTrace();
            }
        }));
    }



}

/*

 "Your symptoms require prompt management" +
                                "--Isolate yourself and wear a surgical mask--" +
                                "--Do not travel to consult a private or public health facility--" +
                                "--Call 190 immediately--" +
                                "--To fight against your fever avoid taking Anti-inflammatories and take paracetamol--"



* */
