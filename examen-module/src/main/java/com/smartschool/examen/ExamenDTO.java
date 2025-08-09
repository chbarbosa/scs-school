package com.smartschool.examen;

import java.time.LocalDate;

public class ExamenDTO {
    private String subject;
    private LocalDate date;
    private double score;

    public ExamenDTO() {
    }

    public ExamenDTO(String subject, LocalDate date, double score) {
        this.subject = subject;
        this.date = date;
        this.score = score;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
