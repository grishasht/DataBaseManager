package model.data;

public interface Generator<T> {
    T generate(String name);
}
