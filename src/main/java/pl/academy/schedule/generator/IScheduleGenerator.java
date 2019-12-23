package pl.academy.schedule.generator;

import pl.academy.schedule.parameters.EnteredParameters;

import java.time.LocalDateTime;
import java.util.Set;

public interface IScheduleGenerator {
    Schedule generateSchedule(EnteredParameters enteredParameters);

}
