import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 关凯宁
 * @date 2020/6/18 16:49
 *
 * 问题描述
 * 对一个矩阵旋转指定位数并输出
 *
 * 解决方法
 * 找到一种对应方式
 *      先判断当前是第几层
 *      再对四条边分情况
 */
public class MatrixRotation {

    static void matrixRotation(List<List<Integer>> matrix, int r) {
        int row = matrix.size()-1;
        int col = matrix.get(0).size()-1;
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                int[] newIndex=getIndex(r, row, col, i, j);
                System.out.print(matrix.get(newIndex[0]).get(newIndex[1])+" ");
            }
            System.out.println();
        }

    }

    /**
     * 试图直接得到新坐标受r的影响，需要考虑的情况太多，结果应该没问题，
     *
     * @return 新的坐标
     */
    private static int[] getIndex(int r, int row, int col, int i, int j) {
        int[] res=new int[2];

        int[] label={j,i,col-j,row-i};
        //层数从0开始
        int ceng=Integer.MAX_VALUE;
        //bian代表那条边，从0开始依次为左、上、右、下
        int bian=0;
        for (int k = 0; k < 4; k++) {
            if(label[k]<ceng){
                ceng=label[k];
                bian=k;
            }
        }
        int[] limits={row-2*ceng,col-2*ceng};
        int offset = 0;
        switch(bian){
            case 0:
                offset=i-ceng;
                break;
            case 1:
                offset=col-ceng-j;
                break;
            case 2:
                offset=row-ceng-i;
                break;
            case 3:
                offset=j-ceng;
                break;
            default:
        }
        if(r<=offset){
            switch (bian){
                case 0:
                    res[0]=i-r;
                    res[1]=j;
                    break;
                case 1:
                    res[0]=i;
                    res[1]=j+r;
                    break;
                case 2:
                    res[0]=i+r;
                    res[1]=j;
                    break;
                case 3:
                    res[0]=i;
                    res[1]=j-r;
                    break;
                default:
            }
        }else{
            r-=offset;
            r%=(limits[0]+limits[1])*2;//本来超时的，加上这行居然不超了
            while (r>=0){
                r-=limits[(bian+1)%2];
                bian=(bian+1)%4;
            }
            switch (bian){
                case 0:
                    res[0]=ceng-r;
                    res[1]=ceng;
                    break;
                case 1:
                    res[0]=ceng;
                    res[1]=col-ceng+r;
                    break;
                case 2:
                    res[0]=row-ceng+r;
                    res[1]=col-ceng;
                    break;
                case 3:
                    res[0]=row-ceng;
                    res[1]=ceng-r;
                    break;
                default:
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        int mm=Integer.parseInt(br.readLine().trim());
        int r=Integer.parseInt(br.readLine().trim());
        List<List<Integer>> m=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] s=br.readLine().split(" ");
            List<Integer> l=new ArrayList<>();
            for (int j = 0; j < mm; j++) {
                l.add(Integer.parseInt(s[j].trim()));
            }
            m.add(l);
        }
        matrixRotation(m,r);
    }
}
