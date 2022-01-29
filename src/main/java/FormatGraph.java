import java.util.List;

public class FormatGraph {

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

    public String maple(Graph graph) {
        StringBuilder result = new StringBuilder();
        List<Integer[]> edgeSet = graph.edgeSet();

        result.append(graph.size()).append(", {");
        edgeSet.stream().forEach(pair -> {
            result.append("{").append(pair[0]).append(",").append(pair[1]).append("},");
        });
        result.setLength(result.length() - 1);
        result.append("}");

        return result.toString();
    }
}
