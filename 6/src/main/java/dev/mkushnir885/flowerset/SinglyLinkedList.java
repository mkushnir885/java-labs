package dev.mkushnir885.flowerset;

import java.util.Objects;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A simple implementation of a singly linked list that stores elements of a generic type.
 *
 * @param <T> the type of elements stored in this singly linked list
 */
class SinglyLinkedList<T> {

  /**
   * The head (first node) of this singly linked list.
   */
  private Node<T> head;

  /**
   * The tail (last node) of this singly linked list. Used to optimize adding new elements.
   */
  private Node<T> tail;

  /**
   * The number of elements in this singly linked list.
   */
  private int size;

  /**
   * Constructs an empty singly linked list.
   */
  public SinglyLinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  /**
   * Returns the number of elements in this list.
   *
   * @return the size of the list
   */
  public int size() {
    return size;
  }

  /**
   * Checks if the list contains the specified element.
   *
   * @param o the element to search for
   * @return {@code true} if the list contains the element; otherwise {@code false}
   */
  public boolean contains(Object o) {
    var current = head;
    while (current != null) {
      if (Objects.equals(current.value, o)) {
        return true;
      }
      current = current.next;
    }
    return false;
  }

  /**
   * Adds a new element to the end of the list.
   *
   * @param value the element to be added
   */
  public void add(T value) {
    var node = new Node<>(value);
    if (tail == null) {
      head = node;
    } else {
      tail.next = node;
    }
    tail = node;
    size++;
  }

  /**
   * Removes the first occurrence of the specified element from the list, if it is present.
   *
   * @param o the element to be removed
   * @return {@code true} if the element was removed; otherwise {@code false}
   */
  public boolean remove(Object o) {
    if (head == null) {
      return false;
    }

    if (Objects.equals(head.value, o)) {
      head = head.next;
      if (head == null) {
        tail = null;
      }
      size--;
      return true;
    }

    var current = head;
    while (current.next != null) {
      if (Objects.equals(current.next.value, o)) {
        current.next = current.next.next;
        if (current.next == null) {
          tail = current;
        }
        size--;
        return true;
      }
      current = current.next;
    }
    return false;
  }

  /**
   * Removes all elements from the list, leaving it empty.
   */
  public void clear() {
    head = null;
    tail = null;
    size = 0;
  }

  /**
   * Returns an iterator over the elements in this list.
   *
   * @return an {@link Iterator} over the elements in this list
   */
  public Iterator<T> iterator() {
    return new Iterator<>() {
      private Node<T> current = head;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public T next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        T value = current.value;
        current = current.next;
        return value;
      }
    };
  }

  /**
   * A private static nested class representing a node in the singly linked list.
   *
   * @param <T> the type of value stored in the node
   */
  private static class Node<T> {

    /**
     * The value stored in the node.
     */
    T value;

    /**
     * The reference to the next node in the list.
     */
    Node<T> next;

    /**
     * Constructs a new node with the specified value.
     *
     * @param value the value to be stored in the node
     */
    Node(T value) {
      this.value = value;
      this.next = null;
    }
  }
}
