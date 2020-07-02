/**
 * @author 关凯宁
 * @date 2020/7/1 22:45
 */
public class InhericFied {

    /**
     * 在内存中同时存在父类和子类的属性，输出时的调用主要决定于引用类型
     *
     * 结果：
     *      1001
     *      1002
     * */

    public static void main(String[] args) {
        parent p=new child();
        System.out.println(p.id);
        child c= (child) p;
        System.out.println(c.id);
    }
}

class parent{
    int id=1001;
}

class child extends parent{
    int id=1002;
}
