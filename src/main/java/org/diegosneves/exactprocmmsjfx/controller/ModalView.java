package org.diegosneves.exactprocmmsjfx.controller;

import javafx.fxml.Initializable;

public interface ModalView<T> extends Initializable {

    void setData(T data);

}
