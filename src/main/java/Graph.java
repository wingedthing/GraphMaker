import java.util.*;

/*
Creates a Graph object using a List of degree sequences. The graph uses a
HashMap<Integer, List<Integer> with vertices as keys and a List of adjacent
vertices as values. Takes as a constructor parameter a List<Integer> of degree
sequences.
*/

public class Graph {

    private final Map<Integer, List<Integer>> map;

    public Graph(List<Integer> list) {
        this.map = this.createGraph(list);
    }

    public int size(){
        return this.map.size();
    }

    public List<Integer> getAdjacentList(Integer i){
        return this.map.get(i);
    }

    public Set<Integer> keySet (){
        return this.map.keySet();
    }

    public List<Integer[]> edgeSet(){
        List<Integer[]> edgeSet = new ArrayList<>();
        for(Map.Entry<Integer,List<Integer>> entry : this.map.entrySet()){
            entry.getValue().stream().forEach(value -> {
                Integer[] arr = {entry.getKey(), value};
                edgeSet.add(arr);
            });
        }

        return edgeSet;
    }

    /*
    Creates a graph by using the Havel-Hakimi algorithm. Note that in order for
     this algo to work, the List<Integer[]> must be resorted in descending
     value after every iteration of the algo.
    */

    private Map<Integer, List<Integer>> createGraph(List<Integer> list){

        List<Integer[]> nodesAndDegrees = this.formatList(list);
        HashMap<Integer, List<Integer>> result = new HashMap<>();

        for(int i = 0; i < list.size(); i++){
            int currentDegree = nodesAndDegrees.get(i)[1];
            Integer nodeName = nodesAndDegrees.get(i)[0];

            List<Integer> adjacentNodes = new ArrayList<>();

            for(int j = i + 1 ; j <= i + currentDegree; j ++){
                Integer[] nextArray = nodesAndDegrees.get(j);
                int nextNode = nextArray[0];
                int nextDegree = nextArray[1];

                if(nextDegree > 0){
                    adjacentNodes.add(nextNode);
                    nextArray[1]--;
                    nodesAndDegrees.set(j, nextArray);
                }

            }

            result.put(nodeName, adjacentNodes);

            nodesAndDegrees.sort((a, b) -> b[1].compareTo(a[1]));
        }

        return result;
    }

    //Turns a list of Integers into a list of Integer arrays : [i, value]
    // where i is the original index of the value in the list.
    private List<Integer[]> formatList(List<Integer> list){
        list.sort(Collections.reverseOrder());
        List<Integer[]> result = new ArrayList<>();

        for( int i = 0; i < list.size(); i++) {
            Integer[] arr = {i, list.get(i)};
            result.add(i, arr);
        }

        return result;
    }
}
