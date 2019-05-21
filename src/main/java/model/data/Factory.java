package model.data;

public class Factory {
    public <T, K> K generateIssue(Generator<T> generator, String name){
        return (K) generator.generate(name);
    }
}
