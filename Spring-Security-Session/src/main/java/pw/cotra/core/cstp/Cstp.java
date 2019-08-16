package pw.cotra.core.cstp;

import java.io.Serializable;

public class Cstp<T> implements Serializable {
    private boolean ok;
    private T data;
    private String reason;

    public Cstp(boolean ok, T data, String reason) {
        this.ok = ok;
        this.data = data;
        this.reason = reason;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
