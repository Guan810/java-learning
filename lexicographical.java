import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author 关凯宁
 * @date 2020/6/9 15:31
 */
public class lexicographical {

    static String biggerIsGreater(String w){
        LinkedList<Character> has =new LinkedList<>();
        StringBuilder sb = new StringBuilder(w);
        char pre='a'-1;
        int i = w.length()-1;
        for (; i > -1; i--) {
            char now=w.charAt(i);
            sb.deleteCharAt(i);
            if(now>=pre){
                has.add(now);
                pre=now;
            }else{
                for (int j = 0; j < has.size(); j++) {
                    if(has.get(j)>now){
                        sb.append(has.get(j));
                        has.set(j,now);
                        break;
                    }
                }
                for(char c:has){
                    sb.append(c);
                }
                return sb.toString();
            }
        }
        return "no answer";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(new File("input01.txt"))));
        int n=Integer.parseInt(br.readLine());
        BufferedReader brr=new BufferedReader(new InputStreamReader(new FileInputStream(new File("output01.txt"))));
        for (int i = 0; i < n; i++) {
            String input=br.readLine();
            String now=biggerIsGreater(input);
            String reals=brr.readLine();
            if(!now.equals(reals)){
                System.out.println(i+" wrong with");
                System.out.println(input);
                System.out.println(now);
                System.out.println(reals);
                System.out.println("================");
            }
        }
    }
}
