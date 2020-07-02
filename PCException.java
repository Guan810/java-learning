import java.io.IOException;
/*
* 子类覆写时必须抛出原来的错误
*/
public class PCException {
    class A{
        void write() throws IOException{
            System.out.println("A");
        }
    }

    class B extends A{
        void write() throws IOException /*Exception*/{
            System.out.println("B");
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf(1).equals(Long.valueOf(1)));
    }
}