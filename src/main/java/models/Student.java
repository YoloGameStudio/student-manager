package models;

import java.util.ArrayList;
import java.util.List;

public class Student {
    public static final String NAME_FIELD = "name";

    private String name;
    private List<Subject> subjects;

    public Student() {
        this.name = "";
        this.subjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        StringBuilder subjectsInfo = new StringBuilder();
        for(Subject subject: subjects) {
            subjectsInfo.append(subject.toString() + " ");
        }
        return "Name: " + name + " Subjects: " + subjectsInfo;
    }
}
