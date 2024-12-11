package dev.mkushnir885.flowerset;

import java.util.Objects;
import java.util.Set;
import java.util.Iterator;
import java.util.Collection;
import java.util.Arrays;

import dev.mkushnir885.flowers.Flower;

/**
 * A custom implementation of a {@link Set} that stores {@link Flower} objects. Ensures that all
 * elements are unique.
 *
 * @param <F> the type of {@link Flower} stored in this set
 */
public class FlowerSet<F extends Flower> implements Set<F> {

  /**
   * An internal singly linked list to store the flowers.
   */
  private final SinglyLinkedList<F> flowers;

  /**
   * Constructs an empty {@code FlowerSet}.
   */
  public FlowerSet() {
    this.flowers = new SinglyLinkedList<>();
  }

  /**
   * Constructs a {@code FlowerSet} containing a single flower.
   *
   * @param flower the initial flower to add to the set
   */
  public FlowerSet(F flower) {
    this();
    add(flower);
  }

  /**
   * Constructs a {@code FlowerSet} containing all elements from the specified collection.
   *
   * @param flowers a collection of flowers to initialize the set
   * @throws NullPointerException if the specified collection is {@code null}
   */
  public FlowerSet(Collection<? extends F> flowers) {
    this();
    addAll(flowers);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int size() {
    return flowers.size();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isEmpty() {
    return flowers.size() == 0;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    var that = (FlowerSet<?>) o;
    return Objects.equals(this, that);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(flowers);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean contains(Object o) {
    return flowers.contains(o);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean containsAll(Collection<?> c) {
    for (Object o : c) {
      if (!contains(o)) {
        return false;
      }
    }
    return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean add(F flower) {
    if (!contains(flower)) {
      flowers.add(flower);
      return true;
    }
    return false;
  }

  /**
   * {@inheritDoc}
   * @throws NullPointerException if the specified collection is {@code null}
   */
  @Override
  public boolean addAll(Collection<? extends F> c) {
    boolean modified = false;
    for (F flower : c) {
      if (add(flower)) {
        modified = true;
      }
    }
    return modified;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean remove(Object o) {
    return flowers.remove(o);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean removeAll(Collection<?> c) {
    boolean modified = false;
    for (Object o : c) {
      if (remove(o)) {
        modified = true;
      }
    }
    return modified;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean retainAll(Collection<?> c) {
    boolean modified = false;
    for (F flower : this) {
      if (!c.contains(flower)) {
        flowers.remove(flower);
        modified = true;
      }
    }
    return modified;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void clear() {
    flowers.clear();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Iterator<F> iterator() {
    return flowers.iterator();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Object[] toArray() {
    Object[] array = new Object[size()];
    int index = 0;
    for (F flower : this) {
      array[index++] = flower;
    }
    return array;
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  @Override
  public <T> T[] toArray(T[] a) {
    if (a.length < size()) {
      return (T[]) Arrays.copyOf(toArray(), size(), a.getClass());
    }
    int index = 0;
    for (F flower : this) {
      a[index++] = (T) flower;
    }
    if (a.length > size()) {
      a[size()] = null;
    }
    return a;
  }
}
