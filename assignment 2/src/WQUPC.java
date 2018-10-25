
/*
 * Copyright (c) 2017. Phasmid Software
 */

import java.util.Random;

/**
 * Weighted Quick Union with Path Compression
 */
public class WQUPC {
    private int[] parent;   // parent[i] = parent of i
    private int[] size;   // size[i] = size of subtree rooted at i
    private int count;  // number of components
    public int ConnectionTimes = 0;
    /**
     * Initializes an empty union–find data structure with {@code n} sites
     * {@code 0} through {@code n-1}. Each site is initially in its own
     * component.
     *
     * @param  n the number of sites
     * @throws IllegalArgumentException if {@code n < 0}
     */
    public WQUPC(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void show() {
        for (int i=0; i<parent.length; i++) {
            System.out.printf("%d: %d, %d\n", i, parent[i], size[i]);
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
    public int find(int p) {
        validate(p);
        int root = p;
        while (root != parent[root]) {
            root = parent[root];
        }
        while (p != root) {
            int newp = parent[p];
            parent[p] = root;
            p = newp;
        }
        return root;
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
    public boolean connected(int p, int q) {
        ConnectionTimes++;
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
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        // make smaller root point to larger one
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }


    public static int count(int n){
        WQUPC wqu = new WQUPC(n);
        Random rand = new Random();
        while (wqu.count() != 1) {
            int number1 = rand.nextInt(n);
            int number2 = rand.nextInt(n);
            if (!wqu.connected(number1, number2)) {
                wqu.union(number1, number2);


            }
        }

        return wqu.ConnectionTimes;
    }

    public static void main(String[] args){

        int[] n = {10,100,200,600,1200,2400,4800,9600,12800,};

        double calculation  = 0;

        for(int i =0; i<n.length;i++){
            calculation = 0;
            for(int j=0;j<8000;j++) {

                calculation = calculation + count(n[i]);

            }
            calculation = calculation/8000;
            double symbol =  Math.log(n[i]) *(n[i]/2);
//
            System.out.println(n[i]+","+calculation+","+symbol);
        }


    }

}