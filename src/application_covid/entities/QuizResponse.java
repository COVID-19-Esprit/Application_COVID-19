package application_covid.entities;

public class QuizResponse {
    int id;
    String content;
    double points;
    Quiz quiz;

    public QuizResponse(Quiz quiz){
        this.quiz = quiz;
    }

    public QuizResponse(int id, String content, double points,Quiz quiz) {
        this.id = id;
        this.content = content;
        this.points = points;
        this.quiz = quiz;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }
}
