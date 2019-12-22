package pl.academy.schedule.generator;

import pl.academy.schedule.parameters.EnteredParameters;

public interface IScheduleGenerator {
    Schedule generateSchedule(EnteredParameters enteredParameters);
}
