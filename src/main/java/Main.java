import java.util.List;
import java.util.Scanner;

/**
 * Main entrance point for the graphMaker program. graphMaker takes as input a
 * user defined degree sequence for a graph theory graph. Checks and outputs to
 * std if degree sequence is graphical.
 *
 * If the sequence is graphical, graphMaker then proceeds to create a general
 * simple graph from the degree sequence and will print to stdout properly
 * formatted strings that can be entered into various math software
 * (python Sage or Maple), to draw the graph.
 *
 * @author John Sfara
 * @version %I% %G%
 * @since 1.0
 */

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        FormatGraph formatter = new FormatGraph();
        InputParser inputParser = new InputParser();
        boolean isGraphical;

        while(true) {
            System.out.println("Enter degree sequence or x to quit: ");
            String input = s.nextLine();

            if(input.equals("x")) return;

            try{
                List<Integer> degreeSequence = inputParser.parse(input);
                isGraphical = Havel.isGraphical(degreeSequence);

                System.out.println("Degree sequence graphical: " +  String.valueOf(isGraphical).toUpperCase());

                if(isGraphical) {
                    Graph graph = new Graph(degreeSequence);
                    System.out.println();
                    System.out.println("Sage: " + formatter.sage(graph));
                    System.out.println();
                    System.out.println("Maple: " + formatter.maple(graph));

                }

                System.out.println();

            }catch (Exception e){
                System.out.println("Error: Incorrect input");
            }

        }
    }
}
