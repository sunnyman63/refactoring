package com.kreitek.refactor.bien.utils.services;

import com.kreitek.refactor.bien.utils.interfaces.validationService;

public class NIEvalidatorService extends validatorService implements validationService {

    private final char[] asignacionLetra = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X','B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

    private int findOutFirstLetter(String letter) {
        if(Character.isLetter(letter.charAt(0))) {
            switch (letter) {
                case "X": return 0;
                case "Y": return 1;
                case "Z": return 2;
                default: return -1;
            }
        } else {
            return -1;
        }
    }

    public boolean validate(String numDoc) {
        boolean esValido = false;
        String formattedDoc = formattedDoc(numDoc);
        String firstLetterPart = formattedDoc.substring(0,1);
        String numericPart = formattedDoc.substring(1,8);
        String lastLetterPart = formattedDoc.substring(8);
        if(hasCorrectLength(formattedDoc)) {
            int controlNum = findOutFirstLetter(firstLetterPart);
            if(controlNum != -1 && isNumeric(controlNum+numericPart)) {
                int position = getPositionInChars(controlNum+numericPart);
                esValido = (asignacionLetra[position] == lastLetterPart.charAt(0));
            }
        }
        return esValido;
    }

}