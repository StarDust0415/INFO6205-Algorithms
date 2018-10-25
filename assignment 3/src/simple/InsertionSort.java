package simple;


public class InsertionSort<X extends Comparable<X>> implements Sort<X> {
    @Override
    public void sort(X[] xs, int from, int to) {
        // TODO implement insertionSort
        for( int i=from; i<to-1; i++ ) {
            for( int j=i+1; j>from; j-- ) {
                if( xs[j-1] .compareTo(xs[j])<0)
                    break;
                X temp = xs[j];
                xs[j]=xs[j-1];
                xs[j-1]=temp;
            }
        }
    }
}
