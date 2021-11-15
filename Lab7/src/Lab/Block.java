package Lab;

import java.util.List;

public class Block extends Thread{
    List<Double> weigth;
    int start;
    int end;
    int numberOfPart;
    Double sum;
    String threadInfo;
    public String printTreadInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Id: "+ Thread.currentThread().getId() + "\n");
        sb.append("Name: "+Thread.currentThread().getName() + "\n");
        sb.append("Priority: "+ Thread.currentThread().getPriority()+ "\n");
        sb.append("State: "+ Thread.currentThread().getState()+ "\n");
        sb.append("Is alive : "+Thread.currentThread().isAlive()+ "\n\n");
        return  sb.toString();
    }

    @Override
    public void run() {
        threadInfo = printTreadInfo();
        findOwnValues();
    }

    public Block(List<Double> weigth,int start , int end,int numberOfPart)
    {

        this.start = start;
        this.end = end;
        this.numberOfPart = numberOfPart;
        this.weigth=weigth;

    }
    public void findOwnValues()
    {
        System.out.println(this);
        System.out.println("Sum of #"+numberOfPart+" part equals = "+sum(start,end));
        sum=sum(start,end);
        System.out.println();
    }
    public Double sum(int start,int end){
        Double sum = 0.0;
        for (int i = start; i < end; i++) {
         sum+=weigth.get(i);
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[ ");
        for( int i=start; i<end; i++)
        {
          stringBuilder.append(weigth.get(i)).append(" ");
        }
        stringBuilder.append("]");
        return  stringBuilder.toString();
    }
}
