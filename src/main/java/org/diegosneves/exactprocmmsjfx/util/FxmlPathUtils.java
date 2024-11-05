package org.diegosneves.exactprocmmsjfx.util;

public class FxmlPathUtils {

    public static final String ROOT_PATH = "/org/diegosneves/exactprocmmsjfx";
    private static final String PATH_SEPARATOR = "/";
    private static final String FXML_EXTENSION = ".fxml";
    private static final String PNG_EXTENSION = ".png";

    private static final String CONTROLLER_PATH = "controller";
    private static final String IMAGES_PATH = "images";

    private FxmlPathUtils() {}

    public static String controllerPath(String... fileNames) {
        StringBuilder path = constructPath(CONTROLLER_PATH);
        return generatePath(path, FXML_EXTENSION, fileNames);
    }

    private static String generatePath(StringBuilder sb, String extension, String... path) {
        for (String s : path) {
            sb.append(PATH_SEPARATOR).append(s);
        }
        sb.append(extension);
        return sb.toString();
    }

    public static String imagesPathBuilder(String... path) {
        StringBuilder sb = constructPath(IMAGES_PATH);
        return generatePath(sb, PNG_EXTENSION, path);
    }

    private static StringBuilder constructPath(String... directoryNames) {
        StringBuilder sb = new StringBuilder(ROOT_PATH);
        for (String s : directoryNames) {
            sb.append(PATH_SEPARATOR).append(s);
        }
        return sb;
    }

}
