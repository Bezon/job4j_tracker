package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        Double amount = 0D;
        int i = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                amount += subject.score();
                i++;
            }
        }
        return amount / i;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> score = new ArrayList<>();
        for (Pupil pupil : pupils) {
            Double amount = 0D;
            int i = 0;
            for (Subject subject : pupil.subjects()) {
                amount += subject.score();
                i++;
            }
            score.add(new Label(pupil.name(), amount / i));
        }
        return score;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> score = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(), map.getOrDefault(subject.name(), 0) + subject.score());
            }
            count++;
        }
        for (String s : map.keySet()) {
            score.add(new Label(s, map.get(s) / count));
        }
        return score;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> score = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int amount = 0;
            for (Subject subject : pupil.subjects()) {
                amount += subject.score();
            }
            score.add(new Label(pupil.name(), amount));
        }
        score.sort(Comparator.naturalOrder());
        return score.get(score.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> score = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(), map.getOrDefault(subject.name(), 0) + subject.score());
            }
            count++;
        }
        for (String s : map.keySet()) {
            score.add(new Label(s, map.get(s)));
        }
        score.sort(Comparator.naturalOrder());
        return score.get(score.size() - 1);
    }
}
