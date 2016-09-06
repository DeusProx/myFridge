package de.rwth.i9.examples.myFridge.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Singleton Pattern to just have one EntityManagerFactory
 * Created by deusprox on 06.09.16.
 */
public class JPAHelper {
    private static final String PERSISTENCE_UNIT_NAME = "myFridge";
    private static EntityManagerFactory entityManagerFactory = null;

    /**
     * Empty - no instantiation
     */
    private JPAHelper() { }

    /**
     * static initializer - create EntityManagerFactory
     */
    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        } catch (Throwable ex) {
            //logger.error("Initial SessionFactory creation failed", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Returns the EntityManagerFactory
     *
     * @return the EntityManagerFactory
     */
    public static EntityManagerFactory getInstance() {
        return entityManagerFactory;
    }
}
