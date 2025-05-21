package chapter12.lecture;

import java.util.Collections;
import java.util.List;

public class Lecture {
    private String title;
    private int pass;
    private List<Integer> scores;

    public Lecture(String title, int pass, List<Integer> scores) {
        this.title = title;
        this.pass = pass;
        this.scores = scores;
    }

    public double average() {
        return scores.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    public List<Integer> getScores() {
        return Collections.unmodifiableList(scores);
    }

    public String evaluate() {
        return String.format("Pass: %d, Fail: %d", passCount(), failCount());
    }

    private long passCount() {
        return scores.stream()
                .filter(score -> score >= pass)
                .count();
    }

    private long failCount() {
        return scores.size() - passCount();
    }
}
