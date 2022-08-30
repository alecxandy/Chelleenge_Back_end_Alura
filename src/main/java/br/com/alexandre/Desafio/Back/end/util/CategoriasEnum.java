package br.com.alexandre.Desafio.Back.end.util;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public enum CategoriasEnum {

    ALIMENTACAO,
    SAUDE,
    MORADIA,
    TRANSPORTE,
    EDUCACAO,
    LAZER,
    IMPREVISTO,
    OUTRAS;

    /*
    private int code;

   //construtor
    CategoriasEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    //metodo que verifica se existe uma categoria para o cogigo informado
    public static CategoriasEnum valueOf(int code) {
        for (CategoriasEnum valueEnumCategoria : CategoriasEnum.values()) {
            if (code == valueEnumCategoria.getCode()) {
                return valueEnumCategoria;
            }
        }
        throw new IllegalArgumentException("Invalid code");
    }
    */

}
