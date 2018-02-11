package ru.testing.cofeeshop.productcatalog.item;

import ru.testing.cofeeshop.domain.entity.GenericIdContainer;

public abstract class GenericFactory<T extends GenericIdContainer, E> {

    public abstract T get(E a);
}
