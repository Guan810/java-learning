public class Fib {
    public Fib() {
    }

    //递归
    static class FibRecursive{
        public static int run(int n){
            if(n<2){
                return 1;
            }else{
                return run(n-1)+run(n-2);
            }
        }
    }

    //循环
    static class FibCirculate{
        public static int run(int n){
            if(n<2){
                return 1;
            }else{
                int a=1;
                int b=1;
                for (int i = 1; i < n; i++) {
                    int temp=b;
                    b+=a;
                    a=temp;
                }
                return b;
            }
        }
    }

    //矩阵乘法
    static class FibMatrixMulty{
        public static int run(int n){
            if(n<2){
                return 1;
            }else{
                int[] t={1,1};
                int[] a={1,1,1,0};
                int[] res={1,0,0,1};
                matrixPower(a,n-1,res);
                return res[0]+res[1];
            }
        }

        private static void matrixPower(int[] a, int i, int[] res) {
            while(true){
                if((i&1)==1){
                    matrixMulty(a,res);
                }
                if(i==0) {
                    break;
                }
                i>>>=1;
                matrixMulty(a,a);
            }
        }

        private static void matrixMulty(int[] a, int[] res) {
            int[] temp=new int[4];
            temp[0]=a[0]*res[0]+a[1]*res[2];
            temp[1]=a[0]*res[1]+a[1]*res[3];
            temp[2]=a[2]*res[0]+a[3]*res[2];
            temp[3]=a[2]*res[1]+a[3]*res[3];
            for (int i = 0; i < res.length; i++) {
                res[i]=temp[i];
            }
        }
    }

    //test
    public static void main(String[] args) {
        int n=7;
        System.out.println(Fib.FibRecursive.run(n));
        System.out.println(Fib.FibCirculate.run(n));
        System.out.println(Fib.FibMatrixMulty.run(n));
    }

}
