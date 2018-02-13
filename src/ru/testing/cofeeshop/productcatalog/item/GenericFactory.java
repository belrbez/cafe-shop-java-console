package ru.testing.cofeeshop.productcatalog.item;

import ru.testing.cofeeshop.domain.entity.GenericIdContainer;

/**
 * The type Generic factory.
 *
 * @param <T> the type parameter
 * @param <E> the type parameter
 * @author Alexander Vasiliev <alexandrvasilievby@gmail.com>
 */
public abstract class GenericFactory<T extends GenericIdContainer, E> {

    /**
     * Get t.
     *
     * @param a the a
     * @return the t
     */
    public abstract T get(E a);
}
