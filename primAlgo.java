import java.util.Arrays;

/**
 * primNode
 */
class primNode {

    // 存储到该节点最近的点的编号
    int NodeIndex;
    // 存储最小的权，这里按整数使用
    int lowestCost;
    primNode(int NodeIndex,int Cost){
        this.NodeIndex=NodeIndex;
        this.lowestCost=Cost;
    }
}
/**
 * primAlgo
 */
public class primAlgo {

    // 使用时创建一个算法实例，然后输入图的数据，调用函数输出
    // 存储结构
    // 1. 无序数组
    int[][] data;
    // 2. 最小堆或最大堆
    // 3. 斐波那契堆
    
    public primAlgo(int[][] data){
        this.data=data;
    }
    // 算法函数，返回结果是多个二元数组，代表保留下来的边
    public int[][] run() {
        primNode[] U=new primNode[data.length];
        boolean[] mark=new boolean[data.length];
        int min=0;
        Arrays.fill(mark, true);
        mark[0]=false;
        for(int i=0;i<U.length;i++){
            U[i]=new primNode(0, data[0][i]);
        }
        // 算法主体
        for (int i = 1; i < data.length; i++) {
            // 使用min()函数选出和当前生成树相连的最短边的目标节点编号
            min=min(U,mark);
            mark[min]=false;
            // 使用primNode[]来暂时存储保留下来的边的信息
            U[min].lowestCost=min;
            int[] temp=data[min];
            for (int j = 0; j < mark.length; j++) {
                // 判断逻辑为下：
                // 1. 判断目标节点是否已经在构造的最小树里
                // 2. 判断目标节点是否有边与当前生成树相连，若有，则继续；若无，将新的信息复制进来
                // 3. 判断新加入的结点是否有边与目标结点相连，若有，则继续；若无，则跳过
                // 4. 判断新的边和已有的最短边的大小，若新的边短，更新信息；否则跳过
                if(mark[j]&&(U[j].lowestCost==0||(temp[j]>0&&temp[j]<U[j].lowestCost))){
                    U[j].lowestCost=temp[j];
                    U[j].NodeIndex=min;
                }
            }
        }
        // 由于是用的primNode的结构储存最终结果，因此要用handle函数处理一下
        return handle(U);
    }
    public static int[][] handle(primNode[] a) {
        int[][] res=new int[a.length][2];
        for (int i = 0; i < res.length; i++) {
            res[i][0]=a[i].NodeIndex;
            res[i][1]=a[i].lowestCost;
            System.out.println(res[i][0]+"  "+res[i][1]);
        }
        return res;
    }
    public static int min(primNode[] a,boolean[] b) {
        int res=0;
        for (int i=0;i<b.length;i++) {
            if(b[i]){
                res=i;
                break;
            }
        }
        for (int i=0;i<a.length;i++) {
            if(b[i]&&a[res].lowestCost>a[i].lowestCost&&a[i].lowestCost>0){
                res=i;
            }
        }
        return res;
    }
}

// 测试
class Test{
    public static void main(String[] args) {
        int[][] data=new int[6][6];
        int[] v1={0,6,1,5,0,0};data[0]=v1;
        int[] v2={6,0,5,0,3,0};data[1]=v2;
        int[] v3={1,5,0,5,6,4};data[2]=v3;
        int[] v4={5,0,5,0,0,2};data[3]=v4;
        int[] v5={0,3,6,0,0,6};data[4]=v5;
        int[] v6={0,0,4,2,6,0};data[5]=v6;
        primAlgo a=new primAlgo(data);
        a.run();

    }
}