package pl.academy.schedule.generator;

import pl.academy.schedule.parameters.EnteredParameters;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import java.util.TreeSet;

public class ScheduleGenerator implements IScheduleGenerator {

    private EnteredParameters enteredParameters;


    public ScheduleGenerator() {
    }

    @Override
    public Schedule generateSchedule(EnteredParameters enteredParameters) {

        this.enteredParameters = enteredParameters;
        LocalTime beginTime = enteredParameters.getBeginTime();
        LocalTime endTime = enteredParameters.getEndTime();
        int lessonLength = endTime.getHour() - beginTime.getHour();


        int requiredHours = enteredParameters.getRequiredHours();
        int usedHours = 0;
        LocalDate currentDate = enteredParameters.getStartDate();


        Set<LocalDate> lessons = new TreeSet<>();


        while (usedHours < requiredHours) {
            boolean isContain = checkIfFitTo(currentDate.getDayOfWeek());
            if (isContain) {
                int remainingHours = requiredHours - usedHours;
                if (remainingHours < lessonLength) {
                    usedHours += remainingHours;
                }
                usedHours += lessonLength;
                lessons.add(currentDate);

            }
            currentDate = currentDate.plusDays(1);
        }


        return new Schedule(lessons, true);


    }

    private boolean checkIfFitTo(DayOfWeek dayOfWeek) {
        Set<DayOfWeek> lessonDays = enteredParameters.getLessonDays();
        return lessonDays.contains(dayOfWeek);
    }
}
