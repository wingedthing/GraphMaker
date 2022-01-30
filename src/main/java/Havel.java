import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Havel class provides the isGraphical static method to check if a degree
 * sequence is graphical using the Havel-Hakmi algorithm.
 */
public class Havel {

    /**
     * Checks if a degree sequence is valid using the Havel-Hakmi algorithm.
     * Will also print to stdout each intermediate calculation of the algorithm
     *
     * @param degreeSequence a List of degree sequences from a graph
     *
     * @return <code>true</code> if degree sequence is graphical.
     *
     * @see InputParser
     */
    public static boolean isGraphical(List<Integer> degreeSequence){
        List<Integer> list = new ArrayList<>(degreeSequence);

        while(true){
            list.sort(Collections.reverseOrder());
            int counter = 0;
            int numOfOdds = 0;
            System.out.println(list);

            for(int value : list){
                if(value < 0){
                    return false;
                }

                if(value % 2 == 1){
                    numOfOdds++;
                }

                counter += value;
            }

            if(list.isEmpty() || counter == 0){
                return true;
            }
            if(numOfOdds % 2 == 1) {
                return false;
            }

            int currentValue = list.get(0);
            list.remove(0);

            if(currentValue > list.size()) {
                return false;
            }

            for(int i = 0; i < currentValue; i++){
                int value = list.get(i);
                list.set(i, value - 1);
            }
        }

    }
}
