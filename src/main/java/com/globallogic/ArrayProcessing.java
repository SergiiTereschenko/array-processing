package com.globallogic;

import java.util.Arrays;

public class ArrayProcessing {

    /**
     * Implement the method that returns array of unique elements of input array (filter duplicate elements)
     * <p>
     * Examples:
     * input array - [1, 2, 5, 2, 4]
     * output array - [1, 2, 5, 4]
     * <p>
     * input array - [2, 3, 2, 3]
     * output array - [2, 3]
     *
     * @param arr - array with elements
     * @return - array with elements that don't have duplicates
     */
    public int[] uniqueElements(int[] arr) {
        int[] resultArr = new int[arr.length];
        int uniqueElementsCounter = 0;
        for (int i : arr) {
            boolean isElementUnique = true;
            for (int j = 0; j < uniqueElementsCounter; j++) {
                if (i == resultArr[j]) {
                    isElementUnique = false;
                    break;
                }
            }
            if (isElementUnique) {
                resultArr[uniqueElementsCounter] = i;
                uniqueElementsCounter++;
            }
        }
        return Arrays.copyOf(resultArr, uniqueElementsCounter);
    }


    /**
     * Implement the method that merges two arrays into one. Resulting array should consist of elements that present only in the one array and absent in other
     * <p>
     * Example:
     * arr1 - [1, 2, 4, 5],  arr2 - [1, 3, 7, 5]
     * output array - [2, 3, 4, 7]
     *
     * @param arr1 - first input array with unique elements
     * @param arr2 - second input array with unique elements
     * @return array with not common elements from input arrays
     */
    public int[] uniqueElementsMergeArray(int[] arr1, int[] arr2) {
        int uniqueElementCounter = 0;
        int[] resultArr = new int[arr1.length + arr2.length];
        uniqueElementCounter = getUniqueElements(arr2, arr1, uniqueElementCounter, resultArr);
        uniqueElementCounter = getUniqueElements(arr1, arr2, uniqueElementCounter, resultArr);
        return Arrays.copyOf(resultArr, uniqueElementCounter);
    }

    private int getUniqueElements(int[] arr1, int[] arr2, int uniqueElementCounter, int[] resultArr) {
        for (int arr1Element : arr2) {
            boolean isElementUnique = true;
            for (int arr2Element : arr1) {
                if (arr1Element == arr2Element) {
                    isElementUnique = false;
                    break;
                }
            }
            if (isElementUnique) {
                resultArr[uniqueElementCounter] = arr1Element;
                uniqueElementCounter++;
            }
        }
        return uniqueElementCounter;
    }

    /**
     * Implement the method that merges two arrays into one. The resulting array should consist of elements that present in both arrays
     * <p>
     * Example:
     * arr1 - [1, 2, 3] arr2 - [2, 3, 4]
     * output array - [2, 3]
     *
     * @param arr1 - first input array with unique elements
     * @param arr2 - second input array with unique elements
     * @return array with common elements from first and second arrays
     */
    public int[] commonElements(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int commonElementsNumber = 0;
        for (int arr1Element : arr1) {
            for (int arr2Element : arr2) {
                if (arr1Element == arr2Element) {
                    result[commonElementsNumber] = arr1Element;
                    commonElementsNumber++;
                }
            }
        }
        return Arrays.copyOf(result, commonElementsNumber);
    }

    /**
     * Implement the method that reverses input array in the opposite order
     * <p>
     * Example:
     * input array - [1, 2, 3, 4]
     * output array - [4, 3, 2, 1]
     *
     * @param arr - input array
     * @return array with opposite ordering of elements
     */
    public int[] reverseArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = tmp;
        }
        return arr;
    }

    /**
     * Implement the method that sorts elements of an array that place on even positions  (indexes: 0, 2, 4 ...)
     * <p>
     * Example:
     * input array - [3, 7, 1, 4, 2]
     * output array - [1, 7, 2, 4, 3]
     *
     * @param arr - input array
     * @return - sorted array of elements on even positions
     */
    public int[] sortEvenPositionArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i = i + 2) {
            for (int j = 0; j < arr.length - i - 2; j = j + 2) {
                if (arr[j] > arr[j + 2]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = tmp;
                }
            }
        }
        return arr;
    }
}
