package com.kreitek.refactor.bien.utils.services;

public abstract class validatorService {

    protected String formattedDoc(String numDoc) {
        return numDoc.trim().replaceAll(" ", "").toUpperCase();
    }

    protected static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    protected boolean hasCorrectLength(String numDoc) {
        return numDoc.length() == 9;
    }

    protected int getPositionInChars(String numericPart) {
        return Integer.parseInt(numericPart) % 23;
    }

}
