package org.academiadecodigo.bootcamp;

@FunctionalInterface
public interface BiOperation<T> {

    T transform (T a, T b);
}
