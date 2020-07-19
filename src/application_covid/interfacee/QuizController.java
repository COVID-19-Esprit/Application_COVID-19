package application_covid.interfacee;
import application_covid.entities.Quiz;
import application_covid.entities.QuizResponse;
import application_covid.entities.QuizType;
import application_covid.entities.SMSOAuthObject;
import application_covid.services.QuizCRUD;
import application_covid.services.SMSAPIService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;

public class QuizController implements Initializable {

    private QuizCRUD quizCRUD = new QuizCRUD();
    private static Map<Integer,Boolean> selectedAnswers = new HashMap<>();

    @FXML
    private AnchorPane anchor;

    @FXML
    private Pagination pagination;

    private static List<Quiz> quizzes;

    private static int validatedTab = 0;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        quizzes = getQuizzes();


        pagination.setMaxPageIndicatorCount(quizzes.size());
        pagination.setPageCount(quizzes.size());
        System.out.println(quizzes.size());

         // FXMLLoader loader = new FXMLLoader(getClass().getResource("/Quiz.fxml"));


        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer integer) {
                if(validatedTab >= integer) {
                    return createQuizUI(integer);
                }
                return null;
            }

        });

    }

    private List<Quiz> getQuizzes() {
        try {
            quizzes = quizCRUD.getAllQuizzes();
            return  quizzes;
        }catch (SQLException exception) {
            exception.printStackTrace();
            return new ArrayList<Quiz>();
        }
    }


    public VBox createQuizUI(int pageIndex) {
        ArrayList<QuizResponse> answers = new ArrayList<QuizResponse>();
        ArrayList<CheckBox> checkBoxes = new ArrayList<CheckBox>();
        VBox box = new VBox();
        if (!(quizzes.isEmpty())) {
            /** Title Label */
            Label titleLabel = new Label(quizzes.get(pageIndex).getTitle());
            titleLabel.setTextFill(Color.WHITE);
            titleLabel.setFont(new Font( 32));
            titleLabel.setPadding(new Insets(16));
            /** Question Label */
            Label questionLabel = new Label(quizzes.get(pageIndex).getQuestion());
            questionLabel.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
            questionLabel.setTextFill(Color.BLACK);
            questionLabel.setFont(new Font(20));
            questionLabel.setWrapText(true);
            questionLabel.setPadding(new Insets(16));
            /** Get Responses */
            ArrayList<QuizResponse> quizResponses = new ArrayList<>();
            try {
                quizResponses = quizCRUD.getResponsesByQuiz(quizzes.get(pageIndex));
            }catch (SQLException ex){
                ex.printStackTrace();
            }

            /** Adding UI component to Box */
            box.getChildren().add(titleLabel);
            box.getChildren().add(questionLabel);
            /** Adding Answers UI */
            for (int i=0;i<quizResponses.size();i++){
                Region spacer = new Region();
                spacer.setPrefHeight(40);
                CheckBox checkBox = new CheckBox(quizResponses.get(i).getContent());
                checkBox.setFont(new Font(15));

                if (selectedAnswers.containsKey(quizResponses.get(i).getId())) {
                    checkBox.setSelected(selectedAnswers.get(quizResponses.get(i).getId()));
                }
                checkBox.setStyle("-fx-text-fill: white;");
                box.getChildren().add(spacer);
                box.getChildren().add(checkBox);

                if (i == quizResponses.size()-1){
                    onChangeLastOneListenerMethod(quizResponses,i,checkBox,checkBoxes,answers,pageIndex);
                }else {
                    onChangeListenerMethod(quizResponses,i,checkBox,checkBoxes,answers,pageIndex);
                }
                checkBoxes.add(checkBox);
            }

            if (pageIndex == quizzes.size() - 1) {
                Region spacer = new Region();
                spacer.setPrefHeight(80);
                box.getChildren().add(spacer);
                box.getChildren().add(buildValidateButton());
            }

        }
        return box;
    }

    private void disableLastChoice(ArrayList<CheckBox> checkBoxes){
        if (checkBoxes.get(checkBoxes.size()-1).isSelected()){
            checkBoxes.get(checkBoxes.size()-1).setSelected(false);
        }
    }

    private void disableOtherChoices(ArrayList<CheckBox> checkBoxes){
        checkBoxes.forEach((CheckBox checkBox) -> {
            if (!checkBox.equals(checkBoxes.get(checkBoxes.size() - 1))) {
                checkBox.setSelected(false);
            }
        });
    }

    private void onChangeLastOneListenerMethod(ArrayList<QuizResponse> quizResponses,
                                 int i, CheckBox checkBox,
                                 ArrayList<CheckBox> checkBoxes,
                                 ArrayList<QuizResponse> answers,
                                 int pageIndex) {
        ArrayList<QuizResponse> finalQuizResponses = quizResponses;
        int index = i;
        checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {

                if (t1) {
                    disableOtherChoices(checkBoxes);
                    answers.clear();
                    answers.add(finalQuizResponses.get(finalQuizResponses.size()-1));
                    selectedAnswers.put(finalQuizResponses.get(index).getId(),true);
                }else {
                    selectedAnswers.put(finalQuizResponses.get(index).getId(),false);
                    answers.remove(quizResponses.get(i));
                }
                /// Available tabs

                    if (!answers.isEmpty()) {
                        validatedTab = pageIndex + 1;
                    } else {
                        validatedTab = pageIndex;
                    }

            }
        });

    }

    private void onChangeListenerMethod(ArrayList<QuizResponse> quizResponses,
                          int i, CheckBox checkBox,
                          ArrayList<CheckBox> checkBoxes,
                          ArrayList<QuizResponse> answers,
                          int pageIndex) {
        ArrayList<QuizResponse> finalQuizResponses = quizResponses;
        int index2 = i;
        checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    if (answers.contains(finalQuizResponses.get(finalQuizResponses.size()-1))) {
                        disableLastChoice(checkBoxes);
                        answers.clear();
                    } else {
                        answers.remove(finalQuizResponses.get(finalQuizResponses.size()-1));
                    }
                    selectedAnswers.put(finalQuizResponses.get(index2).getId(),true);
                    answers.add(finalQuizResponses.get(finalQuizResponses.size()-1));
                }else {
                    selectedAnswers.put(finalQuizResponses.get(index2).getId(),false);
                    answers.remove(quizResponses.get(i));
                }
                if (!answers.isEmpty()){
                    validatedTab = pageIndex + 1;
                }else {
                    validatedTab = pageIndex;
                }

            }
        });
    }

    private HBox buildValidateButton()  {
        Region spacer = new Region();
        spacer.setPrefHeight(80);
        Button validateButton = new Button("Validate Answers");
        validateButton.setPadding(new Insets(20));
        HBox hBox = new HBox();

        validateButton.setOnAction((actionEvent -> {
            /* */
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultatQuiz.fxml"));
                    Parent root = loader.load();
                    ResultatQuiz resultatQuiz = loader.getController();

                    if(resultSum() > 50) {
                        resultatQuiz.initializeButtonClick("Your symptoms require prompt management" +
                                "--Isolate yourself and wear a surgical mask--" +
                                "--Do not travel to consult a private or public health facility--" +
                                "--Call 190 immediately--" +
                                "--To fight against your fever avoid taking Anti-inflammatories and take paracetamol--");
                    }else {
                        resultatQuiz.initializeButtonClick("--Your state of health does not require any health intervention--"+
                                "--Restez chez vous et limitez vos contacts avec les autres--"+
                                "--Respect the hygienic measures--");
                    }


                    pagination.getScene().setRoot(root);

                } catch (IOException e) {
                    e.printStackTrace();
                }

        }));

        hBox.setAlignment(Pos.BASELINE_RIGHT);
        hBox.getChildren().add(validateButton);
        return hBox;
    }

    private double resultSum() {
        double result = 0.0;
        for(Map.Entry<Integer,Boolean> entry: selectedAnswers.entrySet()) {
            try {
                result = result + quizCRUD.getResponsePointsById(entry.getKey());
            }catch (SQLException e){
                e.printStackTrace();
            }

        }
        return result;
    }

    private boolean validateAnswersWhenMultiChoice(ArrayList<QuizResponse> answers,ArrayList<QuizResponse> responses) {
        if (responses.contains(answers.get(answers.size() - 1))) {
            return !(responses.size() > 1);
        } else {
            return true;
        }
    }

    private boolean validateAnswersWhenYesOrNo(ArrayList<QuizResponse> responses) {
        return (responses.size() == 1);
    }


}
