package ru.utsx.Types;

public class ValueString implements Value<String>{

    private String value;

    public ValueString(String value) {
        this.value = value.substring(1, value.length() - 1);
    }

    public ValueString(){
        this.value = null;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void add(Value<String> a) {
        this.setValue(this.getValue() + a.getValue());
    }

    @Override
    public void sub(Value<String> a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void multi(Value<String> a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void dev(Value<String> a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean more(Value<String> a) {
        return this.getValue().compareTo(a.getValue()) < 0;
    }

    @Override
    public boolean less(Value<String> a) {
        return this.getValue().compareTo(a.getValue()) > 0;
    }

    @Override
    public boolean equal(Value<String> a) {
        return this.getValue().equals(a.getValue());
    }

    @Override
    public boolean notEqual(Value<String> a) {
        return !this.getValue().equals(a.getValue());
    }

    @Override
    public boolean lessOrEqual(Value<String> a) {
        return this.getValue().compareTo(a.getValue()) >= 0;
    }

    @Override
    public boolean moreOrEqual(Value<String> a) {
        return this.getValue().compareTo(a.getValue()) <= 0;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }
}
