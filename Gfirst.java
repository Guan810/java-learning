import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;


public class Gfirst {
    static class tablet{
        int id;
        ArrayList<Integer> index;

        public tablet(int id, ArrayList<Integer> index) {
            this.id = id;
            this.index = index;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        tablet[] ta=new tablet[a];
        for (int i = 0; i < a; i++) {
            ta[i]=new tablet(i,new ArrayList<>());
        }
        for (int i=0;i<b;i++){
            int l1=in.nextInt();
            int l2=in.nextInt();
            ta[l1-1].index.add(l2);
            ta[l2-1].index.add(l1);
        }
        int[][] res=new int[a][a];
        for (int i = 0; i < a; i++) {
            boolean[] visited=new boolean[a];
            BFS(ta,visited,res[i],i);
        }
        for(int[] l:res){
            for(int ll:l){
                System.out.printf(ll+" ");
            }
            System.out.println();
        }
    }


    private static void BFS(tablet[] ta,boolean[] visited,int[] res,int i) {
        visited[i]=true;
        res[i]=0;
        LinkedList<Integer> my = new LinkedList<>();
        my.add(i+1);
        for (int j = 1; !my.isEmpty()&&j < res.length; j++) {
            LinkedList<Integer> my2 = new LinkedList<>();
            while(!my.isEmpty()){
                int a=my.pop();
                for(int l:ta[a-1].index){
                    if(!visited[l-1]){
                        my2.add(l);
                        visited[l-1]=true;
                        res[l-1]=j;
                    }
                }
            }
            my=my2;
        }
    }
}
