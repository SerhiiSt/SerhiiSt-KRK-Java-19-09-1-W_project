package pl.academy.schedule.generator;

import java.time.LocalDate;
import java.util.Collection;

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
}
