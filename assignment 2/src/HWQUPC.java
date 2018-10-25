/**
 * Original code:
 * Copyright © 2000–2017, Robert Sedgewick and Kevin Wayne.
 *
 * Modifications:
 * Copyright (c) 2017. Phasmid Software
 */


import java.util.Random;

/**
 * Height-weighted Quick Union with Path Compress
 */

public class HWQUPC {
    public int[] parent;   // parent[i] = parent of i
    public  int[] height;   // height[i] = height of subtree rooted at i
    public int count;  // number of components
    public boolean pathCompression = false;

    public int countConnected =0;

    /**
     * Initializes an empty union–find data structure with {@code n} sites
     * {@code 0} through {@code n-1}. Each site is initially in its own
     * component.
     *
     * @param  n the number of sites
     * @throws IllegalArgumentException if {@code n < 0}
     */
    public HWQUPC(int n) {
        count = n;
        parent = new int[n];
        height = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            height[i] = 0;
        }
    }

    public void show() {
        for (int i=0; i<parent.length; i++) {
            System.out.printf("%d: %d, %d\n", i, parent[i], height[i]);
        }
    }

    /**
     * Returns the number of components.
     *
     * @return the number of components (between {@code 1} and {@code n})
     */
    public int count() {
        return count;
    }

    /**
     * Returns the component identifier for the component containing site {@code p}.
     *
     * @param  p the integer representing one site
     * @return the component identifier for the component containing site {@code p}
     * @throws IllegalArgumentException unless {@code 0 <= p < n}
     */
    public int find(int p) {    //  Root of p
        validate(p);
        int root = p;
        while (root != parent[root])
            root = parent[root];
        if (!pathCompression)
            return root;
        HWQUPC.doPathCompression(p, root, parent);
        return root;
        // ... end of TODO
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
        }
    }

    /**
     * Returns true if the the two sites are in the same component.
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * @return {@code true} if the two sites {@code p} and {@code q} are in the same component;
     *         {@code false} otherwise
     * @throws IllegalArgumentException unless
     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    public boolean connected(int p, int q) {    // 是否相连
        countConnected++;
        return find(p) == find(q);
    }

    /**
     * Merges the component containing site {@code p} with the
     * the component containing site {@code q}.
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * @throws IllegalArgumentException unless
     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    public void union(int p, int q) {
        int i = find(p);    //root of p is i
        int j = find(q);    //root of q is j
        if (i == j)
            return;
        HWQUPC.mergeComponents(i, j, height, parent);
        count--;

    }

    /**
     * Used only by testing code
     * @param pathCompression
     */
    public void setPathCompression(boolean pathCompression) {
        this.pathCompression = pathCompression;
    }

    /**
     * Used only by testing code
     * @param i the component
     * @return the parent of the component
     */
    public int getParent(int i) {
        return parent[i];
    }

    static void mergeComponents(int i, int j, int[] height, int[] parent) {
        // TODO make shorter root point to taller one

        if(height[i] < height[j]){
            parent[i] = j;
        }else if(height[j] < height[i]){
            parent[j] = i;
        }else{
            parent[i] = j;
            height[j]++;
        }



        //throw new RuntimeException("not implemented");
    }



    static void doPathCompression(int p, int root, int[] parent) {
        // TODO update parent if appropriate
        throw new RuntimeException("not implemented");
    }


    public static int count(int n) {

        HWQUPC hw = new HWQUPC(n);
        Random rand = new Random();
        while (hw.count() != 1) {
            int number1 = rand.nextInt(n);
            int number2 = rand.nextInt(n);
            if (!hw.connected(number1, number2)) {
                hw.union(number1, number2);


            }else{

            }
        }
        hw.show();
        System.out.println("connected Number = " + hw.countConnected);

        return hw.countConnected;
    }

//    public static void main(String[] args){
//
//        int n = Integer.parseInt(args[0]);
//        double calculation  = 0;
//
//        for(int i=0;i<1;i++){
//
//            calculation  =  calculation + count(n);
//
//        }
//
//        calculation = calculation/1;
//        System.out.println("N configuration: "+ n);
//        System.out.println("Connections times in Average : " + calculation);
//
//        double symbol = (n * Math.log(n))/2;
//
//        System.out.println("Standard answer: "+ symbol);
//
//    }
}