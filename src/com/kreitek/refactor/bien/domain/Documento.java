package com.kreitek.refactor.bien.domain;

import com.kreitek.refactor.bien.utils.factories.validatorServiceFactoryProducer;
import com.kreitek.refactor.bien.utils.interfaces.*;

import java.util.Date;

public abstract class Documento {

    private TIPODOC tipo;
    private String numDoc;
    private Date fchValidez;

    protected validationService getService() {
        validatorServiceFactoryProducer validationServiceProducer = new validatorServiceFactoryProducer();
        validationServiceFactory factory = validationServiceProducer.getFactory(this.tipo);
        validationService validationService = factory.getService();
        return validationService;
    }

    public TIPODOC getTipo() {
        return this.tipo;
    }

    public void setTipo(TIPODOC tipo) {
        this.tipo = tipo;
    }

    public String getNumDoc() {
        return this.numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public Date getFchValidez() {
        return this.fchValidez;
    }

    public void setFchValidez(Date fchValidez) {
        this.fchValidez = fchValidez;
    }

    public abstract boolean isValid();
}
