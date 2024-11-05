package org.diegosneves.exactprocmmsjfx.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.diegosneves.exactprocmmsjfx.controller.ModalView;
import org.diegosneves.exactprocmmsjfx.util.FxmlLoaderUtils;
import org.diegosneves.exactprocmmsjfx.util.FxmlPathUtils;

import java.io.IOException;

@Slf4j
public class ViewFactory {

    private static final String APP_NAME = "ExactPro CMMS";

    private Stage primaryStage;
    private AnchorPane addressSearchView;


    private void createStage(FXMLLoader loader, Boolean isPrimaryStage) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            log.error(String.format("Fail: %s.createStage(Params...) -> [%s]", ViewFactory.class.getSimpleName(), e.getMessage()), e);
        }

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(loadPdfIcon());
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setTitle(APP_NAME);
        if (Boolean.TRUE.equals(isPrimaryStage)) {
            this.primaryStage = stage;
        }
        stage.show();
    }


    private Image loadPdfIcon() {
        return new Image(String.valueOf(this.getClass().getResource(FxmlPathUtils.imagesPathBuilder("chain-icon72"))));
    }

    public <T> void showMessagePane(String fxmlPath, ModalView<T> modal, String title) {
        FXMLLoader loader = FxmlLoaderUtils.loadFxml(fxmlPath);
        loader.setController(modal);

        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            log.error(String.format("Fail: %s.showMessagePane(Params...) -> [%s]", ViewFactory.class.getSimpleName(), e.getMessage()), e);
        }

        Stage stage = new Stage();
        stage.getIcons().add(loadPdfIcon());
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setScene(scene);

        // Centralize a janela ao mostrar
        stage.setOnShown(event -> {
            if (primaryStage != null) {
                stage.setX(primaryStage.getX() + (primaryStage.getWidth() - stage.getWidth()) / 2);
                stage.setY(primaryStage.getY() + (primaryStage.getHeight() - stage.getHeight()) / 2);
            }
        });

        stage.show();

    }

    public void showApp() {
        FXMLLoader fxmlLoader = FxmlLoaderUtils.loadFxml("ConectarView");
        createStage(fxmlLoader, Boolean.TRUE);
    }

    public AnchorPane showAddressSearchView() {
        if (this.addressSearchView == null) {
            try {
                this.addressSearchView = FxmlLoaderUtils.loadFxml("EnderecoView").load();
            } catch (IOException e) {
                log.error(String.format("Fail: %s.showAddressSearchView() -> [%s]", ViewFactory.class.getSimpleName(), e.getMessage()), e);
            }
        }
        return this.addressSearchView;
    }
}
