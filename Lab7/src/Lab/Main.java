package Lab;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Enter the number of threads: ");
        int ThreadCount = new Scanner(System.in).nextInt();
        long start = System.currentTimeMillis();
        Matrix matrix = new Matrix(FileHelper.matr());
        JFrame f = new JFrame();
        Prima prima = new Prima(matrix.n);
        Map<Integer, Map<Integer,Double>> e = prima.primMST(matrix.matr);

        f.setTitle("Prima");
        f.setBounds(500, 250, 100, 300);
        JTextArea jTextArea = new JTextArea("  ");
        jTextArea.setBounds(10, 25, 500, 200);
        jTextArea.setSize(600, 600);
        f.add(jTextArea);
        f.setBackground(Color.WHITE);
        jTextArea.setText("Executing my threads\n");
        jTextArea.getScrollableTracksViewportHeight();
        f.setSize(600, 600);
        f.setLayout(null);
        f.setVisible(true);
        //matrix.findMSTWeightWithExecutor(prima,ThreadCount);
        matrix.findMSTWeight(jTextArea,prima,ThreadCount);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
    }
}
