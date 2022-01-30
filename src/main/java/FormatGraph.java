import java.util.List;

/**
 * FormatGraph is a class for formatting a graph created by the Graph class
 * into an input string that will be accepted by various graphing software
 * like sage and maple.
 */

public class FormatGraph {

    /**
     * Creates a String in the format accepted by python Sage.
     * Exp: "{'vertex_0' : ['adjacent_0', 'adjacent_1', ...], vertex_1 : [...], ...}"
     *
     * @param graph a <code>Graph</code> object to convert
     *
     * @return a formatted String
     *
     * @see Graph
     */
    public String sage(Graph graph) {
        StringBuilder result = new StringBuilder();
        result.append("{");

        for(int i = 0; i < graph.size(); i++) {
            result.append("'").append(i).append("' : [");
            graph.getAdjacentList(i).stream().forEach(value -> result.append("'").append(value).append("'").append(","));
            if(!graph.getAdjacentList(i).isEmpty()){
                result.setLength(result.length() - 1);
            }
            result.append("],");
        }

        result.setLength(result.length() - 1);
        result.append("}");

        return result.toString();
    }

    /**
     * Creates a String in the format accepted by Maple.
     * Exp: "#_vertices, {{u,v},{u,w},{w,x}, ...}"
     *
     * @param graph a <code>Graph</code> object to convert
     *
     * @return a formatted String
     *
     * @see Graph
     */
    public String maple(Graph graph) {
        StringBuilder result = new StringBuilder();
        List<Integer[]> edgeSet = graph.edgeSet();

        result.append(graph.size()).append(", {");
        edgeSet.stream().forEach(pair -> {
            result.append("{").append(pair[0] + 1).append(",").append(pair[1] + 1).append("},");
        });
        result.setLength(result.length() - 1);
        result.append("}");

        return result.toString();
    }
}
