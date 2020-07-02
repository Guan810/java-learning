package pkgB;
import pkgA.test;
/**
 * @author 关凯宁
 * @date 2020/6/7 9:16
 */
public class test2 {
    public static void main(String[] args) {
        test a=new test();
        /*包外实例无法访问没有用public修饰的区域*/
//        System.out.println(a.a);
        /*更不用说用protexted修饰的了*/
//        System.out.println(a.b);
        System.out.println(a.c);
    }
}
