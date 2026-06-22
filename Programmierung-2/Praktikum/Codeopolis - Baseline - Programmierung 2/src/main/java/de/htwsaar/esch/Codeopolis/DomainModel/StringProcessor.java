package de.htwsaar.esch.Codeopolis.DomainModel;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class StringProcessor {

    // Attribut
    private LinkedList<String> list;

    // Constructeur 1
    public StringProcessor() {
        this.list = new LinkedList<>();
    }

    // Constructeur 2
    public StringProcessor(LinkedList<String> initialList) {
        this.list = new LinkedList<>();
        if (initialList != null) {
            // Supposons que LinkedList implémente Iterable ou possède une méthode pour parcourir
            for (String str : initialList) {
                this.list.add(str);
            }
        }
    }

    public void add(String str) {
        this.list.add(str);
    }

    public LinkedList<String> filter(Predicate<String> predicate) {
        LinkedList<String> result = new LinkedList<>();
        for (String str : this.list) {
            if (predicate.test(str)) {
                result.add(str);
            }
        }
        return result;
    }

    public void applyToAll(UnaryOperator<String> operator) {
        LinkedList<String> updatedList = new LinkedList<>();
        for (String str : this.list) {
            String updatedStr = operator.apply(str);
            updatedList.add(updatedStr);
        }
        this.list = updatedList; // remplacement
    }

    public LinkedList<Integer> mapToInt(Function<String, Integer> function) {
        LinkedList<Integer> result = new LinkedList<>();
        for (String str : this.list) {
            Integer val = function.apply(str);
            result.add(val);
        }
        return result;
    }

    public void forEach(Consumer<String> action) {
        for (String str : this.list) {
            action.accept(str);
        }
    }
}
