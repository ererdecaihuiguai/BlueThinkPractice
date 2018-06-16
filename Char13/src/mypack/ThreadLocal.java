package mypack;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//可以用来存放线程的局部变量
public class ThreadLocal<T> {

    private Map<Runnable, T> values = Collections.synchronizedMap(new HashMap<Runnable, T>());

    public T get() {
        Thread currentThread = Thread.currentThread();
        T value = values.get(currentThread);
        if (value == null && !values.containsKey(currentThread)) {
            value = initialValue();
        }
        return value;
    }

    public void set(T newValue) {
        values.put(Thread.currentThread(), newValue);
    }

    protected T initialValue() {
        return null;
    }

}
