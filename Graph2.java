import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author 关凯宁
 * @date 2020/5/25 10:31
 */
public class Graph2 {

    private int v;
    private final LinkedList<Integer>[] adj;
    private final int[] inDegree;

    //构造方法
    Graph2(int v)
    {
        this.v = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i) {
            adj[i] = new LinkedList<Integer>();
        }
        inDegree=new int[v];
        Arrays.fill(inDegree,0);
    }

    // 添加一个边到图中
    void addEdge(int v,int w) {
        adj[v].add(w);
        //将w的入度加1
        inDegree[w]++;
    }

    void topologicalSort(){
        int[] res=new int[v];

        for (int i = 0; i < v; i++) {
            //
            for (int j = 0; j < v; j++) {
                if(inDegree[j]==0){
                    res[i]=j;

                    for (int l:adj[j]){
                        inDegree[l]--;
                    }

                    inDegree[j]--;
                }
            }
        }

        // 打印结果的内容
        for (int i:res){
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args)
    {
        Graph2 g = new Graph2(6);
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
