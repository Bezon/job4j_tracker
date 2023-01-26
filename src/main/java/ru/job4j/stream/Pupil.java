package ru.job4j.stream;

import java.util.List;
import java.util.stream.Stream;

public record Pupil(String name, List<Subject> subjects) {
}
