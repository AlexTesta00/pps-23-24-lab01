package filtered;

import java.util.Optional;
import java.util.function.Predicate;

public interface CircularFilteredList {

    void add(Integer element);
    Optional<Integer> filteredNext(Predicate<Integer> filter);

}
