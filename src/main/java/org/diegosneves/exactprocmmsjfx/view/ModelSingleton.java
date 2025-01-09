package org.diegosneves.exactprocmmsjfx.view;

import lombok.Getter;

@Getter
public class ModelSingleton {

    private static final Object CLASS_LOCK = ModelSingleton.class;

    private static volatile ModelSingleton instance;
    private final ViewFactory viewFactory;

    private ModelSingleton() {
        this.viewFactory = new ViewFactory();
    }

    public static ModelSingleton getInstance() {
        if (instance == null) {
            synchronized (CLASS_LOCK) {
                if (instance == null) {
                    instance = new ModelSingleton();
                }
            }
        }
        return instance;
    }

}
