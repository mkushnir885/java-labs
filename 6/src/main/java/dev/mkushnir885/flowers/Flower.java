package dev.mkushnir885.flowers;

/**
 * Represents a general abstraction for a flower. This class defines the basic properties and
 * behaviors common to all flowers.
 */
public abstract class Flower {

  /**
   * The initial price of this flower.
   */
  private final double initialPrice;

  /**
   * The freshness level of this flower, expressed as a value between 0 (least fresh) and 1 (most
   * fresh).
   */
  private final double freshness;

  /**
   * The length of this flower in millimeters.
   */
  private final int length;

  /**
   * Constructs a new {@code Flower} object with the specified initial price, freshness, and
   * length.
   *
   * @param initialPrice the initial price of the flower
   * @param freshness    the freshness of the flower as a value between 0 and 1
   * @param length       the length of the flower in millimeters
   * @throws IllegalArgumentException if the initial price is negative, the freshness is not within
   *                                  the range [0, 1], or the length is negative
   */
  protected Flower(double initialPrice, double freshness, int length) {
    if (initialPrice < 0) {
      throw new IllegalArgumentException("price cannot be negative");
    }
    if (freshness < 0 || freshness > 1) {
      throw new IllegalArgumentException("freshness must be between 0 and 1");
    }
    if (length < 0) {
      throw new IllegalArgumentException("length cannot be negative");
    }

    this.initialPrice = initialPrice;
    this.freshness = freshness;
    this.length = length;
  }

  /**
   * Calculates the price of this flower based on its initial price and freshness level.
   *
   * @return the calculated price of the flower
   */
  public double getPrice() {
    return initialPrice * freshness;
  }

  /**
   * Retrieves the freshness level of this flower as a percentage.
   *
   * @return the freshness level as a percentage (0-100%)
   */
  public double getFreshnessLevel() {
    return freshness * 100;
  }

  /**
   * Retrieves the length of this flower in centimeters.
   *
   * @return the flower length in centimeters
   */
  public float getLength() {
    return (float) length / 10;
  }

  /**
   * Returns a string representation of this flower, including its price, freshness, and length.
   *
   * @return a formatted string describing the flower
   */
  @Override
  public String toString() {
    return String.format("price: %6.2f$, freshness level: %5.1f%%, length: %6.2fcm",
        getPrice(),
        getFreshnessLevel(),
        getLength());
  }
}
