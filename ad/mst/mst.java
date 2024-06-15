public class mst {
    public static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static class Node {
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    public static void union(int[] parent, int x, int y) {
        int xroot = find(parent, x);
        int yroot = find(parent, y);

        parent[xroot] = yroot;
    }

    public static void mst(int[][] graph) {
        int V = graph.length;
        Edge[] edge = new Edge[V * (V - 1) / 2];
        int index = 0;
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (graph[i][j] != 0) {
                    edge[index] = new Edge(i, j, graph[i][j]);
                    index++;
                }
            }
        }

        Edge[] result = new Edge[V - 1];
        int[] parent = new int[V];
        for (int i = 0; i < V; i++)
            parent[i] = i;

        int k = 0;
        for (int i = 0; i < index; i++) {
            Edge e = edge[i];
            int x = find(parent, e.src);
            int y = find(parent, e.dest);

            if (x != y) {
                result[k++] = e;
                union(parent, x, y);
            }
        }

        for (int i = 0; i < k; i++) {
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 2, 0, 6, 0, 0},
            {2, 0, 3, 8, 5, 0},
            {0, 3, 0, 0, 7, 4},
            {6, 8, 0, 0, 0, 0},
            {0, 5, 7, 0, 0, 1},
            {0, 0, 4, 0, 1, 0}
        };

        mst(graph);
    }
}