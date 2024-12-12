package vn.techzen.academy_pnv_12.models;


public class Student {
    private int id;
    private String name;
    private int score;

    public Student() {}
    public Student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }
}
