package org.diegosneves.exactprocmmsjfx.view;


public class ModelSingleton {

    private static ModelSingleton instance;
    private final ViewFactory viewFactory;

    private ModelSingleton() {
        this.viewFactory = new ViewFactory();
    }

    public static ModelSingleton getInstance() {
        if (instance == null) {
            synchronized (ModelSingleton.class) {
                if (instance == null) {
                    instance = new ModelSingleton();
                }
            }
        }
        return instance;
    }

    public ViewFactory getViewFactory() {
        return this.viewFactory;
    }

}
