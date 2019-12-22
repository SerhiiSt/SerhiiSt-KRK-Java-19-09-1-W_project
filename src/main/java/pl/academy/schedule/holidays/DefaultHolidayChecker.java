package pl.academy.schedule.holidays;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

public class DefaultHolidayChecker implements HolidayChecker {
    @Override
    public Collection<LocalDate> getHolidays(LocalDate startDate, LocalDate endDate) {
        return Collections.emptyList();
    }
}
