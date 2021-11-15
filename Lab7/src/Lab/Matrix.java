package Lab;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Matrix {
     int n;

    Integer[][] matr;
    public Matrix(Integer[][] matrix){
        matr= matrix;
        n=FileHelper.maxValue()+1;
    }


    public void findMSTWeight(JTextArea jTextArea, Prima prima, int ThreadCount) throws InterruptedException {
        List<Double> weigth = prima.weigth;
        List<Integer> indexes = new ArrayList<Integer>();
        Double sum=0.0;
        if (ThreadCount > weigth.size()) {
            Block b = new Block(weigth, 0, weigth.size(), 1);
            b.start();
            Thread.sleep(150);
            jTextArea.append(b.threadInfo);
            sum=b.sum;
        } else if (weigth.size() % ThreadCount == 0) {
            for (double i = 0; i < weigth.size(); i += ((weigth.size()*1.0)/ThreadCount*1.0)*1.0) {
                indexes.add((int) i);
            }
            for (int i = 0; i < indexes.size(); i++) {
                Block b = new Block(weigth, i * weigth.size()/ThreadCount, (i + 1) * weigth.size()/ThreadCount, i + 1);
                b.start();
                Thread.sleep(150);
                jTextArea.append(b.threadInfo);
                sum+= b.sum;
            }
        } else {
            for (double i = 0; i < weigth.size(); i += ((weigth.size()*1.0)/ThreadCount*1.0)*1.0) {
                indexes.add((int) i);
            }
            for (int i = 0; i < indexes.size() - 1; i++) {
                Block b = new Block(weigth, i * weigth.size()/ThreadCount, (i + 1) * weigth.size()/ThreadCount, i + 1);
                b.start();
                Thread.sleep(150);
                jTextArea.append(b.threadInfo);
                sum+= b.sum;
            }
            Block b = new Block(weigth, indexes.get(indexes.size() - 1), weigth.size(), indexes.size());
            b.start();
            Thread.sleep(150);
            jTextArea.append(b.threadInfo);
            sum+= b.sum;
        }
        System.out.println("Weight of minimum spanning tree is :"+sum);
    }

    public void findMSTWeightWithExecutor(Prima prima, int ThreadCount) throws InterruptedException {
        List<Double> weigth = prima.weigth;
        List<Integer> indexes = new ArrayList<Integer>();
        Double sum=0.0;

        for (double i = 0; i < weigth.size(); i += ((weigth.size()*1.0)/ThreadCount*1.0)*1.0) {
            indexes.add((int) i);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(indexes.size());

        if (ThreadCount > weigth.size()) {
            Block b = new Block(weigth, 0, weigth.size(), 1);
            executorService.submit(b);
            Thread.sleep(150);
            sum+= b.sum;
        } else if (weigth.size() % ThreadCount == 0) {
            for (int i = 0; i < indexes.size(); i++) {
                Block b = new Block(weigth, i * weigth.size()/ThreadCount, (i + 1) * weigth.size()/ThreadCount, i + 1);
                executorService.submit(b);
                Thread.sleep(150);
                sum+= b.sum;
            }
        } else {
            for (int i = 0; i < indexes.size() - 1; i++) {
                Block b = new Block(weigth, i * weigth.size()/ThreadCount, (i + 1) * weigth.size()/ThreadCount, i + 1);
                executorService.submit(b);
                Thread.sleep(150);
                sum+= b.sum;
            }
            Block b = new Block(weigth, indexes.get(indexes.size() - 1), weigth.size(), indexes.size());
            executorService.submit(b);
            Thread.sleep(150);
            sum+= b.sum;
        }
        System.out.println("Weight of minimum spanning tree is :"+sum);
    }
}