package edu.cnm.deepdive;

public class Search {

  /**
   * Searches a sorted stack. If the value is not found returns the position the value should be
   * inserted, represented as the negative value of the position - 1 (differentiating index 0, found
   * vs not found). To invert do i = ~i + 1.
   *
   * @param needle the value to look for
   * @param haystack the set of values to search
   * @return position where value was found, or the position it should go as -index - 1
   */
  public static int binarySearch(int needle, int[] haystack) {
    return binarySearch(needle, haystack, 0, haystack.length);
  }

  /**
   * Searches a sorted stack. If the value is not found returns the position the value should be
   * inserted, represented as the negative value of the position - 1 (differentiating index 0, found
   * vs not found). To invert do i = ~i + 1.
   *
   * @param needle the value to look for
   * @param haystack the set of values to search
   * @param beginIndex starting search position
   * @param endIndex ending search position
   * @return position where value was found, or the position it should go as -index - 1
   */
  public static int binarySearch(int needle, int haystack[], int beginIndex, int endIndex) {
    int position;
    if (endIndex <= beginIndex) {
      position = ~beginIndex; // flip all the bits to get negative value and subtracting 1
    } else {
      int midpoint = (beginIndex + endIndex) / 2;
      int midpointValue = haystack[midpoint];
      if (midpointValue == needle) {
        position = midpoint;
      } else if (needle < midpointValue) {
        position = binarySearch(needle, haystack, beginIndex, midpoint);
      } else { // (needle > midpointValue)
        position = binarySearch(needle, haystack, midpoint + 1, endIndex);
      }
    }
    return position;
  }

}
