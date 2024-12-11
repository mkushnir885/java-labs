package dev.mkushnir885.flowers;

/**
 * Represents a rose flower.
 */
public class Rose extends Flower {

  /**
   * Indicates whether this rose has thorns.
   */
  private final boolean hasThorns;

  /**
   * Constructs a new {@code Rose} object with the specified properties.
   *
   * @param price     the initial price of the rose
   * @param freshness the freshness level of the rose as a value between 0 and 1
   * @param length    the length of the rose in millimeters
   * @param hasThorns {@code true} if the rose has thorns; {@code false} otherwise
   */
  public Rose(double price, double freshness, int length, boolean hasThorns) {
    super(price, freshness, length);
    this.hasThorns = hasThorns;
  }

  /**
   * Indicates whether this rose has thorns.
   *
   * @return {@code true} if the rose has thorns; {@code false} otherwise
   */
  public boolean hasThorns() {
    return hasThorns;
  }

  /**
   * Returns a string representation of this rose, including common flower properties and its thorns
   * status.
   *
   * @return a formatted string describing the rose
   */
  @Override
  public String toString() {
    return String.format("Rose\t{ %s, thorns: %s }",
        super.toString(),
        (hasThorns ? "yes" : "no"));
  }
}
