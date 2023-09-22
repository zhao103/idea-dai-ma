package cn.poi.easy;

import lombok.Data;

@Data
public class Mistake<T> {
    private T t;
    private String arr;

    public Mistake() {
    }

    public Mistake(T t, String arr) {
        this.t = t;
        this.arr = arr;
    }
}
