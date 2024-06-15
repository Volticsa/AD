public class dfs {
    public static void dfs(Node node, boolean[] visited) {
        visited[node.getValue()] = true;
        System.out.print(node.getValue() + " ");

        for (int i = 0; i < 6; i++) {
            if (graph[node.getValue()][i] == 1 &&!visited[i]) {
                dfs(new Node(i), visited);
            }
        }
    }

    public static class Node {
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static int[][] graph = {
        {0, 1, 1, 0, 0, 0}, // A
        {1, 0, 0, 1, 1, 0}, // B
        {1, 0, 0, 0, 0, 1}, // C
        {0, 1, 0, 0, 0, 0}, // D
        {0, 1, 0, 0, 0, 1}, // E
        {0, 0, 1, 0, 1, 0}  // F
    };

    public static void main(String[] args) {
        boolean[] visited = new boolean[6];
        dfs(new Node(0), visited); // Output: 0 1 3 4 2 5
    }
}