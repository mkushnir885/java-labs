package dev.mkushnir885.bouquet;

import java.util.Arrays;
import java.util.Comparator;

import dev.mkushnir885.flowers.Flower;

/**
 * Represents a bouquet of flowers with an optional cost of accessories.
 */
public class Bouquet {

  /**
   * An array of {@link Flower} objects that make up the bouquet.
   */
  private final Flower[] flowers;

  /**
   * The cost of accessories included with the bouquet.
   */
  private final double accessoriesCost;

  /**
   * Constructs a new {@code Bouquet} with the specified flowers and accessories cost.
   *
   * @param flowers         an array of {@link Flower} objects that make up the bouquet
   * @param accessoriesCost the cost of accessories included with the bouquet
   * @throws IllegalArgumentException if the flowers array is {@code null} or the accessories cost
   *                                  is negative
   */
  public Bouquet(Flower[] flowers, double accessoriesCost) {
    if (flowers == null) {
      throw new IllegalArgumentException("flowers array cannot be null");
    }
    if (accessoriesCost < 0) {
      throw new IllegalArgumentException("cost of the accessories cannot be negative");
    }

    this.flowers = flowers;
    this.accessoriesCost = accessoriesCost;
  }

  /**
   * Calculates the total cost of the bouquet, including the cost of accessories and the price of
   * each flower in the bouquet.
   *
   * @return the total cost of the bouquet
   */
  public double getCost() {
    double cost = accessoriesCost;
    for (var flower : flowers) {
      cost += flower.getPrice();
    }
    return cost;
  }

  /**
   * Sorts the flowers in the bouquet by their freshness level in ascending order. Freshness is
   * represented as a percentage where 100% is the freshest.
   */
  public void sortFlowersByFreshnessLevel() {
    Arrays.sort(flowers, Comparator.comparingDouble(Flower::getFreshnessLevel));
  }

  /**
   * Finds the index of the first flower in the bouquet whose length falls within the specified
   * range (inclusive).
   *
   * @param min the minimum length of the flower in the range (inclusive)
   * @param max the maximum length of the flower in the range (inclusive)
   * @return the index of the flower that matches the specified range, or {@code -1} if no such
   * flower exists
   * @throws IllegalArgumentException if {@code min} is negative or {@code min} is greater than
   *                                  {@code max}
   */
  public int indexOfFlowerByLength(float min, float max) {
    if (min < 0 || min > max) {
      throw new IllegalArgumentException("invalid flower length range");
    }

    for (int i = 0; i < flowers.length; i++) {
      float length = flowers[i].getLength();
      if (length >= min && length <= max) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Returns a string representation of the bouquet, including the total cost, accessories cost, and
   * details of all the flowers in the bouquet.
   *
   * @return a formatted string representation of the bouquet
   */
  @Override
  public String toString() {
    var sb = new StringBuilder(
        String.format("Bouquet{\n\ttotal cost: %6.2f$ (accessories cost: %6.2f$)\n\tflowers: [\n",
            getCost(),
            accessoriesCost));
    for (var flower : flowers) {
      sb.append("\t\t").append(flower).append("\n");
    }
    return sb.append("\t]\n}").toString();
  }
}
