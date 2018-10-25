package birthday;

import java.util.ArrayList;
import java.util.Random;

public class Excecutor {
    public static void main(String[] args) {
        BirthDay<Integer, Integer> birthDay;
        int times = 100;
        int M;
        Random random = new Random();
        ArrayList<Double> rates = new ArrayList<>();
        for (M = 100; M <= 10000; M *= 2) {
            int count = 0;
            for (int i = 0; i < times; i++) {
                birthDay = new BirthDay<>(M);
                while (true) {
                    int id = random.nextInt(1000000);
                    if (birthDay.ifEncountered(id)) {
                        break;
                    } else {
                        birthDay.put(id, id);
                        count++;
                    }
                }
            }
            double rate = count / times;
            double assumption = Math.sqrt(Math.PI * M / 2);


            System.out.println("The assumption is " + assumption + ",the result of experiment is " + rate);

        }

    }
}
