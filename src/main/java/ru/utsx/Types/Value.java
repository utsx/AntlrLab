package ru.utsx.Types;

public interface Value<T> {
    public T getValue();
    public void setValue(T value);

    public void add(Value<T> a);

    public void sub(Value<T> a);

    public void multi(Value<T> a);

    public void dev(Value<T> a);

    public boolean more(Value<T> a);
    public boolean less(Value<T> a);
    public boolean equal(Value<T> a);

    public boolean notEqual(Value<T> a);
    public boolean lessOrEqual(Value<T> a);
    public boolean moreOrEqual(Value<T> a);


}
