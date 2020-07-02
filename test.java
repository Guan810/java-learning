import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author 关凯宁
 * @date 2020/6/7 9:11
 */
public class test {

    static void countSort(List<List<String>> arr) {
        long begin=System.currentTimeMillis();
        List<newList> arrr=new LinkedList<>();
        for (List<String> l:arr){
            arrr.add(new newList(l));
        }
        long end=System.currentTimeMillis();
        System.out.println(end-begin);
        for (int i = 0; i < arr.size()/2; i++) {
            arrr.get(i).content="-";
        }
        long end1=System.currentTimeMillis();
        System.out.println(end1-end);
        Collections.sort(arrr);
        long end2=System.currentTimeMillis();
        System.out.println(end2-end1);
        for(newList l:arrr){
            System.out.print(l.content+" ");
        }
    }

    static class newList implements Comparable<newList>{

        private int index;
        private String content;

        public newList(List<String> l) {
            index=Integer.parseInt(l.get(0));
            content=l.get(1);
        }

        @Override
        public int compareTo(newList o) {
            return Integer.compare(index,o.index);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        List<List<String>> arr = new LinkedList<>();
        IntStream.range(0,n).forEach(i->{
            try {
                arr.add(Stream.of(br.readLine().trim().split(" ")).collect(toList()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        countSort(arr);
    }

}
