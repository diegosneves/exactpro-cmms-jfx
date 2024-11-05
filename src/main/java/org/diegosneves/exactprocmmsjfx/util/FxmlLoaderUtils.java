package org.diegosneves.exactprocmmsjfx.util;

import javafx.fxml.FXMLLoader;

public class FxmlLoaderUtils {

    private FxmlLoaderUtils() {}

    public static FXMLLoader loadFxml(String fxmlPath) {
        return new FXMLLoader(FxmlLoaderUtils.class.getResource(FxmlPathUtils.controllerPath(fxmlPath)));
    }

}
