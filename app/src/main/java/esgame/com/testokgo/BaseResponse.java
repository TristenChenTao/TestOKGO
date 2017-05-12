package esgame.com.testokgo;

import java.io.Serializable;

/**
 * Created by TristenChenTao on 08/05/2017.
 */

public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 5213230387175987834L;

    public int ResultCode;
    public String ResultMessage;
    public T Data;
}
