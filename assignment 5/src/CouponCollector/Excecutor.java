package CouponCollector;
import java.util.ArrayList;
import java.util.Random;

public class Excecutor {
    public static void main(String[] args) {
        CouponColletor<Integer,Integer > couponColletor;
        int times = 100;
        int M;
        Random random = new Random();
        ArrayList<Double> rates=new ArrayList<>();
        for (M = 100; M <= 10000; M *= 2) {
            int count = 0;
            for (int i = 0; i < times; i++) {
                couponColletor = new CouponColletor<>(M);
                while (!couponColletor.ifOccupy()) {
                    int id = random.nextInt(1000000);
                    couponColletor.put(id,id);
                    count++;
                }
            }
            double rate = count / times;
            System.out.println(rate);
            rates.add(rate);
        }
        System.out.println();
        for (M=100;M<=10000;M*=2){
            System.out.println(M*Math.log(M));
        }
        int count=0;
        for (M=100;M<=10000;M*=2){
            double assumption =M*Math.log(M);
            double rate =rates.get(count++);
            System.out.println("The M is "+M+". The assumption is " + assumption + ",the result of experiment is " + rate+
                    ". The ratio between them is "+assumption/rate);
        }


    }
}
