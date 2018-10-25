package par;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

class ParSort {

    public static int cutoff = 1000;
    private static int threadNum;
    private static int max;
    
    public static void setMaxThread(int num){
    	max=num;
    }

    public static void sort(int[] array, int from, int to) {
        int size = to - from + 1;
        if (size <= cutoff||threadNum>=max) Arrays.sort(array, from, to+1);
        else {
            int mid=from+(to-from)/2;
            CompletableFuture<int[]> parsort1 = parsort(array, from, mid); // TODO implement me
            CompletableFuture<int[]> parsort2 = parsort(array, mid+1, to); // TODO implement me
            CompletableFuture<int[]> parsort = parsort1.
                    thenCombine(parsort2, (xs1, xs2) -> {
                        int[] result = new int[xs1.length + xs2.length];
                        int m=0,n=0;// TODO implement me
                        for(int i=0;i<result.length;i++){
                            if(n>=xs2.length||(m<xs1.length&&xs1[m]<=xs2[n])){
                                result[i]=xs1[m++];
                            }
                            else{
                                result[i]=xs2[n++];
                            }
                        }
                        return result;
                    });

            parsort.whenComplete((result, throwable) -> {
                for(int i=0;i<array.length;i++){
                    array[i]=result[i];
                }
            }); // TODO implement me
            parsort.join();
        }
    }

    private static CompletableFuture<int[]> parsort(int[] array, int from, int to) {
    	threadNum++;
//    	System.out.println(threadNum);
        return CompletableFuture.supplyAsync(
                () -> {
                    int[] result = new int[to  - from + 1];
                    int j=from;
                    for(int i=0;i<result.length;i++){
                        result[i]=array[j++];
                    }
                    sort(result,0,result.length-1);// TODO implement me
                    return result;
                }
        );
    }
}
