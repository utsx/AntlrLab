package ru.utsx.Types;

public class ValueInt implements Value<Integer> {
    private Integer value;

    public ValueInt(final Integer value){
        this.value = value;
    }

    public ValueInt(){
        this.value = null;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    public void add(ValueString st){
        throw new UnsupportedOperationException();
    }

    public void add(ValueInt a){
        this.setValue(this.getValue() + a.getValue());
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public void add(Value<Integer> a) {
        this.setValue(this.getValue() + a.getValue());
    }

    @Override
    public void sub(Value<Integer> a) {
        this.setValue(this.getValue() - a.getValue());
    }

    @Override
    public void multi(Value<Integer> a) {
        this.setValue(this.getValue() * a.getValue());
    }

    @Override
    public void dev(Value<Integer> a) {
        if(a.getValue() == 0){
            throw new RuntimeException("Division by 0 is prohibited ");
        }
        this.setValue(this.getValue() / a.getValue());
    }

    @Override
    public boolean more(Value<Integer> a) {
        return this.getValue() > a.getValue();
    }

    @Override
    public boolean less(Value<Integer> a) {
        return this.getValue() < a.getValue();
    }

    @Override
    public boolean equal(Value<Integer> a) {
        return this.getValue().equals(a.getValue());
    }

    @Override
    public boolean notEqual(Value<Integer> a) {
        return !this.getValue().equals(a.getValue());
    }

    @Override
    public boolean lessOrEqual(Value<Integer> a) {
        return this.getValue() <= a.getValue();
    }

    @Override
    public boolean moreOrEqual(Value<Integer> a) {
        return this.getValue() >= a.getValue();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
