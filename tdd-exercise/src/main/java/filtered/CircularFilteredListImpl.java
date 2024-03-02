package filtered;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;
import tdd.BasicCircularList;
import tdd.CircularList;

public class CircularFilteredListImpl implements CircularFilteredList {

        private CircularList items = new BasicCircularList();

        @Override
        public void add(Integer element) {
                this.items.add(element);
        }

        @Override
        public Optional<Integer> filteredNext(Predicate<Integer> filter) {
                return this.items.isEmpty() ? Optional.empty()
                                : Stream.generate(() -> this.items.next().get())
                                                .filter(filter)
                                                .findFirst();
        }

}
