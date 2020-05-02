package application_covid.services;

import application_covid.entities.Quiz;
import application_covid.entities.QuizResponse;
import application_covid.entities.QuizType;
import application_covid.utils.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuizCRUD {
    Connection connection;

    public QuizCRUD(){
        connection = MyConnection.getInstance().getCnx();
    }

    /**
     * Quiz CRUD
     * */
    public void createQuiz(Quiz quiz) throws SQLException {

        String request = "INSERT INTO quiz(title,question,quizType,points) VALUES (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(request);
        statement.setString(1,quiz.getTitle());
        statement.setString(2,quiz.getQuestion());
        statement.setString(3,quiz.getQuizType().name());
        statement.setDouble(4,quiz.getPoints());
        statement.executeUpdate();
        System.out.println("Quiz added successfully");

    }

    public void updateQuiz(Quiz quiz,int id) throws  SQLException{
        String request  = "UPDATE quiz set title=?,question=?,quizType=?,points=? Where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(request);
        preparedStatement.setString(1,quiz.getTitle());
        preparedStatement.setString(2,quiz.getQuestion());
        preparedStatement.setString(3,quiz.getQuizType().name());
        preparedStatement.setDouble(4,quiz.getPoints());
        preparedStatement.setInt(5,quiz.getId());
        preparedStatement.executeUpdate();
        System.out.println("Quiz Updated with success");
    }

    public List<Quiz> getAllQuizzes() throws SQLException {
        List<Quiz> quizzes = new ArrayList<>();
        Statement statement = connection.createStatement();
        String request = "SELECT * FROM quiz";
        ResultSet resultSet = statement.executeQuery(request);
        while (resultSet.next()){
            Quiz quiz1;
            if(resultSet.getString(4) == QuizType.MULTI_CHOICE.name()){
                quiz1 = new Quiz(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        QuizType.MULTI_CHOICE,
                        resultSet.getDouble(5)
                );
            }else {
                quiz1 = new Quiz(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        QuizType.YES_OR_NO,
                        resultSet.getDouble(5)
                );
            }
            quizzes.add(quiz1);

        }
        return quizzes;
    }

    public void deleteQuiz(Quiz quiz) throws SQLException{
        String request = "DELETE FROM quiz where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(request);
        preparedStatement.setInt(1,quiz.getId());
        preparedStatement.executeUpdate();
        System.out.println("Quiz Deleted with success");
    }

    /**
       Quiz Responses CRUD
     */
    public void createResponse(QuizResponse quizResponse) throws SQLException{
        String request = "INSERT INTO quizresponse(content,points,quiz) VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(request);
        statement.setString(1,quizResponse.getContent());
        statement.setDouble(2,quizResponse.getPoints());
        statement.setInt(3,quizResponse.getQuiz().getId());
        statement.executeUpdate();
        System.out.println("Quiz Response added successfully");
    }

    public List<QuizResponse> getResponsesByQuiz(Quiz quiz) throws SQLException{
        List<QuizResponse> quizResponses = new ArrayList<>();
        String request = "SELECT * FROM quiz where quiz=?";
        PreparedStatement statement = connection.prepareStatement(request);
        statement.setInt(1,quiz.getId());
        ResultSet resultSet = statement.executeQuery(request);
        while (resultSet.next()){
            QuizResponse quizResponse = new QuizResponse(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    quiz
            );
            quizResponses.add(quizResponse);
        }
        return quizResponses;
    }

    public void updateResponse(QuizResponse quizResponse,int id) throws Exception{
        String request  = "UPDATE quizresponse set content=?,points=?,quiz=? Where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(request);
        preparedStatement.setString(1,quizResponse.getContent());
        preparedStatement.setDouble(2,quizResponse.getPoints());
        preparedStatement.setInt(3,quizResponse.getQuiz().getId());
        preparedStatement.setDouble(4,quizResponse.getId());
        preparedStatement.executeUpdate();
        System.out.println("Quiz Response Updated with success");
    }

    public void deleteResponse(QuizResponse quizResponse) throws SQLException{
        String request = "DELETE FROM quizresponse where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(request);
        preparedStatement.setInt(1,quizResponse.getId());
        preparedStatement.executeUpdate();
        System.out.println("Quiz Response Deleted with success");
    }


}
