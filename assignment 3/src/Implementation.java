import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;

public class Implementation {}
//    public static void main(String[] args) throws NoSuchMethodException {
////        Benchmark<RandomList> testForInsertion = new Benchmark<RandomList>((a) -> {
////            InsertionSort.sort(a);
////            return null;
////        });
//        Benchmark<RandomList> testForInsertion = new Benchmark<RandomList>(new Function<RandomList, Void>() {
//            @Override
//            public Void apply(RandomList comparables) {
//                InsertionSort.sort(comparables);
//                return null;
//            }
//        });
//        Benchmark<RandomList> testForSelection = new Benchmark<RandomList>((a) -> {
//            SelectionSort.sort(a);
//            return null;
//        });
//        Benchmark<RandomList> testForQuick = new Benchmark<RandomList>((a) -> {
//            QuickSort.sort(a);
//            return null;
//        });
////        for (int i=100;i<=100000;i*=2){
////            RandomList list=new RandomList(i);
////            System.out.println(
////                    (testForInsertion.run(list,10)));
////
////        }
////        for (int i=100;i<=10000;i*=2){
////            RandomList list=new RandomList(i);
////            System.out.println("The data size is "+i+" ,and the average run time of Insertion Sort is "+
////                    (testForInsertion.run(list,10))+" ms");
////
////        }
////        for (int i = 100; i <= 100000; i *= 2) {
////            RandomList list = new RandomList(i);
////            System.out.println(
////                    (testForSelection.run(list, 10)));
////
////        }
////        for (int i=100;i<=100000;i*=2){
////            RandomList list=new RandomList(i);
////            System.out.println("The data size is "+i+" ,and the average run time of Selection Sort is "+
////                    (testForSelection.run(list,10))+" ms");
////
////        }
//        for (int i = 100; i <= 10000000; i *= 2) {
//            RandomList list = new RandomList(i);
//            System.out.println(
//                    (testForQuick.run(list, 10)));
//
//        }
////        for (int i = 100; i <= 10000000; i *= 2) {
////            RandomList list = new RandomList(i);
////            System.out.println("The data size is " + i + " ,and the average run time of Quick Sort is " +
////                    (testForQuick.run(list, 10)) + " ms");
////
////        }
//
//    }
//}
