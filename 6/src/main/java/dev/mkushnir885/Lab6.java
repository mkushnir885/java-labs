package dev.mkushnir885;

import java.util.Arrays;
import java.awt.Color;

import dev.mkushnir885.flowers.*;
import dev.mkushnir885.flowerset.FlowerSet;

/**
 * Entry point for the application. The application demonstrates operations such as adding,
 * removing, and retaining {@link Flower} objects in a {@link FlowerSet}.
 */
public class Lab6 {

  /**
   * The main method serves as the entry point for the application.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    // Creating and manipulating a FlowerSet of roses
    var rose1 = new Rose(10.75, 0.784, 407, true);
    var rose2 = new Rose(12.4, 0.916, 450, false);
    var rose3 = new Rose(15.0, 0.9, 501, true);

    var roses = new FlowerSet<Rose>();
    roses.add(rose1);
    roses.add(rose2);
    roses.add(rose3);
    roses.remove(rose1);
    roses.removeAll(Arrays.asList(rose1, rose2));

    printFlowerSet("Roses:", roses);

    // Creating and manipulating a FlowerSet of tulips
    var tulip1 = new Tulip(5.6, 0.77, 305, 1, Color.YELLOW);
    var tulip2 = new Tulip(6.5, 0.632, 358, 2, Color.RED);
    var tulip3 = new Tulip(7.65, 0.54, 252, 1, Color.PINK);

    var tulips = new FlowerSet<>(tulip1);
    tulips.addAll(Arrays.asList(tulip2, tulip3));

    printObjArray("Tulips before:", tulips.toArray());

    if (tulips.contains(tulip2)) {
      tulips.clear();
    }

    if (tulips.isEmpty()) {
      printFlowerSet("Tulips after:", tulips);
    }

    // Creating and manipulating a FlowerSet of lilies
    var lily1 = new Lily(9.12, 0.812, 383, 8);
    var lily2 = new Lily(11.0, 0.945, 421, 7);
    var lily3 = new Lily(8.55, 0.32, 406, 6);

    var lilies = new FlowerSet<>(Arrays.asList(lily1, lily2, lily3));
    lilies.retainAll(Arrays.asList(lily1, lily3));

    printObjArray("Lilies:", lilies.toArray(Flower[]::new));
  }

  /**
   * Prints the contents of a {@link FlowerSet} with a message.
   *
   * @param message the descriptive message to be printed before the {@code FlowerSet} contents
   * @param flowers the {@code FlowerSet} whose contents are to be printed
   * @param <F>     the type of flowers contained in the {@code FlowerSet}
   */
  private static <F extends Flower> void printFlowerSet(String message, FlowerSet<F> flowers) {
    System.out.println(message);
    for (F flower : flowers) {
      System.out.println(flower);
    }
    System.out.println();
  }

  /**
   * Prints the contents of an array with a message.
   *
   * @param message the descriptive message to be printed before the array contents
   * @param objs    the array of objects to be printed
   */
  private static void printObjArray(String message, Object[] objs) {
    System.out.println(message);
    for (Object obj : objs) {
      System.out.println(obj);
    }
    System.out.println();
  }
}
