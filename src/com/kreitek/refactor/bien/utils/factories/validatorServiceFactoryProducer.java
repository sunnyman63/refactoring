package com.kreitek.refactor.bien.utils.factories;

import com.kreitek.refactor.bien.domain.TIPODOC;
import com.kreitek.refactor.bien.utils.interfaces.validationServiceFactory;

public class validatorServiceFactoryProducer {

    private validationServiceFactory validationServiceFactory;

    public validationServiceFactory getFactory(TIPODOC tipo) {

        switch(tipo) {
            case DNI:
                this.validationServiceFactory = new DNIvalidatorFactory();
                break;
            case NIE:
                this.validationServiceFactory = new NIEvalidatorFactory();
                break;
            case CIF:
                this.validationServiceFactory = new CIFvalidatorFactory();
                break;
        }
        return this.validationServiceFactory;
    }

}
