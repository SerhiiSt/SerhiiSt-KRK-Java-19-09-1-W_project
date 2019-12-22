package pl.academy.schedule.holidays;

import java.time.LocalDate;
import java.util.Collection;

public interface HolidayChecker {
    Collection<LocalDate> getHolidays(LocalDate startDate, LocalDate endDate);
}
