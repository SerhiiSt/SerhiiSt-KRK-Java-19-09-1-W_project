package pl.academy.schedule.holidays;

        import org.junit.jupiter.api.Test;

        import java.time.LocalDate;
        import java.util.Collection;

        import static org.hamcrest.MatcherAssert.assertThat;
        import static org.hamcrest.collection.IsEmptyCollection.empty;

public class DefaultHolidayCheckerTest {

    @Test
    void getHolidays_alwaysReturnsEmptyCollection() {
        HolidayChecker defaultHolidayChecker = new DefaultHolidayChecker();
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        LocalDate endDate = LocalDate.of(2020, 2, 2);
        Collection<LocalDate> holidays = defaultHolidayChecker.getHolidays(startDate, endDate);

        assertThat(holidays, empty());
    }
}
