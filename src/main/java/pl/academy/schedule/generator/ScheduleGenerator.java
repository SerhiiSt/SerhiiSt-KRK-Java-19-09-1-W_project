package pl.academy.schedule.generator;

import pl.academy.schedule.parameters.EnteredParameters;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class ScheduleGenerator implements IScheduleGenerator {

    @Override
    public Schedule generateSchedule(EnteredParameters enteredParameters) {
        LocalTime beginTime = enteredParameters.getBeginTime();
        LocalTime endTime = enteredParameters.getEndTime();
        //Period period = Period.between(endTime,beginTime);

        Set<DayOfWeek> lessonDays = enteredParameters.getLessonDays();
        int requiredHours = enteredParameters.getRequiredHours();
        int usedHours = 0;
        LocalDate currentDate = enteredParameters.getStartDate();
        Collection<LocalDate> lessons = new TreeSet<>();
        do {
            while (!lessonDays.contains(currentDate.getDayOfWeek())) {
                currentDate = currentDate.plusDays(1);
                lessons.add(currentDate);
            }
        } while (usedHours >= requiredHours);


        return new Schedule(lessons, true);

    }
}
