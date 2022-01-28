import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Havel {

    //checks if a degree sequence is valid using Havel-Hakmi algorithm

    public static boolean isGraphical(List<Integer> ogList){
        List<Integer> list = new ArrayList<>(ogList);

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
