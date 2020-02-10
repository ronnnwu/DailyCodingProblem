package chapter3.animalshelter;

import chapter2.LinkedList;
import chapter2.Node;

import java.util.EmptyStackException;

public class AnimalShelter {
    private LinkedList<Animal> ll = new LinkedList<>();
    private Node<Animal> tail;

    public void enqueue(Animal a) {
        if (ll.getRoot() == null) {
            ll = new LinkedList<>(new Node(a));
            tail = ll.getTail();
        } else {
            tail.setNext(new Node(a));
            tail = tail.getNext();
        }
    }

    public Animal dequeue() {
        if (ll.getRoot() == null) throw new EmptyStackException();
        Animal a = ll.getRoot().getData();
        ll.setRoot(ll.getRoot().getNext());
        return a;
    }

    private Animal dequeueAnimal(Class<? extends Animal> cls ){

        if (ll.getRoot() == null) throw new EmptyStackException();
        if ( cls.isInstance(ll.getRoot().getData())) return cls.cast(dequeue());
        Node<Animal> tmp = ll.getRoot();
        while (tmp.getNext() != null && ! (cls.isInstance(tmp.getNext().getData()))) {
            tmp = tmp.getNext();
        }
        if (tmp.getNext() == null) return null;
        Animal animal = cls.cast(tmp.getNext().getData());
        tmp.setNext(tmp.getNext().getNext());
        return animal;

    }

    public Dog dequeueDog() {
         return (Dog)dequeueAnimal(Dog.class);
    }

    public Cat dequeueCat() {
        return (Cat)dequeueAnimal(Cat.class);
    }

}


