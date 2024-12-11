package dev.mkushnir885.flowers;

/**
 * Represents a lily flower.
 */
public class Lily extends Flower {

  /**
   * The number of petals on this lily.
   */
  private final int petalCount;

  /**
   * Constructs a new {@code Lily} object with the specified properties.
   *
   * @param price      the initial price of the lily
   * @param freshness  the freshness level of the lily as a value between 0 and 1
   * @param length     the length of the lily in millimeters
   * @param petalCount the number of petals on the lily
   * @throws IllegalArgumentException if the petal count is negative
   */
  public Lily(double price, double freshness, int length, int petalCount) {
    super(price, freshness, length);

    if (petalCount < 0) {
      throw new IllegalArgumentException("petal count cannot be negative");
    }

    this.petalCount = petalCount;
  }

  /**
   * Retrieves the number of petals on this lily.
   *
   * @return the number of petals on the lily
   */
  public int getPetalCount() {
    return petalCount;
  }

  /**
   * Returns a string representation of this lily, including common flower properties and petal
   * count.
   *
   * @return a formatted string describing the lily
   */
  @Override
  public String toString() {
    return String.format("Lily\t{ %s, petals: %d }", super.toString(), petalCount);
  }
}
