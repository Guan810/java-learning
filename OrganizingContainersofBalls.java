import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author 关凯宁
 * @date 2020/6/18 15:48
 *
 * 问题描述
 * 给定容器和每个容器中不同种类球的个数，问最后能否通过交换的方式规整
 *
 * 解决方法
 * 只要容器中的球的总数量和每个种类的球的数量对应即可
 */
public class OrganizingContainersofBalls {
    static String organizingContainers(int[][] container) {
        int[] types=new int[container.length];
        int[] containNum=new int[container.length];
        for(int i=0;i<container.length;i++){
            for(int j=0;j<container.length;j++){
                types[i]+=container[i][j];
                containNum[j]+=container[i][j];
            }
        }
        Arrays.sort(types);
        Arrays.sort(containNum);
        for (int i = 0; i < types.length; i++) {
            if(types[i]!=containNum[i]){
                return "Impossible";
            }
        }
        return "possible";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        int[][] s=new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] in=br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                s[i][j]=Integer.parseInt(in[j].trim());
            }
        }
        System.out.println(organizingContainers(s));
    }
}
