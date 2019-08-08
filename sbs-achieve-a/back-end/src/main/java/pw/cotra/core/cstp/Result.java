package pw.cotra.core.cstp;

public class Result {

    // 生成方法
    public static final <T> Cstp<T> create(boolean ok, T data, String reason) {
        Cstp<T> result = new Cstp<>(ok, data, reason);
        return result;
    }

    // 成功返回,无数据
    public static final <T> Cstp<T> ok() {
        Cstp<T> result = create(true, null, null);
        return result;
    }

    // 成功返回,有数据
    public static final <T> Cstp<T> ok(T data) {
        Cstp<T> result = create(true, data, null);
        return result;
    }

    // 失败返回,无原因
    public static final <T> Cstp<T> fail() {
        Cstp<T> result = create(false, null, null);
        return result;
    }

    // 失败返回,有原因
    public static final <T> Cstp<T> fail(String reason) {
        Cstp<T> result = create(false, null, reason);
        return result;
    }
}
