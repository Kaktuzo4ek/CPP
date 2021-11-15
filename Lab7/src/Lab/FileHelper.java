package Lab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class FileHelper {
public static Integer[][]matr(){
    Integer max = maxValue();
    Integer[][] matr = new Integer[max+1][max+1];
    for (int i = 0; i <= max ; i++) {
        for (int j = 0; j <= max; j++) {
            matr[i][j]=0;
        }
    }
    List<Integer> list1=getEdges_1();
    List<Integer> list2=getEdges_2();
    List<Integer> weight=getWeight();

    for (int i = 0; i < weight.size(); i++) {
        matr[list1.get(i)][list2.get(i)]=weight.get(i);
        matr[list2.get(i)][list1.get(i)]=weight.get(i);
    }
    for (int i = 0; i <= max ; i++) {
        for (int j = 0; j <= max; j++) {
            System.out.print(matr[i][j]+" ");
        }
        System.out.print("\n");
    }
    System.out.println("\n");

 return matr;

}
   public static Integer maxValue(){
    Integer max = 0;
    List<Integer> list1=getEdges_1();
//    List<Integer> list1=getEdges_1();
list1.addAll(getEdges_2());
max = list1.stream().mapToInt(x->x).max().orElseThrow(NoSuchElementException::new);
       return max;
   }
    public static List<Integer> getEdges_1(){
        List<Integer> Edge= new ArrayList<>();
        BufferedReader br = null;
        try {
            File file = new File("src/graph_data");
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String temp = parts[0].trim();
                if (!temp.equals("")) Edge.add(Integer.valueOf(temp));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Edge;
    }
    public static List<Integer> getEdges_2(){
        List<Integer> Edge= new ArrayList<>();
        BufferedReader br = null;
        try {
            File file = new File("src/graph_data");
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String temp = (parts[1].trim());
                if (!temp.equals("")) Edge.add(Integer.valueOf(temp));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Edge;
    }
    public static List<Integer> getWeight(){
        List<Integer> weight= new ArrayList<>();
        BufferedReader br = null;
        try {
            File file = new File("src/graph_data");
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String temp = parts[2].trim();
                if (!temp.equals("")) weight.add(Integer.valueOf(temp));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weight;
    }

}
