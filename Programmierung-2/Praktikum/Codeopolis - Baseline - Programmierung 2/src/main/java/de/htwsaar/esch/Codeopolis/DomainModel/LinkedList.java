package de.htwsaar.esch.Codeopolis.DomainModel;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LinkedList<T> implements Iterable<T> {
    private Node<T> start; // début de la liste
    private Node<T> end; // va jusqu'en fin de liste
    private int size;

    public static class Node<T> { // Der Typ des Datenobjekts muss generisch sein.
        T obj; // Die Klasse Node benötigt ein Feld um ein Datenobjekt zu speichern.
        Node<T> next; //  eine Referenz auf das nächste Element in der Liste.

        public Node(T obj) {
            this.obj = obj;
            this.next = null;
        }
    }

    public LinkedList() {
        start = null; // initialise liste vide
        end = null; // initialise liste vide
        size = 0; // initialise liste vide
    }

    public void add(T elem) {

        Node<T> newNode = new Node<>(elem);

        if (start == null) { // si la liste est vide on ajoute par défaut un élément
            start = newNode;
            end = newNode;
        }
        else { // si par contre elle n'est pas vide on ajoute un élément après le dernier élément
            end.next = newNode;
            end = newNode;
        }

        size++;
    }

    public void removeFirst() {

        if (start == null) // si la liste est vide on s'arrête
            return;

        start = start.next; //sinon on attribue directement à la valeur du début l'élément suivant

        if (start == null) //si par contre l'élément suivant est vide on considère que la liste est vide
            end = null;

        size--;
    }

    public boolean isEmpty() {
        return size == 0; //on vérifie si la taille de la liste est égale à 0 on envie true/false en fonction
    }

    public int size() {
        return size; // on renvoie la taille
    }

    public T get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> getter = start; // on attribue l'élément de départ comme initalisation

        for (int i = 0; i < index; i++) {
            getter = getter.next; // on avance tant qu'on a pas atteint l'index
        }

        return getter.obj; // on retourne l'objet / l'élément à l'index
    }

    public T set(int index, T elem) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> setter = start; // on attribue l'élément de départ comme initalisation

        for (int i = 0; i < index; i++) {
            setter = setter.next;
        }

        T oldValue = setter.obj; // on copie l'ancien élément
        setter.obj = elem; // on met le nouveau
        return oldValue; // mais on return bien l'ancien commme demandé dans l'exo
    }

    public void clear() {
        start = null;
        end = null;
        size = 0;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        //si on veut supprimer le premier élément
        if (index == 0) {
            start = start.next; // on attribue la valeur après la valeur de début pour supprimer le premier élément
            if (start == null) { // si par contre la nouvelle valeur est vide la liste est donc vide donc on considère que end vide aussi
                end = null;
            }
            size--;
            return;
        }
        // si on veut supprimer un élément quelconque dans la liste
        Node<T> prev = start; // on commence au début de la liste
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next; // on parcourt la liste jusqu'à arriver à l'index -1
        }
        prev.next = prev.next.next; // on supprime l'élément à l'index choisi
        // si on veut supprimer le dernier élément
        if (prev.next == null) {
            end = prev;
        }
        size--;
    }

    public void addAll(T[] list) {
        for (T elem : list) {
            add(elem); // on ajoute tous les éléments contenu dans une autre liste
        }
    }

    public void sort(Comparator<T> comparator) {
        if (size <= 1) return;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            Node<T> current = start;

            while (current != null && current.next != null) {
                if (comparator.compare(current.obj, current.next.obj) > 0) {
                    T temp = current.obj;
                    current.obj = current.next.obj;
                    current.next.obj = temp;
                    swapped = true;
                }
                current = current.next;
            }
        }
    }

    public LinkedList<T> filter(Predicate<T> predicate) {
        LinkedList<T> result = new LinkedList<>();

        for (T elem : this) {
            if (predicate.test(elem)) {
                result.add(elem);
            }
        }
        return result;
    }

    public void forEach(Consumer<? super T> consumer) {
        for (T elem : this) {
            consumer.accept(elem);
        }
    }

    public void removeIf(Predicate<T> predicate) {
        Node<T> current = start;
        Node<T> prev = null;

        while (current != null) {
            if (predicate.test(current.obj)) {
                if (prev == null) {
                    start = current.next;
                } else {
                    prev.next = current.next;
                }
                if (current == end) {
                    end = prev;
                }
                size--;
            } else {
                prev = current;
            }
            current = current.next;
        }
    }

    public void addIf(T elem, Predicate<T> predicate) {
        if (predicate.test(elem)) {
            add(elem);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = start;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext())
                    throw new NoSuchElementException();

                T obj = current.obj;
                current = current.next;
                return obj;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = start;

        while (current != null) {
            sb.append(current.obj);

            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
