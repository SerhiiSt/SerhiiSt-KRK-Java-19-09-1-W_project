package pl.academy.schedule.generator;

import org.junit.jupiter.api.Test;
import pl.academy.schedule.parameters.EnteredParameters;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.EnumSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScheduleGeneratorTest {

    @Test
    void generateSchedule_AbleToGenerateSuccessfulSchedule() {

        LocalTime beginTime = LocalTime.of(10, 0);
        LocalTime endTime = LocalTime.of(12, 0);
        int requiredHours = 4;
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        EnteredParameters enteredParameters = new EnteredParameters.Builder(beginTime, endTime, requiredHours)
                .withLessonDays(EnumSet.of(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY))
                .withStartDate(startDate)
                .build();


        IScheduleGenerator scheduleGenerator = new ScheduleGenerator();
        Schedule schedule = scheduleGenerator.generateSchedule(enteredParameters);


        Collection<LocalDate> lessons = new TreeSet<>();
        lessons.add(LocalDate.of(2020, 1, 1));
        lessons.add(LocalDate.of(2020, 1, 6));
        Schedule expectedSchedule = new Schedule(lessons, true);

        assertTrue(expectedSchedule.equals(schedule));
    }

}
