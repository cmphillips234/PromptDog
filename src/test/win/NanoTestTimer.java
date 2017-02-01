/**
 * & caleb
 * @author wfbar
 */
package test.win;



public class NanoTestTimer {
    private long start;
    private long stop;
    
    {
        start = -1;
        stop = -1;
    }
    
    void start() {
        start = System.nanoTime();
    }
    
    long stop() {
        stop = System.nanoTime();
        return (stop - start);
    }
}
