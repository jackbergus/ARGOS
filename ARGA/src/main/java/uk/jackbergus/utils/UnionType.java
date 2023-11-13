package uk.jackbergus.utils;

public class UnionType<T1,T2> {

    private T1 t1;
    private T2 t2;

    private boolean mancinism;

    private UnionType() {
        t1 = null;
        t2 = null;
        mancinism = false;
    }

    public static <T1,T2> UnionType<T1,T2> generateLeft(T1 value) {
        var obj = new UnionType<T1,T2>();
        obj.t1 = value;
        obj.t2 = null;
        obj.mancinism = true;
        return obj;
    }

    public static <T1,T2> UnionType<T1,T2> generateRight(T2 value) {
        var obj = new UnionType<T1,T2>();
        obj.t1 = null;
        obj.t2 = value;
        obj.mancinism = false;
        return obj;
    }

    public boolean isLeft() {
        return mancinism;
    }

    public T1 getLeft() {
        return t1;
    }

    public T2 getRight() {
        return t2;
    }

    @Override
    public String toString() {
        return (isLeft() ? "L[" : "R[") + (isLeft() ? t1.toString() : t2.toString()) +"]";
    }

}
