
package com.zjs.exception;

/**
 * 消费MQ时需要一段时间之后重新消费的异常
 */
public class LaterDealBusinessException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7829074534417330089L;
	public LaterDealBusinessException() {
        super();
    }
    public LaterDealBusinessException(String message) {
        super(message);
    }
    public LaterDealBusinessException(Throwable cause) {
        super(cause);
    }
    public LaterDealBusinessException(String message, Throwable cause) {
        super(message, cause);
    }
    public LaterDealBusinessException(Enum<?> code, Object... parms) {
        super(assembleMessage(code,parms));
    }
    public LaterDealBusinessException(Enum<?> code, Throwable cause, Object... parms) {
        super(assembleMessage(code,parms),cause);
    }
    public static String assembleMessage(Enum<?> code,Object ...parms) {
        StringBuilder sb = new StringBuilder();
        sb.append(code.toString()).append(",");

        for (Object obj : parms) {
            sb.append(obj.toString()).append(" ");
        }
        return sb.toString();
    }
}
