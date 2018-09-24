package ru.job4j.tree;

import java.util.*;

/**
 * Class  Tree.
 *
 * @author Tatyana Fukova
 * @version $I$
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    public Node<E> root;
    private int modCount = 0;


    /**
     * Constructor.
     *
     * @param value value.
     */
    public Tree(E value) {

        this.root = new Node(value);
        modCount++;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    /**
     * method to add the child el to parent el-t.
     *
     * @return result.
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (this.findBy(child).equals(Optional.empty())) {
            Optional<Node<E>> prnt = this.findBy(parent);
            if (!prnt.equals(Optional.empty())) {
                prnt.get().add(new Node<>(child));
                result = true;
                modCount++;
            }
        }
        return result;

    }

    public boolean isBinary() {
        boolean result = true;

        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.leaves().size() > 2) {
                result = false;
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return result;
    }


    @Override
    public Iterator<E> iterator() {

        LinkedList<Node<E>> data = new LinkedList<>();
        Queue<Node<E>> tempQueue = new LinkedList<>();
        tempQueue.offer(root);
        data.offer(root);
        while (!tempQueue.isEmpty()) {
            Node<E> el = tempQueue.poll();
            for (Node<E> child : el.leaves()) {
                data.offer(child);
                tempQueue.offer(child);
            }
        }

        return new Iterator<E>() {

            private int iteratorCount = 0;
            private int expectedModCount = modCount;


            @Override
            public boolean hasNext() {

                boolean result = false;
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (this.iteratorCount < modCount) {
                    result = true;
                }
                return result;
            }


            @Override
            public E next() {

                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                E element = data.get(iteratorCount).getValue();
                iteratorCount++;
                return element;
            }
        };
    }
}
