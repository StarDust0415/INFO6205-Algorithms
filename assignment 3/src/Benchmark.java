

import simple.InsertionSort;
import simple.SelectionSort;
import simple.Sort;

import java.util.Arrays;
import java.util.function.Function;

public class Benchmark<T extends Integer> {

    public Benchmark(Function<Integer, Void> f) {
        this.f = f;
    }

    public double run(T t, int n) {
        Long startTime = System.nanoTime();

        for (int i = 0; i < n; i++) {
            f.apply(t.intValue() * i);
        }
        return (System.nanoTime() - startTime) / n / Math.pow(10, 6);
    }

    private final Function<Integer, Void> f;

    public static void main(String[] args) {
        int m = 200; // This is the number of repetitions: sufficient to give a good mean value of timing
        for (int n = 200; n <= 20000; n *= 2) {
            Integer[] array = new Integer[n * m];
            for (int i = 0; i < n * m; i++) array[i] = i;
            for (int i=array.length-1;i>=0;i--){
                int num=(int)(Math.random()*(i+1));
                Integer randomat=array[num];
                array[num]=array[i];
                array[i]=randomat;
            }
            // for partially shuffle
//            for (int i=0;i<n*m/4;i++){
//                int num1=(int)(Math.random()*(n*m));
//                int num2=(int)(Math.random()*(n*m));
//                int temp=array[num1];
//                array[num1]=array[num2];
//                array[num2]=temp;
//
//            }

            benchmarkSort(array, n, "SelectionSort", new SelectionSort<>(), m);
            for (int i = 0; i < n * m; i++) array[i] = i;
            for (int i = array.length - 1; i >= 0; i--) {
                int num = (int) (Math.random() * (i + 1));
                Integer randomat = array[num];
                array[num] = array[i];
                array[i] = randomat;
            }
//            for (int i=0;i<n*m/4;i++){
//                int num1=(int)(Math.random()*(n*m));
//                int num2=(int)(Math.random()*(n*m));
//                int temp=array[num1];
//                array[num1]=array[num2];
//                array[num2]=temp;
//
//            }
            benchmarkSort(array, n, "InsertionSort", new InsertionSort<>(), m);
        }

    }

    private static void benchmarkSort(Integer[] xs, Integer n, String name, Sort<Integer> sorter, int m) {
        Function<Integer, Void> sortFunction = (x) -> {
            sorter.sort(xs, x, x + n);
            return null;
        };
        Benchmark<Integer> bm = new Benchmark<>(sortFunction);
        double x = bm.run(n, m);
        System.out.println(name + ": " + x + " millisecs for n=" + n);
    }
}
