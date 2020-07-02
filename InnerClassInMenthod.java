/*
* 方法中的内部类可以访问外部类的final变量和不被final修饰的变量
*/
public class InnerClassInMenthod {
    int i=1;
    final int j=2;
    void write(){
        class InnerClass {
            void writeI(){
                System.out.println(i);
            }
            void writeJ(){
                System.out.println(j);
            }
            
        }
        InnerClass a=new InnerClass();
        a.writeI();
        a.writeJ();
    }
    public static void main(String[] args) {
        InnerClassInMenthod a=new InnerClassInMenthod();
        a.write();
    }
}