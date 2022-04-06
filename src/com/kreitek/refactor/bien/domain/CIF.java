package com.kreitek.refactor.bien.domain;

import com.kreitek.refactor.bien.utils.interfaces.validationService;

import java.util.Date;

public class CIF extends Documento{

    public CIF(String numDoc, Date fchValidez) {
        super.setTipo(TIPODOC.CIF);
        super.setNumDoc(numDoc);
        super.setFchValidez(fchValidez);
    }

    public boolean isValid() {
        validationService validationService = this.getService();
        return validationService.validate(this.getNumDoc());
    }

}
