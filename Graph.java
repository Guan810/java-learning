import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author 关凯宁
 * @date 2020/5/25 10:29
 */
class Graph
{
    private int V;   // No. of vertices
    private LinkedList[] adj; // Adjacency List

    //构造方法
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    // 添加一个边到图中
    void addEdge(int v,int w) { adj[v].add(w); }




    // 被拓扑排序调用的DFS函数
    void topologicalSortUtil(int v, boolean[] visited,
                             Stack<Integer> stack)
    {
        // 标记当前节点为已访问.
        visited[v] = true;
        Integer i;

        // 递归访问它的所有邻接顶点
        for (Object o : adj[v]) {
            i = (Integer) o;
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        // 把当前节点加入存放结果的栈中
        stack.push(v);
    }

    // 拓扑排序
    void topologicalSort()
    {
        Stack<Integer> stack = new Stack<>();

        // 标记所有节点为未访问
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        // Call the recursive helper function to store
        // Topological Sort starting from all vertices
        // one by one
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        // 打印结果栈的内容
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args)
    {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        g.topologicalSort();
    }
}
