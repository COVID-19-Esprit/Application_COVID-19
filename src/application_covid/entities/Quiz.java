package application_covid.entities;

public class Quiz {
    int id;
    String title;
    String question;
    QuizType quizType;
    double points;

    public Quiz(){

    }
    public Quiz(int id, String title, String question, QuizType quizType, double points) {
        this.id = id;
        this.title = title;
        this.question = question;
        this.quizType = quizType;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public QuizType getQuizType() {
        return quizType;
    }

    public void setQuizType(QuizType quizType) {
        this.quizType = quizType;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }
}
