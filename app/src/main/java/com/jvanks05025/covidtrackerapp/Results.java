package com.jvanks05025.covidtrackerapp;

import com.google.gson.annotations.SerializedName;

public class Results {
    @SerializedName("name")
    private String superName;

    public Results(String superName) {
        this.superName = superName;
    }

    public String getSuperName() {
        return superName;
    }
}
