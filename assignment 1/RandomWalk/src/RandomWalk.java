
import java.util.Random;



public class RandomWalk {
    private int x = 0;
    private int y = 0;

    private final Random random = new Random();
    int directionNumber = 0;

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
        // TODO you need to implement this
    }

    public void randomWalk(int n) {
        x = 0;
        y = 0;
        for (int i = 0; i < n; i++)
            randomMove();
    }

    public void randomMove() {
        // TODO you need to implement this
        directionNumber = random.nextInt(4);
        int unitX = 0;
        int unitY = 0;

        if(directionNumber%2==0) {
            unitY = directionNumber-1;
        }else {
            unitX = directionNumber-2;
        }
        move(unitX,unitY);

    }


    public double distance(int length) {
        Double distance = length * Math.sqrt(y*y + x*x);
        return distance;

        // TODO you need to implement this
    }

    public static void main(String[] args) {
        int[] n = {10,50,100,150,200,250,300,350,400,500,650,800,1000,1300,1600,2000};
        RandomWalk walk = new RandomWalk();
        for(int i=0;i<n.length;i++) {
            double sum = 0;
            for (int times = 0; times < 8000; times++) {
                walk.randomWalk(n[i]);
                sum = sum + walk.distance(1);
            }


            System.out.println("When steps are" + n[i]+" the dinstence's average is " + sum/8000);
        }
    }
}