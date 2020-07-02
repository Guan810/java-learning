import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author 关凯宁
 * @date 2020/6/18 21:11
 *
 * 问题描述
 * 2*N的网格，每个格内有一个字符，要求出一笔画且经过的字符连接不重复的个数
 *
 * 解决思路
 * 穷举？？
 *
 * 分治，规定接口的话只有两种可能——错了
 *
 * 穷举应该可行，至多计算8N-8次hashcode
 */
public class GridlandProvinces {

    static int gridlandProvinces(String s1, String s2) {
        char[][] ss=new char[2][];
        ss[0]=s1.toCharArray();
        ss[1]=s2.toCharArray();
        int n=ss[0].length;
        HashSet<String> hashSet = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            hashSet.addAll(getAllString(ss,i,n));
        }

        return hashSet.size();
    }

    private static Collection<String> getAllString(char[][] ss, int i, int n) {
        List<String> res=new LinkedList<>();
        if(i==0||i==n-1){
            res.addAll(mawaruAndDivide(ss,i,n));
        }else{
            res.add(mawaru(ss,i,0,true));
            res.add(mawaru(ss,i,0,false));
            res.add(mawaru(ss,i,1,true));
            res.add(mawaru(ss,i,1,false));
        }
        return res;
    }

    private static Collection<String> mawaruAndDivide(char[][] ss, int startCol,int n) {
        List<String> res=new LinkedList<>();
        if(startCol==0){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    int ushiroRow = (i % 2 == 0) ? j : (j + 1) % 2;
                    String sb = curly(ss, startCol, j, i) +
                            mawaru(ss, i, ushiroRow, i - 1, n, ushiroRow==1);
                    res.add(sb);
                }
            }
        }else {
            for (int i = n-1; i > -1; i--) {
                for (int j = 0; j < 2; j++) {
                    int ushiroRow = (i % 2 == 0) ? j : (j + 1) % 2;
                    String sb = curly(ss, startCol, j, i) +
                            mawaru(ss, i, ushiroRow, -1, i+1, ushiroRow==0);
                    res.add(sb);
                }
            }
        }
        return res;
    }

    private static String curly(char[][] ss, int startCol, int startRow, int bound) {
        StringBuilder res = new StringBuilder();
        int otherRow = (startRow + 1) % 2;
        if(startCol==0){
            for (int i = 0; i < bound; i++) {
                if(i%2==0){
                    res.append(ss[startRow][i]);
                    res.append(ss[otherRow][i]);
                }else{
                    res.append(ss[otherRow][i]);
                    res.append(ss[startRow][i]);
                }
            }
        }else{
            for (int i = startCol; i > bound; i--) {
                if(i%2==0){
                    res.append(ss[startRow][i]);
                    res.append(ss[otherRow][i]);
                }else{
                    res.append(ss[otherRow][i]);
                    res.append(ss[startRow][i]);
                }
            }
        }
        return res.toString();
    }

    private static String mawaru(char[][] ss,int startCol,int startRow,boolean isLeft){
        return mawaru(ss,startCol,startRow,-1,ss[0].length,isLeft);
    }

    private static String mawaru(char[][] ss, int startCol, int startRow,int boundLeft,int boundRight, boolean isLeft) {
        StringBuilder res=new StringBuilder();
        int otherRow = (startRow + 1) % 2;
        if(isLeft){
            for (int k = startCol; k > boundLeft; k--) {
                res.append(ss[startRow][k]);
            }
            for (int i = boundLeft+1; i < boundRight; i++) {
                res.append(ss[otherRow][i]);
                        
            }
            for (int k = boundRight-1; k > startCol; k--) {
                res.append(ss[startRow][k]);
            }
        }else {
            for (int k = startCol; k < boundRight; k++) {
                res.append(ss[startRow][k]);
            }
            for (int k = boundRight-1; k > boundLeft; k--) {
                res.append(ss[otherRow][k]);
            }
            for (int k = boundLeft+1; k < startCol; k++) {
                res.append(ss[startRow][k]);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine().trim();
        String s2=br.readLine().trim();
        System.out.println(gridlandProvinces(s1,s2));
    }
}
