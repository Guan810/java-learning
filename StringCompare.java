/**
 * @author 关凯宁
 * @date 2020/6/17 22:47
 */
public class StringCompare {

    /**
     * String 直接赋值，则该值在确保常量池中有一个对应值后，将其地址赋给引用
     * new String() 则会在确保常量池中存在的情况下，在堆中在开辟一个位置，将堆中的地址赋给引用
     * 测试字节码可以看出
     *
     * 直接赋值的字节码只有两句
     *        0: ldc           #2                  // String aaa
     *        2: astore_1
     *new方法则有明显的创建对象的过程
     *        6: new           #3                  // class java/lang/String
     *        9: dup
     *       10: ldc           #2                  // String aaa
     *       12: invokespecial #4                  // Method java/lang/String."<init>":(Ljava/lang/String;)V
     *       15: astore_3
     *
     * 输出结果也可以看出这一点
     *      a = b : true
     *      a = c : false
     *      c = d : false
     */
    public static void main(String[] args) {
        String a="aaa";
        String b="aaa";
        String c=new String("aaa");
        String d=new String("aaa");
        System.out.println("a = b : "+(a==b));
        System.out.println("a = c : "+(a==c));
        System.out.println("c = d : "+(c==d));
    }
}
