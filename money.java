import java.util.*;

/**
 * @author 关凯宁
 * @date 2020/5/21 20:49
 */
public class money {
//第一种方法
    //主函数，递归入口
    public static long getWays(int n, List<Long> c) {
        // 对货币面值的预处理，包括排序和预先生成最小面值子列
        Collections.sort(c);
        ArrayList<List<Long>> cs=new ArrayList<List<Long>>();
        long res=0;
        for(int i=0;i<c.size();i++){
            cs.add(getSubList(c,i));
        }
        for(int i=0;i<c.size();i++){
            if(n-c.get(i)<0){
                break;
            }
            res+=getNum(cs.get(i),cs,n-c.get(i));
        }
        return res;
    }
    //递归函数
    private static List<Long> getSubList(List<Long> c, int i) {
        List<Long> res=new ArrayList<>();
        for (int j = i; j < c.size(); j++) {
            res.add(c.get(j));
        }
        return res;
    }
    //得到子列
    private static long getNum(List<Long> list, ArrayList<List<Long>> cs, long l) {
        if(l<0){
            return 0;
        }else if(l==0){
            return 1;
        }else{
            long res=0;
            for (int i = 0; i < list.size(); i++) {
                res+=getNum(cs.get(cs.size()-list.size()+i),cs,l-list.get(i));
            }
            return res;
        }
    }

//    第三种方法
    public static long getWay2(int n, List<Long> c){
        long[][] mid=new long[c.size()][n+1];
        for (int i = 0; i < c.size(); i++) {
            mid[i][0]=1;
        }
        for (int i = 0; i < c.size(); i++) {
            for (int j = 1; j <n+1; j++) {
                long x=(i>0)?mid[i-1][j]:0;
                long y=(j-c.get(i)>=0)?mid[i][(int) (j-c.get(i))]:0;
                mid[i][j]=x+y;
            }
        }
        return mid[c.size()-1][n];
    }


    public static void main(String[] args) {
        List<Long> list=new ArrayList<>();
        list.add((long)2);
        list.add((long)5);
        list.add((long)3);
        list.add((long)6);
        int l=10;
        System.out.println(getWay2(l,list));
        System.out.println(getWays(l,list));
    }
}
