package com.kreitek.refactor.bien.utils.services;

import com.kreitek.refactor.bien.utils.interfaces.validationService;

public class DNIvalidatorService extends validatorService implements validationService {

    private String dniChars="TRWAGMYFPDXBNJZSQVHLCKE";

    public boolean validate(String numDoc) {
        String formattedNumDoc = formattedDoc(numDoc);
        String numericPart = formattedNumDoc.substring(0, 8);
        char letterPart = formattedNumDoc.charAt(8);
        if(hasCorrectLength(formattedNumDoc) && isNumeric(numericPart)) {
            int valNumDni = getPositionInChars(numericPart);
            boolean isInDNIchars = this.dniChars.contains(String.valueOf(letterPart));
            if (Character.isLetter(letterPart) && !isInDNIchars) {
                    return false;
            } else {
                return String.valueOf(dniChars.charAt(valNumDni)).equals(String.valueOf(letterPart));
            }
        } else {
            return false;
        }
    }
}
