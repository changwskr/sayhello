package com.eplaton.xyz.util;

/**
 * 시간 체크용 클래스
 * 
 * @author djsong
 * @version 1.0
 * @see
 *  
 */
public class StopWatch {

    long start;

    long current;

    public StopWatch() {
        start = 0L;
        current = 0L;
        reset();
    }

    /**
     * stopwatch 시작시간을 현재시간으로 리셋한다.
     */
    public void reset() {
        start = System.currentTimeMillis();
        current = start;
    }

    /**
     * current부터 현재까지 경과한 시간을 반환한다. <br>
     * current는 현재시간으로 다시 셋팅된다.
     * 
     * @return
     */
    public long getElapsed() {
        long l = System.currentTimeMillis();
        long l1 = l - current;
        current = l;
        return l1;
    }

    /**
     * start부터 현재까지 경과한 시간을 반환한다.
     * 
     * @return
     */
    public long getTotalElapsed() {
        return System.currentTimeMillis() - start;
    }
}
