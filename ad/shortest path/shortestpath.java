public class shortestpath {
    public static class Node {
        int value;
        int distance;
        Node previous;

        public Node(int value) {
            this.value = value;
            this.distance = Integer.MAX_VALUE;
            this.previous = null;
        }
    }

    public static void dijkstra(int[][] graph, int start) {
        int V = graph.length;
        Node[] nodes = new Node[V];
        for (int i = 0; i < V; i++) {
            nodes[i] = new Node(i);
        }

        nodes[start].distance = 0;

        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            int minDistance = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < V; j++) {
                if (!visited[j] && nodes[j].distance < minDistance) {
                    minDistance = nodes[j].distance;
                    minIndex = j;
                }
            }

            visited[minIndex] = true;

            for (int j = 0; j < V; j++) {
                if (!visited[j] && graph[minIndex][j]!= 0 && nodes[minIndex].distance + graph[minIndex][j] < nodes[j].distance) {
                    nodes[j].distance = nodes[minIndex].distance + graph[minIndex][j];
                    nodes[j].previous = nodes[minIndex];
                }
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.print("Distance to node " + i + ": " + nodes[i].distance + " ");
            Node node = nodes[i];
            System.out.print("Path: ");
            while (node!= null) {
                System.out.print(node.value + " ");
                node = node.previous;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        dijkstra(graph, 0);
    }
}