package com.kreitek.refactor.bien.utils.services;

import com.kreitek.refactor.bien.domain.TIPOULTCHAR;
import com.kreitek.refactor.bien.utils.interfaces.validationService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CIFvalidatorService extends validatorService implements validationService {

    private char primerCar;
    private char ultimoCar;
    private String digitos;

    private boolean isWellFormatted(String nomDoc) {
        final Pattern mask = Pattern
                .compile("[ABCDEFGHJKLMNPQRSUVW][0-9]{7}[A-Z[0-9]]{1}");
        final Matcher matcher = mask.matcher(nomDoc);
        if (!matcher.matches()) {
            return false;
        } else {
            return true;
        }
    }

    private TIPOULTCHAR getLastCharType(char firstLetter) {
        String fstLetter = String.valueOf(firstLetter);
        if(("PQSKW").contains(fstLetter)) {
            return TIPOULTCHAR.LETRA;
        } else if(("ABEH").contains(fstLetter)) {
            return TIPOULTCHAR.NUMERO;
        } else {
            return TIPOULTCHAR.AMBOS;
        }
    }

    private int getAdditionOfEvens(String digits) {
        int sumaPares = 0;
        for (int i = 1; i <= digits.length() - 1; i = i + 2) {
            sumaPares += Integer.parseInt(digits.substring(i, i + 1));
        }
        return sumaPares;
    }

    private int getAdditionOfOdds(String digits) {
        int sumaImpares = 0;
        for (int i = 0; i <= digits.length() - 1; i = i + 2) {
            Integer cal = Integer.parseInt(digits.substring(i, i + 1)) * 2;
            if (cal.toString().length() > 1) {
                cal = Integer.parseInt(cal.toString().substring(0, 1))
                        + Integer.parseInt(cal.toString().substring(1, 2));
            }
            sumaImpares += cal;
        }
        return sumaImpares;
    }

    private boolean numTypeVerifications(int pos) {
        if (!(ultimoCar >= '0' && ultimoCar <= '9')) {
            return false;
        }
        if (pos != Integer.parseInt(Character.toString(ultimoCar))) {
            return false;
        }
        return true;
    }

    private boolean letterTypeVerifications(int carControl) {
        if (!(this.ultimoCar >= 'A' && this.ultimoCar <= 'Z')) {
            return false;
        }
        if (carControl != this.ultimoCar) {
            return false;
        }
        return true;
    }

    private boolean bothTypeVerifications(int pos, int carControl) {
        int ultCar = "JABCDEFGHI".indexOf(this.ultimoCar);
        if (ultCar < 0){
            ultCar = Integer.parseInt(Character.toString(this.ultimoCar));
            return pos == (int) ultCar;
        }
        if ((pos != (int) ultCar) && (carControl != this.ultimoCar)) {
            return false; // NOK
        }
        return true;
    }

    public boolean validate(String numDoc) {
        String formattedDoc = formattedDoc(numDoc);
        if (hasCorrectLength(formattedDoc) && isWellFormatted(formattedDoc)) {
            this.primerCar = formattedDoc.charAt(0);
            this.ultimoCar = formattedDoc.charAt(8);
            this.digitos = formattedDoc.substring(1, formattedDoc.length() - 1);
            TIPOULTCHAR tipUltCar = getLastCharType(primerCar);
            final int total = getAdditionOfEvens(digitos) + getAdditionOfOdds(digitos);
            int numControl = 10 - (total % 10);
            int pos = numControl == 10? 0:numControl;
            char carControl = "JABCDEFGHI".charAt(pos);
            if (tipUltCar == TIPOULTCHAR.NUMERO) {
                return numTypeVerifications(pos);
            } else if (tipUltCar == TIPOULTCHAR.LETRA) {
                return letterTypeVerifications(carControl);
            } else {
                return bothTypeVerifications(pos,carControl);
            }
        }
        return false;
    }
}
