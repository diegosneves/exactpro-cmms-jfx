package org.diegosneves.exactprocmmsjfx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.diegosneves.exactprocmmsjfx.util.FxmlPathUtils;

import java.net.URL;
import java.util.ResourceBundle;

public class SideMenu implements Initializable {

    @FXML
    public ImageView ivCompanyLogo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.ivCompanyLogo.setImage(new Image(String.valueOf(this.getClass().getResource(FxmlPathUtils.imagesPathBuilder("exatidao_logo")))));

    }

}
