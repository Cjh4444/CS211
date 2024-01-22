package Week03.Assignment;

import java.util.*;
/**
* BC CS211
* Selected Chapter 11 Exercises
*
* W.P. Iverson, January 2024
*/
public class Exercises11 {
    public static void main(String[] a) {
        // Build Integer array
        Integer[] arrayI = {7,4,-9,4,15,8,27,7,11,-5,32,-9,-9};
        Integer[] arrayI2 = {6,3,31,4,15,8,27,7,11,-5,32,-9,-9};
        ArrayList<Integer> testListI = new ArrayList<Integer>();

        // Build an array of Strings
        String[] arrayS =
        {"Jane","Logan","Whitaker","Alyssa","Stefanie","Jeff","Kim","Sylvia","Marco"};
        ArrayList<String> testListS = new ArrayList<String>();

        // Build the Set of Strings:
        for (String s: arrayS) testListS.add(s);

        Set<String> testSetS = new TreeSet<String>(testListS);
        // Build the Set of Integers:
        Set<Integer> testSetI = new TreeSet<Integer>();
        Set<Integer> testSetI2 = new TreeSet<Integer>();
        for (int i: arrayI) testSetI.add(i);
        for (int i: arrayI2) testSetI2.add(i);

        // Build a Map of Strings:
        Map<String, String> testMapSS = new HashMap<String, String>();
        Map<String, Integer> testMapSI = new HashMap<String, Integer>();
        String[] array2 =
        {"Jane2","Logan2","Whitaker2","Alyssa2","Stefanie2","Jeff2","Kim2","Sylvia2","Sylvia2"};
        for (int i=0; i<arrayS.length; i++) testMapSS.put(arrayS[i], array2[i]);
        for (int i=0; i<arrayS.length; i++) testMapSI.put(arrayS[i], i);

        // Exercise 11.8
        // System.out.println(testSetS);
        // System.out.println("maxLength="+maxLength(testSetS));    

        // Exercise 11.11 (text pg 759)
        // System.out.println(testSetI);
        // System.out.println(testSetI2);
        // System.out.println("symmetricSetDifference="+symmetricSetDifference(testSetI2, testSetI));

        // Exercise 11.12
        // System.out.println(testListS);
        //System.out.println("contains3="+contains3(testListS));

        // Exercise 11.13
        // System.out.println(testMapSS);
        // System.out.println("isUnique="+isUnique(testMapSS));

        // Exercise 11.14
        // System.out.println(testMapSI);
        // System.out.println("intersect="+intersect(testMapSI,testMapSI));
        
        // Exercise 11.15
        // System.out.println(testListI);
        //System.out.println("maxOccurrences="+maxOccurrences(testListI));
    }

    public static int maxLength( Set<String> set ) {
        if (set.isEmpty()) return 0;

        Iterator<String> iterator = set.iterator();

        int maxLength = iterator.next().length();
        int currentLength;
        while (iterator.hasNext()) {
            currentLength = iterator.next().length();
            if (currentLength > maxLength) maxLength = currentLength;
        }
        return maxLength;
    }

    public static Set<Integer> symmetricSetDifference( Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> tempSet = new HashSet<>(set1);
        tempSet.addAll(set2);

        Set<Integer> returnSet = new HashSet<>(tempSet);

        tempSet.retainAll( set1.size() < set2.size() ? set1 : set2);
        returnSet.removeAll(tempSet);

        return returnSet;
    }

    public static boolean contains3( List<String> list ) {
        if (list.size() < 3) return false;

        Iterator<String> iterator = list.iterator();

        HashMap<String, Integer> map = new HashMap<>();

        String currentWord;
        int count;
        while (iterator.hasNext()) {
            currentWord = iterator.next();
            count = map.containsKey(currentWord) ? map.get(currentWord) : 0;
            map.put(currentWord, count + 1);

            if (map.get(currentWord) == 3) return true;
        }
        return false;
    }

    public static boolean isUnique( Map<String, String> map ) {
        if (map.isEmpty()) return true;

        return new HashSet<>(map.values()).size() == map.size();
    }

    public static Map<String, Integer> intersect( Map<String, Integer> map1, Map<String, Integer> map2 ) {
        HashSet<String> set = new HashSet<>(map1.keySet());
        set.addAll(map2.keySet());

        HashMap<String, Integer> returnMap = new HashMap<>();
        for (String string : set) {
            if (map1.get(string) == map2.get(string)) returnMap.put(string, map1.get(string));
        }
        return returnMap;
    }

    public static int maxOccurrences( List<Integer> list ) {
        if (list.isEmpty()) return 0;

        Iterator<Integer> iterator = list.iterator();

        HashMap<Integer, Integer> map = new HashMap<>();

        int currentNum;
        int count;
        int maxNum = 0;

        while (iterator.hasNext()) {
            currentNum = iterator.next();
            count = map.containsKey(currentNum) ? map.get(currentNum) : 0;
            map.put(currentNum, count + 1);
            if (map.get(currentNum) > maxNum) maxNum = map.get(currentNum);
        }

        return maxNum;
    }
}
