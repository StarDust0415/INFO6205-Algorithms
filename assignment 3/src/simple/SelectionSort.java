package simple;

public class SelectionSort<X extends Comparable<X>> implements Sort<X> {

    @Override
    public void sort(X[] xs, int from, int to) {
        // TODO implement selection sort
        int i, j, min, len = xs.length;
        X temp;
        for (i = from; i < to; i++) {
            min = i;
            for (j = i + 1; j < to; j++)
                if (xs[min].compareTo(xs[j]) > 0) {
                    min = j;
                }
            temp = xs[min]; //将最小元素放到已排序序列的末尾
            xs[min]=xs[i];
            xs[i]=temp;
        }
    }
}
