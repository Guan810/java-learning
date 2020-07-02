
public class staticVar {
    public static int i=0;
    public int j=1;
    public static void main(String[] args) {
        staticVar a=new staticVar();
        staticVar b=new staticVar();
        a.j=2;
        a.i=1;
        b.i=2;
        b.j=3;
    }
}
