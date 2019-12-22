package pl.academy.schedule.parameters;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public class EnteredParameters {
    private Set<DayOfWeek> lessonDays;
    private LocalTime beginTime;
    private LocalTime endTime;
    private int requiredHours;
    private LocalDate startDate;
    private String fileName;

    public Set<DayOfWeek> getLessonDays() {
        return lessonDays;
    }

    public LocalTime getBeginTime() {
        return beginTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getRequiredHours() {
        return requiredHours;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public String getFileName() {
        return fileName;
    }

    private EnteredParameters(Set<DayOfWeek> lessonDays, LocalTime beginTime,
                              LocalTime endTime, int requiredHours,
                              LocalDate startDate, String fileName) {
        this.lessonDays = lessonDays;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.requiredHours = requiredHours;
        this.startDate = startDate;
        this.fileName = fileName;
    }

    public static class Builder {
        private Set<DayOfWeek> lessonDays;
        private LocalTime beginTime;
        private LocalTime endTime;
        private int requiredHours;
        private LocalDate startDate;
        private String fileName;

        public Builder(LocalTime beginTime, LocalTime endTime, int requiredHours) {
            this.beginTime = beginTime;
            this.endTime = endTime;
            this.requiredHours = requiredHours;
        }


        public Builder withLessonDays(Set<DayOfWeek> lessonDays) {
            this.lessonDays = lessonDays;
            return this;

        }

        public Builder withStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder withFileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public EnteredParameters build() {
            return new EnteredParameters(lessonDays, beginTime, endTime, requiredHours, startDate, fileName);
        }


    }

}
