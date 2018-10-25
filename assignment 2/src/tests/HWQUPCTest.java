import org.junit.Test;

import static org.junit.Assert.*;

public class HWQUPCTest {

    int n = 6;
    @Test
    public void show() {

        HWQUPC hw = new HWQUPC(n);
        for(int i=0;i<n;i++){
            assertEquals(i,hw.parent[i]);
            assertEquals(0,hw.height[i]);
            assertEquals(n,hw.count);
        }
    }

    @Test
    public void count() {

        HWQUPC hw = new HWQUPC(n);
        assertEquals(n,hw.count);
    }

    @Test
    public void find() {
    }

    @Test
    public void connected() {
    }

    @Test
    public void union() {

        HWQUPC hw = new HWQUPC(n);
        hw.union(1,3);
       // assertEquals();

    }

    @Test
    public void setPathCompression() {
    }

    @Test
    public void getParent() {
    }

    @Test
    public void mergeComponents() {
    }

    @Test
    public void doPathCompression() {
    }
}