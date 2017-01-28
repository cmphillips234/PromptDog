/**
 *
 * @author wfbar
 */
package test.win;



public class NanoTestTimer {
    long start;
    long stop;
    
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
