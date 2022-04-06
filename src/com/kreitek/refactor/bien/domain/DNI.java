package com.kreitek.refactor.bien.domain;

import com.kreitek.refactor.bien.domain.TIPODOC;
import com.kreitek.refactor.bien.utils.interfaces.validationService;

import java.util.Date;

public class DNI extends Documento{

    public DNI(String numDoc, Date fchValidez) {
        super.setTipo(TIPODOC.DNI);
        super.setNumDoc(numDoc);
        super.setFchValidez(fchValidez);
    }

    public boolean isValid() {
        validationService validationService = this.getService();
        return validationService.validate(this.getNumDoc());
    }

}
