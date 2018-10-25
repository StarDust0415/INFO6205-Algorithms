package par;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Please input the size of the array:");
        int size=scan.nextInt();
        int cutoff=size;
        for(int a=0;a<5;a++){
            cutoff=cutoff/2;
            ParSort.cutoff=cutoff;
            int max=2;
            while(2*max<size){
            	max=max*2;
            	if(max<size/32){continue;}
                Random random = new Random(0l);
                int[] array = new int[size];       
                ParSort.setMaxThread(max);    //set the max available amount of threads
                for (int i = 0; i < array.length; i++) array[i] = random.nextInt(10000);
        
                for(int l=0;l<1000;l++){       //to warm up
                    int aux[]=array.clone();
                    ParSort.sort(aux, 0, aux.length-1);
                }
        
                long start=0,end=0,totalTime=0;    //calculate the sort time
                for(int j=0;j<1000;j++){      	
                    start=System.nanoTime();
                    ParSort.sort(array, 0, array.length-1);
                    end=System.nanoTime();
                    totalTime=totalTime+(end-start);
                }
                
                System.out.println("====Size of array:"+size+", Max threads:"+max+", Cutoff:"+ParSort.cutoff+"====");
//              for (int i : array) System.out.println(i);
//              if (array[0]==11) System.out.println("Success!");
                System.out.println("Parallel sort took "+totalTime/1000+" ns");
                System.out.println();
            }
        }
    }
}
