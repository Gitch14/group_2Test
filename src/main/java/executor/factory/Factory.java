package executor.factory;

public interface Factory {

    <T> T getInstance(Class<T> clazz);

}
