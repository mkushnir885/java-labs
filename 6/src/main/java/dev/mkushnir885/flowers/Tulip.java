package dev.mkushnir885.flowers;

import java.awt.Color;

/**
 * Represents a tulip flower.
 */
public class Tulip extends Flower {

  /**
   * The bloom season of this tulip (0: Winter, 1: Spring, 2: Summer, 3: Autumn).
   */
  private final int bloomSeason;

  /**
   * The color of this tulip.
   */
  private final Color color;

  /**
   * Constructs a new {@code Tulip} object with the specified properties.
   *
   * @param price       the initial price of the tulip
   * @param freshness   the freshness level of the tulip as a value between 0 and 1
   * @param length      the length of the tulip in millimeters
   * @param color       the color of the tulip; must not be null
   * @param bloomSeason the bloom season (0: Winter, 1: Spring, 2: Summer, 3: Autumn)
   * @throws NullPointerException     if the color is null
   * @throws IllegalArgumentException if the bloom season is not in the range [0, 3]
   */
  public Tulip(double price, double freshness, int length, int bloomSeason, Color color) {
    super(price, freshness, length);

    if (bloomSeason < 0 || bloomSeason > 3) {
      throw new IllegalArgumentException("bloom season must be a value between 0 and 3");
    }
    if (color == null) {
      throw new NullPointerException("color cannot be null");
    }

    this.bloomSeason = bloomSeason;
    this.color = color;
  }

  /**
   * Retrieves the bloom season of this tulip as a string.
   *
   * @return the bloom season of the tulip (e.g., "Winter", "Spring")
   */
  public String getBloomSeason() {
    String[] seasons = {"Winter", "Spring", "Summer", "Autumn"};
    return seasons[bloomSeason];
  }

  /**
   * Retrieves the color of this tulip.
   *
   * @return the color of the tulip as a string
   */
  public String getColor() {
    return color.toString();
  }

  /**
   * Returns a string representation of this tulip, including common flower properties, its color,
   * and bloom season.
   *
   * @return a formatted string describing the tulip
   */
  @Override
  public String toString() {
    return String.format("Tulip\t{ %s, bloom season: %s, color: %s }",
        super.toString(),
        getBloomSeason(),
        getColor());
  }
}
