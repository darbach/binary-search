package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SearchTest {

  @ParameterizedTest(name = "[{index}] Searching {0} in {1}. Index range [{2}, {3}).")
  @MethodSource({"needlePresent", "needleNotPresent"})
  void binarySearch(int needle, int[] haystack, int expectedBegin, int expectedEnd) {
    int actual = Search.binarySearch(needle, haystack);
    assertTrue(actual >= expectedBegin && actual < expectedEnd);
  }

  static Stream<Arguments> needlePresent() {
    //return type must be 2d array, list<arguments>, stream<arguments> etc
    //doesn't care about duplicated values
    return Stream.of(
        Arguments.of(1, new int[]{0, 1, 2}, 1, 2),
        Arguments.of(3, new int[]{1, 1, 2, 3, 3, 3, 4, 5}, 3, 6),
        Arguments.of(1, new int[]{1, 1, 2, 3, 3, 3, 4, 5}, 0, 2),
        Arguments.of(5, new int[]{1, 1, 2, 3, 3, 3, 4, 5}, 7, 8)
    );
  }

  static Stream<Arguments> needleNotPresent() {
    //return type must be 2d array, list<arguments>, stream<arguments> etc
    //doesn't care about duplicated values
    return Stream.of(
        Arguments.of(-1, new int[]{0, 1, 2}, -1, 0),
        Arguments.of(4, new int[]{1, 1, 2, 3, 3, 3, 5}, -7, -6),
        Arguments.of(2, new int[]{1, 1, 3, 3, 3, 4, 5}, -3, -2),
        Arguments.of(-1, new int[]{1, 1, 2, 3, 3, 3, 4, 5}, -1, 0),
        Arguments.of(10, new int[]{1, 1, 2, 3, 3, 3, 4, 5}, -9, -8)
    );
  }


}