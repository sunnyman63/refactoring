package com.kreitek.refactor.bien.domain;

import com.kreitek.refactor.bien.domain.TIPODOC;
import com.kreitek.refactor.bien.utils.interfaces.validationService;

import java.util.Date;

public class NIE extends Documento{

    public NIE(String numDoc, Date fchValidez) {
        super.setTipo(TIPODOC.NIE);
        super.setNumDoc(numDoc);
        super.setFchValidez(fchValidez);
    }

    public boolean isValid() {
        validationService validationService = this.getService();
        return validationService.validate(this.getNumDoc());
    }

}
