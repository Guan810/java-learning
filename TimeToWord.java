import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 关凯宁
 * @date 2020/6/18 16:03
 *
 * 问题描述
 * 将时间转变为字符串，有一定分类
 *
 * 解决方法
 * 需要一个翻译字典
 *
 * {{}}用于初始化，第一层代表匿名类，第二层代表创建时运行的代码
 */
public class TimeToWord {


    static String timeInWords(int h, int m, Map<Integer, String> dict) {
        int divide=m/15;
        int mod=m%15;
        if(mod==0){
            switch (divide){
                case 0:
                    return dict.get(h)+" o'clock";
                case 1:
                    return "quarter past "+ dict.get(h);
                case 2:
                    return "half past "+ dict.get(h);
                case 3:
                    return "quarter to "+ dict.get((h+1==13)?0:h+1);
                default:
            }
        }else{
            String min=" minute";
            if(mod>1){
                min+="s";
            }
            switch (divide){
                case 0:
                    return dict.get(m)+min+" past "+ dict.get(h);
                case 1:
                    return dict.get(m)+min+" past "+ dict.get(h);
                case 2:
                    return dict.get(60-m)+min+" to "+ dict.get((h+1==13)?0:h+1);
                case 3:
                    return dict.get(60-m)+min+" to "+ dict.get((h+1==13)?0:h+1);
                default:
            }
        }
        return " ";
    }

    public static void main(String[] args) throws IOException {
        Map<Integer, String> dict=new HashMap<Integer, String>();
        dict.put(0,"zero");
        dict.put(1,"one");
        dict.put(2,"two");
        dict.put(3,"three");
        dict.put(4,"four");
        dict.put(5,"five");
        dict.put(6,"six");
        dict.put(7,"seven");
        dict.put(8,"eight");
        dict.put(9,"nine");
        dict.put(10,"ten");
        dict.put(11,"eleven");
        dict.put(12,"twelve");
        dict.put(13,"thirteen");
        dict.put(14,"fourteen");
        dict.put(15,"fifteen");
        dict.put(16,"sixteen");
        dict.put(17,"seventeen");
        dict.put(18,"eighteen");
        dict.put(19,"nineteen");
        dict.put(20,"twenty");
        dict.put(21,"twenty one");
        dict.put(22,"twenty two");
        dict.put(23,"twenty three");
        dict.put(24,"twenty four");
        dict.put(25,"twenty five");
        dict.put(26,"twenty six");
        dict.put(27,"twenty seven");
        dict.put(28,"twenty eight");
        dict.put(29,"twenty nine");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int h=Integer.parseInt(br.readLine().trim());
        int m=Integer.parseInt(br.readLine().trim());
        System.out.println(timeInWords(h,m,dict));
    }
}
