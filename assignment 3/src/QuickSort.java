import java.util.List;

public class QuickSort {
    public static <T extends List<Comparable>> void qSort(T arr, int head, int tail) {
        if (head >= tail || arr == null || arr.size() <= 1) {
            return;
        }
        int i = head, j = tail;
        Comparable pivot = arr.get((head + tail) / 2);
        while (i <= j) {
            while (arr.get(i) .compareTo(pivot)<0 ) {
                ++i;
            }
            while (arr.get(j) .compareTo(pivot)>0) {
                --j;
            }
            if (i < j) {
                Comparable t = arr.get(i);
                arr.set(i,arr.get(j));
                arr.set(j,t);
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        qSort(arr, head, j);
        qSort(arr, i, tail);
    }
    public static <T extends List<Comparable>> void  sort(T arr){
        qSort(arr,0,arr.size()-1);
    }
}
