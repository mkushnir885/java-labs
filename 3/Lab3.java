import java.util.Arrays;
import java.util.Comparator;

/**
 * Demonstrates sorting and searching functionality for an array of Plane objects.
 */
public class Lab3 {

  /**
   * The entry point of the Lab3 application. Creates an array of predefined planes, sorts it, and
   * searches for a specific plane.
   *
   * @param args command-line arguments (not used)
   */
  public static void main(String[] args) {
    Plane[] planes = new Plane[]{
        new Plane("747-8", "Boeing", 988.0f, 1969, false),
        new Plane("A380", "Airbus", 1020.0f, 2005, false),
        new Plane("F-22 Raptor", "Lockheed Martin", 2410.0f, 1997, true),
        new Plane("Su-57", "Sukhoi", 2600.0f, 2010, true),
        new Plane("B-2 Spirit", "Northrop Grumman", 1010.0f, 1989, false),
        new Plane("Dassault Falcon 7X", "Dassault Aviation", 953.4f, 2005, true),
        new Plane("Gulfstream G650", "Gulfstream Aerospace", 982.8f, 2008, true),
        new Plane("Cessna Citation X+", "Cessna", 978.3f, 1996, true),
        new Plane("F/A-18 Hornet", "McDonnell Douglas/Boeing", 1915.4f, 1978, true),
        new Plane("Eurofighter Typhoon", "Airbus, BAE Systems, Leonardo", 2495.6f, 1994, true),
        new Plane("MiG-29", "Mikoyan", 2400.0f, 1977, true),
        new Plane("SR-71 Blackbird", "Lockheed Martin", 3540.0f, 1964, false),
        new Plane("B-1B Lancer", "Rockwell", 1334.0f, 1974, false),
        new Plane("Concorde", "Aérospatiale/BAC", 2179.0f, 1969, false),
        new Plane("Embraer E190-E2", "Embraer", 870.0f, 2016, true),
    };

    sortPlanes(planes);
    System.out.println("1. Sorted planes array:");
    for (Plane plane : planes) {
      System.out.println(plane);
    }

    Plane plane = new Plane("Concorde", "Aérospatiale/BAC", 2179.0f, 1969, false);
    int index = findIdenticalPlane(planes, plane);

    if (index != -1) {
      System.out.println("2. Found plane:");
      System.out.println(planes[index]);
    } else {
      System.err.println("Execution failed. No identical plane found.");
      System.exit(1);
    }
  }

  /**
   * Sorts an array of Plane objects by production status (not in production first) and then by
   * maximum speed in descending order.
   *
   * @param planes an array of Plane objects to be sorted
   */
  public static void sortPlanes(Plane[] planes) {
    Arrays.sort(planes, Comparator
        .comparing((Plane p) -> p.inProduction)
        .thenComparing((Plane p) -> p.maxSpeed, Comparator.reverseOrder()));
  }

  /**
   * Searches for a plane in an array of planes that is identical to the specified plane.
   *
   * @param planes an array of Plane objects to search
   * @param plane  the Plane object to find
   * @return the index of the identical plane if found, or {@code -1} if no identical plane is found
   * @see Plane#equals(Object)
   */
  public static int findIdenticalPlane(Plane[] planes, Plane plane) {
    for (int i = 0; i < planes.length; i++) {
      if (plane.equals(planes[i])) {
        return i;
      }
    }
    return -1;
  }
}
