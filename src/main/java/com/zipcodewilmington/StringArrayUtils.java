package com.zipcodewilmington;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {

        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {

        return array[array.length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {

        return array[array.length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for (String element : array) {
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {

        String[] reverse = new String[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            reverse[array.length - i - 1] = array[i];
        }
        return reverse;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        for (int i = 0; i <= array.length /2 && array.length != 0; i++) {
            if (array[i] != array[array.length - i - 1]) {
                break;
            }
            return true;
        }

        return false;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        String words = Arrays.toString(array).toLowerCase();
            int notPresent = 0;
            for (char i = 'a'; i <= 'z'; i++) {
                if (words.indexOf(i) == -1){
                    notPresent++;
                }
            }

        return notPresent == 0;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int found = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                found++;
            }
        }
        return found;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        int n = array.length - getNumberOfOccurrences(array, valueToRemove);
        String[] newArr = new String[n];

        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(valueToRemove)) {
                continue;
            }
            newArr[j++] = array[i];
        }

        return newArr;

        /*
        *String[] newArray = new String[array.length-1];
        int j = 0;
        *for(int i = 0; i < array.length; i++) {
            if(array[i].equals(valueToRemove)) {
                continue;
            }
            newArray[j] = array[i];
        * */
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {

        int counter = 0;
        int arrayLength = array.length;
        int iterator = 0;
        for (int i = array.length-1; i > 0; i--) {
            if (array[i] != null && array[i].equals(array[i-1])) {
                array[i] = null;
                counter++;
            }
        }
        String[] duplicatesRemoved = new String[arrayLength-counter];
        for (int i = 0; i < array.length ; i++) {
            if(array[i] != null) {
                duplicatesRemoved[iterator] = array[i];
                iterator++;
            }
        }
        return duplicatesRemoved;


        ///////////////////////////////////////////////

        /*String store = array[0];
        ArrayList<String> newArr = new ArrayList<>();
        newArr.add(array[0]);

        for (int i = 1; i < array.length; i++) {
            if (store.equals(array[i])) {
                continue;
            } else {
                newArr.add(array[i]);
                store = array[i];
            }
        }

        return newArr.toArray(new String[0]);*/

        /*
        *
        * */
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {

        int counter = 0;
        int arrayLength = array.length;
        int iterator = 0;

        for (int i = array.length-1; i > 0; i--) {
            if (array[i] != null && array[i].charAt(0) == array[i-1].charAt(0)) {
                array[i-1] += array[i];
                array[i] = null;
                counter++;
            }
        }
        String[] packConsecutive = new String[arrayLength-counter];
        for (int i = 0; i < array.length ; i++) {
            if(array[i] != null) {
                packConsecutive[iterator] = array[i];
                iterator++;
            }
        }
        return packConsecutive;

        /*String store = array[0];
        ArrayList<String> newArr = new ArrayList<>();
        newArr.add(array[0]);
        int j = 0;

        for (int i = 1; i < array.length; i++) {

            if (store.equals(array[i])) {
                //if the next is duplicate, skip
                newArr.set(j, newArr.get(j) + store);
            } else {
                newArr.add(array[i]);//adding an element to your new array
                store = array[i];
                j++;

            }
        }

        return newArr.toArray(new String[0]);*/
    }


}
