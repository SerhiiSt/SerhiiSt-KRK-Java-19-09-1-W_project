package pl.academy.schedule.generator;

import java.util.List;
import java.util.Objects;

public class Schedule {
    private final List<Lesson> lessons;
    private boolean successfulSchedule;

    public Schedule(List<Lesson> lessons, boolean successfulSchedule) {
        this.lessons = lessons;
        this.successfulSchedule = successfulSchedule;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public boolean isSuccessfulSchedule() {
        return successfulSchedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return successfulSchedule == schedule.successfulSchedule &&
                Objects.equals(lessons, schedule.lessons);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "lessons=" + lessons +
                ", successfulSchedule=" + successfulSchedule +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessons, successfulSchedule);
    }
}
