package org.academiadecodigo.bootcamp;

@FunctionalInterface
public interface MonoOperation<T> {

    T transform (T value);
}
