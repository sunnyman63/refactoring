package com.kreitek.refactor.bien.utils.factories;

import com.kreitek.refactor.bien.utils.interfaces.validationService;
import com.kreitek.refactor.bien.utils.interfaces.validationServiceFactory;
import com.kreitek.refactor.bien.utils.services.NIEvalidatorService;

public class NIEvalidatorFactory implements validationServiceFactory {

    public validationService getService() {
        return new NIEvalidatorService();
    }

}
