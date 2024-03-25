package com.example.customqueries2.entity;

import java.util.Random;

public enum StatusEnum {

    ON_TIME ("On time"),

    DELAYED ("Delayed"),

    CANCELLED ("Cancelled");

    private final String descriptionStatus;

    private static final Random prng = new Random();

    //il metodo values() crea una copia dei valori enum
    private static final StatusEnum[] status = values();

    StatusEnum(String descriptionStatus) {
        this.descriptionStatus = descriptionStatus;
    }

    public String getDescriptionStatus() {
        return descriptionStatus;
    }

    public static StatusEnum randomStatus() {
        //Il metodo nextInt() restituisce un numero casuale per accedere all'array degli stati
        return status[prng.nextInt(status.length)];
    }

}
