package pl.academy.schedule.generator;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

public class Schedule {
    private final Collection<LocalDate> lessons;
    private boolean successfulSchedule;

    public Schedule(Collection<LocalDate> lessons, boolean successfulSchedule) {
        this.lessons = lessons;
        this.successfulSchedule = successfulSchedule;
    }

    public Collection<LocalDate> getLessons() {
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
                lessons.equals(schedule.lessons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessons, successfulSchedule);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "lessons=" + lessons +
                ", successfulSchedule=" + successfulSchedule +
                '}';
    }
}
