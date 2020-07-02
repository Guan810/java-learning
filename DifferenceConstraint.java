import java.util.Arrays;

public class DifferenceConstraint {
    private final int[][] e;//所有约束条件
    private final int numV;//顶点个数
    private final int numE;//约束条件个数，即边数

    public DifferenceConstraint(int[][] bian,int n) {
        e = bian;
        numV = n;
        numE = e.length;
    }

    public int[] run(){
        //初始化距离数组，源点是新加入的辅助点，因此数组长度只需是n即可
        int[] dis=new int[numV];
        Arrays.fill(dis,0);

        //Bellman-ford
        for (int i = 0; i < numV; i++) {
            for (int j = 0; j < numE; j++) {
                int[] currE=e[j];
                if (dis[currE[1]]>dis[currE[0]]+currE[2]){
                    dis[currE[1]]=dis[currE[0]]+currE[2];
                }
            }
        }

        //检测负权环
        for(int l:dis){
            if(l<0){
                //检测出有负权环，返回null
                return null;
            }
        }

        //没有负权环，返回函数h
        return dis;
    }
}
