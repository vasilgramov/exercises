package softUni.interview;

import java.util.*;

public class linkedListLoop {

    public static void main(String[] args) {
        String element = "firstElement";
        String[] elementsWithLoop = new String[] {
            "secondElement",
            element,
            "thirdElement",
            "fourthElement",
            "fifthElement",
            "sixthElement",
            element,
            "seventhElement",
        };
        printLength(new LinkedList<>(), elementsWithLoop);

        String[] elementsWithoutLoop = new String[] {
            "firstElement",
            "secondElement",
            "thirdElement",
            "fourthElement",
            "fifthElement"
        };
        printLength(new LinkedList<>(), elementsWithoutLoop);
    }


    private static void printLength(List<String> linkedList, String[] elements) {
        linkedList.addAll(Arrays.asList(elements));

        int length = getLengthOfReferenceLoop(linkedList);
        System.out.printf("The length of the loop is: %d%n", length);
    }

    private static int getLengthOfReferenceLoop(List<String> linkedList) {
        Map<String, Integer> indexByReference = new HashMap<>();
        int idx = 0;
        for (String e : linkedList) {
            int currentIndex = idx;
            String reference = Integer.toHexString(System.identityHashCode(e));     // https://stackoverflow.com/questions/580984/how-do-you-get-the-object-reference-of-an-object-in-java-when-tostring-and-h

            if (!indexByReference.containsKey(reference)) {
                indexByReference.put(reference, idx);
            } else {
                int index = indexByReference.get(reference);

                return currentIndex - index;
            }

            idx++;
        }

        return -1;
    }
}
