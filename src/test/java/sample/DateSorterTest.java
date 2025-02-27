package sample;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DateSorterTest {
    private final DateSorter dateSorter = new DateSorter();
    List<LocalDate> actualDates = Arrays.asList(LocalDate.of(2004,7,1),
            LocalDate.of(2005,1,2), LocalDate.of(2007,1,1),
            LocalDate.of(2032,5,3));
    List<LocalDate> expectedDates = Arrays.asList(LocalDate.of(2005,1,2),
            LocalDate.of(2007,1,1), LocalDate.of(2032,5,3),
            LocalDate.of(2004,7,1));

    @Test
    public void testSortEmptyList() {
        List<LocalDate> unsortedDates = new ArrayList<>();
        Collection<LocalDate> sortedDates = dateSorter.sortDates(unsortedDates);

        assertEquals(0, sortedDates.size());
    }

    @Test
    public void testSortListWithOneElement() {
        LocalDate date = LocalDate.of(2024, 4, 8);
        List<LocalDate> unsortedDates = Arrays.asList(date);
        Collection<LocalDate> sortedDates = dateSorter.sortDates(unsortedDates);

        assertEquals(1, sortedDates.size());
        assertEquals(date, sortedDates.iterator().next());
    }

    @Test
    public void testSortListWithChronologicalOrder() {
        Collection<LocalDate> sortedDates = dateSorter.sortDates(actualDates);
        assertEquals(4, sortedDates.size());
        int i = 0;
        for (LocalDate date : sortedDates) {
            assertEquals(expectedDates.get(i), date);
            i++;
        }
    }
}