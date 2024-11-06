package org.diegosneves.exactprocmmsjfx;

import javafx.application.Application;
import javafx.stage.Stage;
import org.diegosneves.exactprocmmsjfx.view.ModelSingleton;

import java.io.IOException;

public class ExactProApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ModelSingleton.getInstance().getViewFactory().showApp();
    }

    public static void main(String[] args) {
        launch();
    }
}