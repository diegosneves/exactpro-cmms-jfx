module org.diegosneves.exactprocmmsjfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires static lombok;
    requires org.slf4j;
    requires spring.web;
    requires spring.beans;
    requires spring.context;
    requires com.fasterxml.jackson.annotation;


    opens org.diegosneves.exactprocmmsjfx to javafx.fxml;
    exports org.diegosneves.exactprocmmsjfx;
    exports org.diegosneves.exactprocmmsjfx.controller;
    opens org.diegosneves.exactprocmmsjfx.controller to javafx.fxml;
}