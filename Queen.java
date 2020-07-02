/**
 * @author 关凯宁
 * @date 2020/6/1 12:10
 */
public class Queen {

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int[] direction=new int[8];
        direction[0]=n-r_q;
        direction[1]=Math.min(n-r_q,n-c_q);
        direction[2]=n-c_q;
        direction[3]=Math.min(n-c_q,r_q-1);
        direction[4]=r_q-1;
        direction[5]=Math.min(c_q-1,r_q-1);
        direction[6]=c_q-1;
        direction[7]=Math.min(n-r_q,c_q-1);

        for(int[] i: obstacles){
            int a=i[0]-r_q;
            int b=i[1]-c_q;
            if(i[0]==r_q){
                if(b<0){
                    if(-b-1<direction[6]){
                        direction[6]=-b-1;
                    }
                }else{
                    if(b-1<direction[2]){
                        direction[2]=b-1;
                    }
                }
            }else if(i[1]==c_q){
                if(a<0){
                    if(-a-1<direction[4]){
                        direction[4]=-a-1;
                    }
                }else{
                    if(a-1<direction[0]){
                        direction[0]=a-1;
                    }
                }
            }else if(a==b){
                if(a>0){
                    if(a-1<direction[1]){
                        direction[1]=a-1;
                    }
                }else{
                    if(-a-1<direction[5]){
                        direction[5]=-a-1;
                    }
                }
            }else if(a==-b){
                if(a>0){
                    if(a-1<direction[7]){
                        direction[7]=a-1;
                    }
                }else{
                    if(-a-1<direction[3]){
                        direction[3]=-a-1;
                    }
                }
            }
        }
        int res=0;
        for(int i: direction){
            res+=i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] a=new int[3][2];
        a[0]=new int[]{5,5};
        a[1]=new int[]{4,2};
        a[2]=new int[]{2,3};
        System.out.println(queensAttack(5,3,4,3,a));
    }
}
