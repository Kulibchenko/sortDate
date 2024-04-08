package sample;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class DateSorterTest {
    private DateSorter dateSorter;
    List<LocalDate> newList = Arrays.asList(LocalDate.parse("2004-07-01"),
            LocalDate.parse("2005-01-02"), LocalDate.parse("2007-01-01"),
            LocalDate.parse("2032-05-03"));

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
        List<LocalDate> unsortedDates = Arrays.asList(
                LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 2, 2),
                LocalDate.of(2023, 3, 3)
        );
        Collection<LocalDate> sortedDates = dateSorter.sortDates(unsortedDates);

        assertEquals(3, sortedDates.size());
        assertEquals(LocalDate.of(2023, 1, 1), sortedDates.iterator().next());
        assertEquals(LocalDate.of(2023, 2, 2), sortedDates.iterator().next());
        assertEquals(LocalDate.of(2023, 3, 3), sortedDates.iterator().next());
    }

    @Test
    public void testSortListWithReverseChronologicalOrder() {
        List<LocalDate> unsortedDates = Arrays.asList(
                LocalDate.of(2023, 3, 3),
                LocalDate.of(2023, 2, 2),
                LocalDate.of(2023, 1, 1)
        );
        Collection<LocalDate> sortedDates = dateSorter.sortDates(unsortedDates);

        assertEquals(3, sortedDates.size());
        assertEquals(LocalDate.of(2023, 1, 1), sortedDates.iterator().next());
        assertEquals(LocalDate.of(2023, 2, 2), sortedDates.iterator().next());
        assertEquals(LocalDate.of(2023, 3, 3), sortedDates.iterator().next());
    }

    @Test
    public void testSortListWithDuplicates() {
        List<LocalDate> unsortedDates = Arrays.asList(
                LocalDate.of(2023, 2, 2),
                LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 2, 2),
                LocalDate.of(2023, 3, 3)
        );
        Collection<LocalDate> sortedDates = dateSorter.sortDates(unsortedDates);

        assertEquals(3, sortedDates.size());
        assertEquals(LocalDate.of(2023, 1, 1), sortedDates.iterator().next());
        assertEquals(LocalDate.of(2023, 2, 2), sortedDates.iterator().next());
        assertEquals(LocalDate.of(2023, 3, 3), sortedDates.iterator().next());
    }
}