
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * InputParser class provides methods for formatting and converting user input
 * into relevant data structures.
 */

public class InputParser {

    /**
     * Parses a user input string and returns an Integer List that represents a
     * graphical degree sequence.
     *
     * @param userInput  user input String.
     * @return           the correctly formatted and parsed degree sequence.
     * @throws Exception if input is non-numerical or empty.
     */
    public List<Integer> parse(String userInput) throws Exception{
        List<Integer> degreeSequence = Stream.of(userInput.replaceAll("[^0-9 ]"," ").split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if(degreeSequence.isEmpty()) {
            throw new Exception("Invalid input");
        }

        return degreeSequence;
    }

}
