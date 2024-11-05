package org.diegosneves.exactprocmmsjfx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Endereco {

    private StringProperty rua;
    private StringProperty bairro;
    private StringProperty cidade;
    private StringProperty estado;
    private StringProperty cep;

    public Endereco(String rua, String bairro, String cidade, String estado, String cep) {
        this.rua = new SimpleStringProperty(this, "rua", rua);
        this.bairro = new SimpleStringProperty(this, "bairro", bairro);
        this.cidade = new SimpleStringProperty(this, "cidade", cidade);
        this.estado = new SimpleStringProperty(this, "estado", estado);
        this.cep = new SimpleStringProperty(this, "cep", cep);
    }

    public String getRua() {
        return rua.get();
    }

    public StringProperty ruaProperty() {
        return rua;
    }

    public String getBairro() {
        return bairro.get();
    }

    public StringProperty bairroProperty() {
        return bairro;
    }

    public String getCidade() {
        return cidade.get();
    }

    public StringProperty cidadeProperty() {
        return cidade;
    }

    public String getEstado() {
        return estado.get();
    }

    public StringProperty estadoProperty() {
        return estado;
    }

    public String getCep() {
        return cep.get();
    }

    public StringProperty cepProperty() {
        return cep;
    }
}
