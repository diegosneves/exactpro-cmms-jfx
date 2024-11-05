package org.diegosneves.exactprocmmsjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.diegosneves.exactprocmmsjfx.util.FxmlLoaderUtils;

import java.io.IOException;

public class ExactProApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = FxmlLoaderUtils.loadFxml("hello-view");
        Scene scene = new Scene(fxmlLoader.load(), 520, 340);
        stage.setTitle("ExactPro CMMS");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}