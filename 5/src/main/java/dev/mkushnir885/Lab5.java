package dev.mkushnir885;

import java.awt.Color;

import dev.mkushnir885.flowers.*;
import dev.mkushnir885.bouquet.Bouquet;

/**
 * Entry point for the application, demonstrating the creation and manipulation of a bouquet of
 * flowers.
 */
public class Lab5 {

  /**
   * The main method of the application.
   *
   * <p>
   * This method demonstrates:
   * <ul>
   *   <li>Creating an array of {@link Flower} objects, including {@link Rose}, {@link Tulip}, and
   *       {@link Lily} instances.</li>
   *   <li>Building a {@link Bouquet} using the flower array and calculating the bouquet's total
   *       cost, including accessories.</li>
   *   <li>Sorting the flowers in the bouquet by their freshness level in ascending order.</li>
   *   <li>Searching for a flower in the bouquet that matches a given length range.</li>
   * </ul>
   * <p>
   * If an error occurs during execution, the exception is caught, and an error message is printed
   * to the standard error stream.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    try {
      Flower[] flowers = {
          new Lily(9.12, 0.812, 383, 8),
          new Tulip(5.6, 0.77, 305, 1, Color.YELLOW),
          new Rose(10.75, 0.784, 407, true),
          new Lily(11.0, 0.945, 421, 7),
          new Rose(12.4, 0.916, 450, false),
          new Tulip(6.5, 0.632, 358, 2, Color.RED),
          new Tulip(7.65, 0.54, 252, 1, Color.PINK),
          new Lily(8.55, 0.32, 406, 6),
          new Rose(15.0, 0.9, 501, true),
      };

      var bouquet = new Bouquet(flowers, 15.99);

      bouquet.sortFlowersByFreshnessLevel();
      System.out.println("Bouquet with flowers sorted by freshness level:\n" + bouquet);

      int index = bouquet.indexOfFlowerByLength(30, 35);
      if (index != -1) {
        System.out.println("Founded flower: " + flowers[index]);
      } else {
        System.out.println("There is no flower with specified length range in the bouquet");
      }
    } catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
      System.exit(1);
    }
  }
}
