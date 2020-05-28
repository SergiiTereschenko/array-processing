package com.globallogic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ArrayProcessingTest {

    private ArrayProcessing unit = new ArrayProcessing();

    static Stream<Arguments> arraysMethodSource() {
        return Stream.of(
                arguments(new int[0], new int[]{1, 2, 3}),
                arguments(new int[]{1, 2, 3}, new int[0])
        );
    }

    @Test
    void uniqueElementsArray() {
        int[] actual = unit.uniqueElements(new int[]{1, 2, 4, 2, 5});
        assertThat(actual).containsExactlyInAnyOrder(1, 2, 4, 5);
    }

    @Test
    void uniqueElementsArrayWithAlreadyUniqueElements() {
        int[] actual = unit.uniqueElements(new int[]{1, 2, 3, 4});
        assertThat(actual).containsExactlyInAnyOrder(1, 2, 3, 4);
    }

    @Test
    void uniqueElementsArrayWithEmptyArray() {
        int[] actual = unit.uniqueElements(new int[0]);
        assertArrayEquals(new int[0], actual);
    }

    @Test
    void uniqueElementsArrayWithSeveralUniqueElements() {
        int[] actual = unit.uniqueElements(new int[]{1, 1, 2, 3, 2, 4, 2, 5});
        assertThat(actual).containsExactlyInAnyOrder(1, 2, 3, 4, 5);
    }

    @Test
    void uniqueElementsArrayWithOnlyOneValue() {
        int[] actual = unit.uniqueElements(new int[]{1, 1, 1, 1, 1});
        assertThat(actual).hasSize(1).contains(1);
    }

    @Test
    void uniqueElementsMergeArray() {
        int[] actual = unit.uniqueElementsMergeArray(new int[]{1, 2, 4, 5}, new int[]{1, 3, 7, 5});
        assertThat(actual).containsExactlyInAnyOrder(2, 3, 4, 7);
    }

    @Test
    void uniqueElementsMergeArrayTwoUniqueArrays() {
        int[] actual = unit.uniqueElementsMergeArray(new int[]{1, 2, 3}, new int[]{4, 5, 6});
        assertThat(actual).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest
    @MethodSource("arraysMethodSource")
    void uniqueElementsMergeArrayOneArrayIsEmpty(int[] arr1, int[] arr2) {
        int[] actual = unit.uniqueElementsMergeArray(arr1, arr2);
        assertThat(actual).containsExactlyInAnyOrder(1, 2, 3);
    }

    @Test
    void uniqueElementsMergeArrayAllArraysIsEmpty() {
        int[] actual = unit.uniqueElementsMergeArray(new int[0], new int[0]);
        assertArrayEquals(new int[0], actual);
    }

    @Test
    void commonElements() {
        int[] actual = unit.commonElements(new int[]{1, 2, 3}, new int[]{2, 3, 4});
        assertThat(actual).containsExactlyInAnyOrder(2, 3);
    }

    @Test
    void commonElementsTheSameArrays() {
        int[] actual = unit.commonElements(new int[]{1, 2, 3}, new int[]{1, 2, 3});
        assertThat(actual).containsExactlyInAnyOrder(1, 2, 3);
    }

    @Test
    void commonElementsNoCommonElements() {
        int[] actual = unit.commonElements(new int[]{1, 2, 3}, new int[]{4, 5, 6});
        assertThat(actual).isEmpty();
    }

    @ParameterizedTest
    @MethodSource("arraysMethodSource")
    void commonElementsOneOfArraysIsEmpty(int[] arr1, int[] arr2) {
        int[] actual = unit.commonElements(arr1, arr2);
        assertThat(actual).isEmpty();
    }

    @Test
    void commonElementsAllArraysAreEmpty() {
        int[] actual = unit.commonElements(new int[0], new int[0]);
        assertThat(actual).isEmpty();
    }

    @Test
    void reverseArrayOddElementNumber() {
        int[] actual = unit.reverseArray(new int[]{1, 2, 3, 4, 5});
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, actual);
    }

    @Test
    void reverseArrayEvenElementNumber() {
        int[] actual = unit.reverseArray(new int[]{1, 2, 3, 4});
        assertArrayEquals(new int[]{4, 3, 2, 1}, actual);
    }

    @Test
    void reverseArrayEmptyArray() {
        int[] actual = unit.reverseArray(new int[0]);
        assertThat(actual).isEmpty();
    }

    @Test
    void sortEvenPositionArrayWithEvenElementNumber() {
        int[] actual = unit.sortEvenPositionArray(new int[]{7, 2, 3, 1, 8, 11, 2, 0, 15, 4});
        assertArrayEquals(new int[]{2, 2, 3, 1, 7, 11, 8, 0, 15, 4}, actual);
    }

    @Test
    void sortEvenPositionArrayWithOddElementNumber() {
        int[] actual = unit.sortEvenPositionArray(new int[]{7, 2, 3, 1, 8, 11, 2, 0, 15});
        assertArrayEquals(new int[]{2, 2, 3, 1, 7, 11, 8, 0, 15}, actual);
    }

    @Test
    void sortEvenPositionArrayEmptyArray() {
        int[] actual = unit.sortEvenPositionArray(new int[0]);
        assertThat(actual).isEmpty();
    }

    @Test
    void sortEvenPositionArrayOneElement() {
        int[] actual = unit.sortEvenPositionArray(new int[]{7});
        assertArrayEquals(new int[]{7}, actual);
    }

    @Test
    void sortEvenPositionArrayTwoElements() {
        int[] actual = unit.sortEvenPositionArray(new int[]{7, 2});
        assertArrayEquals(new int[]{7, 2}, actual);
    }

    @Test
    void sortEvenPositionArrayTreeElements() {
        int[] actual = unit.sortEvenPositionArray(new int[]{7, 2, 1});
        assertArrayEquals(new int[]{1, 2, 7}, actual);
    }
}