import java.util.concurrent.*;

public class MatrixMulty {

    //print
    static void print(int[][] a){
        for (int[] l:a) {
            for(int ll:l){
                System.out.print(" " + ll);
            }
            System.out.println(" ");
        }
    }

    //Simple
    //C=A*B
    static void SimpleMulty(int[][] C,int[][] A,int[][] B,int n){
        for (int i = 0; i < n; i++) {//C的第i行
            for (int j = 0; j < n; j++) {//C的第j列
                for (int k = 0; k < n; k++) {//A，B中的乘法
                    C[i][j]+=A[i][k]*B[k][j];
                }
            }
        }
    }

    //First
    static void First(int[][] C,int[][] A,int[][] B,int n){
        if(n==1){
            C[0][0]=A[0][0]*B[0][0];
        }else{
            ExecutorService threadpool=Executors.newCachedThreadPool();

            threadpool.shutdown();;
        }
    }
    class Multy implements Runnable{
        int[][] C;
        int[][] A;
        int[][] B;
        int[] cRule;
        int[] aRule;
        int[] bRule;
        int n;
        final CountDownLatch count;
        final ExecutorService es;

        public Multy(int[][] c, int[][] a, int[][] b, int[] cRule, int[] aRule, int[] bRule, int n, CountDownLatch count, ExecutorService es) {
            C = c;
            A = a;
            B = b;
            this.count = count;
            this.es = es;
            cRule = cRule;
            aRule = aRule;
            bRule = bRule;
            this.n=n;
        }

        @Override
        public void run() {
            if(n==1){
                C[cRule[0]][cRule[1]]+=A[aRule[0]][aRule[1]]*B[bRule[0]][bRule[1]];
            }else{
                int nextN=(int)n/2;
                CountDownLatch count1=new CountDownLatch(8);
                int[][] NextaRule=splitRule(aRule,nextN);
                int[][] NextbRule=splitRule(bRule,nextN);
                int[][] NextcRule=splitRule(cRule,nextN);

            }
            count.countDown();
        }

        private int[][] splitRule(int[] rule,int n) {
            int[][] res=new int[4][2];
            res[0][0]=rule[0];
            res[0][1]=rule[1];
            res[1][0]=rule[0];
            res[1][1]=rule[1]+n;
            res[2][0]=rule[0]+n;
            res[2][1]=rule[1];
            res[3][0]=rule[0]+n;
            res[3][1]=rule[1]+n;
            return res;
        }
    }
    
    //test
    public static void main(String[] args) {
        int[][] A=new int[2][2];
        int[][] B=new int[2][2];
        int[][] C=new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                A[i][j]=1;
                B[i][j]=1;
            }
        }
        A[1][1]=0;
        B[1][1]=0;
        SimpleMulty(C,A,B,2);
        print(C);
    }
}
