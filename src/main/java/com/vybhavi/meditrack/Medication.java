package com.vybhavi.meditrack;

public class Medication {
    private final String name;
    private final String dosage;
    private final String time;

    public Medication(String name, String dosage, String time) {
        this.name = name;
        this.dosage = dosage;
        this.time = time;
    }

    public String getName() { return name; }
    public String getDosage() { return dosage; }
    public String getTime() { return time; }
}
