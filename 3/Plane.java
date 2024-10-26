/**
 * Represents a plane model with specifications such as model name, manufacturer, maximum speed,
 * first flight year, and production status.
 */
public class Plane {

  /**
   * The model name of the plane (for example, "747-8", "A380").
   */
  public final String model;

  /**
   * The manufacturer of the plane (for example, "Boeing", "Airbus").
   */
  public final String manufacturer;

  /**
   * The maximum speed of the plane in km/h.
   */
  public final float maxSpeed;

  /**
   * The year when the plane had its first flight.
   */
  public final int firstFlightYear;

  /**
   * Indicates whether the plane is still in production.
   */
  public final boolean inProduction;

  /**
   * Constructs a Plane instance with the specified details.
   *
   * @param model           the model name of the plane
   * @param manufacturer    the manufacturer of the plane
   * @param maxSpeed        the maximum speed of the plane
   * @param firstFlightYear the year of the plane's first flight
   * @param inProduction    whether the plane is still in production
   */
  public Plane(String model, String manufacturer, float maxSpeed, int firstFlightYear,
      boolean inProduction) {
    this.model = model;
    this.manufacturer = manufacturer;
    this.maxSpeed = maxSpeed;
    this.firstFlightYear = firstFlightYear;
    this.inProduction = inProduction;
  }

  /**
   * Compares this plane to the specified object for equality.
   * <p>
   * Two Plane objects are considered equal if they have the same values for all their fields.
   *
   * @param obj the object to compare
   * @return {@code true} if the specified object is a Plane with the same details as this plane,
   * otherwise {@code false}
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Plane other)) {
      return false;
    }

    return model.equals(other.model) &&
        manufacturer.equals(other.manufacturer) &&
        (maxSpeed == other.maxSpeed) &&
        (firstFlightYear == other.firstFlightYear) &&
        (inProduction == other.inProduction);
  }

  /**
   * Returns a string representation of this Plane instance.
   *
   * @return a formatted string containing the plane's model, manufacturer, maximum speed, first
   * flight year, and production status
   */
  @Override
  public String toString() {
    String model = "'" + this.model + "'";
    String manufacturer = "'" + this.manufacturer + "'";
    String inProduction = this.inProduction ? "✓" : "✗";

    return String.format("Plane{ %-24s %-32s %8.2f   %4d   %s }",
        model, manufacturer, maxSpeed, firstFlightYear, inProduction
    );
  }
}
