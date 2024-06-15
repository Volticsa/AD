public class bfs{
    public static void bfs(Node start){
        boolean[]visited = new boolean[6];
        int [] queue = new int[6];
        int front =0;
        int rear=0;
        queue[rear++]=start.getValue();
        visited[start.getValue()]=true;
        while (front<rear) {
            int node =queue[front++];
            System.out.println(node+" ");
            for(int i=0;i<6;i++){
                if(graph[node][i]==1 && !visited[i]){
                    queue[rear++]=i;
                    visited[i]=true;
                }
            }
        }     
    }
    public static class Node{
        private int value;
        public Node(int value){
            this.value=value;
        }
        public int getValue(){
            return value;
        }
    }
    public static int [][]graph={
        {0, 1, 1, 0, 0, 0}, // A
        {1, 0, 0, 1, 1, 0}, // B
        {1, 0, 0, 0, 0, 1}, // C
        {0, 1, 0, 0, 0, 0}, // D
        {0, 1, 0, 0, 0, 1}, // E
        {0, 0, 1, 0, 1, 0}  // F
    };
    public static void main(String[] args) {
        System.out.println("hello");
        bfs(new Node(0));
    }
}