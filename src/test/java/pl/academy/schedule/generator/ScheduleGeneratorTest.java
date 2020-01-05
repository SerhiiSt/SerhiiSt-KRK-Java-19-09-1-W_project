package pl.academy.schedule.generator;

import org.junit.jupiter.api.Test;
import pl.academy.schedule.parameters.EnteredParameters;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.EnumSet;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ScheduleGeneratorTest {

    @Test
    void generateSchedule_AbleToGenerateSuccessfulSchedule() {
        //given
        LocalTime beginTime = LocalTime.of(10, 0);
        LocalTime endTime = LocalTime.of(12, 0);
        int requiredHours = 4;
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        EnteredParameters enteredParameters = new EnteredParameters.Builder(beginTime, endTime, requiredHours)
                .withLessonDays(EnumSet.of(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY))
                .withStartDate(startDate)
                .build();

        //when
        IScheduleGenerator scheduleGenerator = new ScheduleGenerator();
        Schedule schedule = scheduleGenerator.generateSchedule(enteredParameters);

        //then
        Lesson lesson1 = new Lesson(LocalDate.of(2020, 1, 1), beginTime, endTime);
        Lesson lesson2 = new Lesson(LocalDate.of(2020, 1, 6), beginTime, endTime);
        Schedule expectedSchedule = new Schedule(List.of(lesson1, lesson2), true);

        assertThat(schedule, equalTo(expectedSchedule));
    }

    @Test
    void generateSchedule_AbleToGenerateUnsuccessfulSchedule() {
        //given
        LocalTime beginTime = LocalTime.of(10, 0);
        LocalTime endTime = LocalTime.of(12, 0);
        int requiredHours = 5;
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        EnteredParameters enteredParameters = new EnteredParameters.Builder(beginTime, endTime, requiredHours)
                .withLessonDays(EnumSet.of(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY))
                .withStartDate(startDate)
                .build();

        //when
        IScheduleGenerator scheduleGenerator = new ScheduleGenerator();
        Schedule schedule = scheduleGenerator.generateSchedule(enteredParameters);

        //then
        Lesson lesson1 = new Lesson(LocalDate.of(2020, 1, 1), beginTime, endTime);
        Lesson lesson2 = new Lesson(LocalDate.of(2020, 1, 6), beginTime, endTime);
        Lesson lesson3 = new Lesson(LocalDate.of(2020, 1, 8), beginTime, LocalTime.of(11, 0));
        Schedule expectedSchedule = new Schedule(List.of(lesson1, lesson2, lesson3), false);

        assertThat(schedule, equalTo(expectedSchedule));
    }

    @Test
    void generateSchedule_AbleToGenerateSuccessfulScheduleWithPartialHours() {
        //given
        LocalTime beginTime = LocalTime.of(10, 0);
        LocalTime endTime = LocalTime.of(11, 30);
        int requiredHours = 3;
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        EnteredParameters enteredParameters = new EnteredParameters.Builder(beginTime, endTime, requiredHours)
                .withLessonDays(EnumSet.of(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY))
                .withStartDate(startDate)
                .build();

        //when
        IScheduleGenerator scheduleGenerator = new ScheduleGenerator();
        Schedule schedule = scheduleGenerator.generateSchedule(enteredParameters);

        //then
        Lesson lesson1 = new Lesson(LocalDate.of(2020, 1, 1), beginTime, endTime);
        Lesson lesson2 = new Lesson(LocalDate.of(2020, 1, 6), beginTime, endTime);
        Schedule expectedSchedule = new Schedule(List.of(lesson1, lesson2), true);

        assertThat(schedule, equalTo(expectedSchedule));
    }

    @Test
    void generateSchedule_AbleToGenerateUnsuccessfulScheduleWithPartialHours() {
        //given
        LocalTime beginTime = LocalTime.of(10, 0);
        LocalTime endTime = LocalTime.of(11, 30);
        int requiredHours = 4;
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        EnteredParameters enteredParameters = new EnteredParameters.Builder(beginTime, endTime, requiredHours)
                .withLessonDays(EnumSet.of(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY))
                .withStartDate(startDate)
                .build();

        //when
        IScheduleGenerator scheduleGenerator = new ScheduleGenerator();
        Schedule schedule = scheduleGenerator.generateSchedule(enteredParameters);

        //then
        Lesson lesson1 = new Lesson(LocalDate.of(2020, 1, 1), beginTime, endTime);
        Lesson lesson2 = new Lesson(LocalDate.of(2020, 1, 6), beginTime, endTime);
        Lesson lesson3 = new Lesson(LocalDate.of(2020, 1, 8), beginTime, LocalTime.of(11, 0));
        Schedule expectedSchedule = new Schedule(List.of(lesson1, lesson2, lesson3), false);

        assertThat(schedule, equalTo(expectedSchedule));
    }


}
