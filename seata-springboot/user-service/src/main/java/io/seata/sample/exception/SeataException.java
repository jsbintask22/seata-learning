package io.seata.sample.exception;

/**
 * @author jsbintask@gmail.com
 * @date 2019/8/16 15:27
 */
public class SeataException extends RuntimeException {
    public SeataException(String msg) {
        super(msg);
    }
}
