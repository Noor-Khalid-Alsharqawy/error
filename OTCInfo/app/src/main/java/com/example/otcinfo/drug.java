package com.example.otcinfo;
import java.io.Serializable;
import java.util.*;

public class drug implements Serializable {
    private String tradeName;
    private String activeIngredients;
    private String uses;
    private String age;
    private String sideEffects;
    private String interactions;
    private String contraindications;
    private char pregnancySafety;
    private String application;
    private String notes;

    public drug(String tradeName, String activeIngredients, String uses, String age,
                String sideEffects, String interactions, String contraindications,
                char pregnancySafety, String application, String notes) {
        this.tradeName = tradeName;
        this.activeIngredients = activeIngredients;
        this.uses = uses;
        this.age = age;
        this.sideEffects = sideEffects;
        this.interactions = interactions;
        this.contraindications = contraindications;
        this.pregnancySafety = pregnancySafety;
        this.application = application;
        this.notes = notes;
    }

    public drug() {
        //empty the body if it doesn't work
        this.tradeName = null;
        this.activeIngredients = null;
        this.uses = null;
        this.age = null;
        this.sideEffects = null;
        this.interactions = null;
        this.contraindications = null;
        this.pregnancySafety = '\u0000';
        this.application = null;
        this.notes = null;
    }

    //trade name methods
    public String getTradeName() { return tradeName; }
    public void setTradeName(String tradeName) { this.tradeName = tradeName; }

    //active ingredients methods
    public String getActiveIngredients() { return activeIngredients; }
    public void setActiveIngredients(String activeIngredients) { this.activeIngredients = activeIngredients; }

    //uses methods
    public String getUses() { return uses; }
    public void setUses(String uses) { this.uses = uses; }

    //age methods
    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }

    //side effects methods
    public String getSideEffects() { return sideEffects; }
    public void setSideEffects(String sideEffects) { this.sideEffects = sideEffects; }

    //interactions methods
    public String getInteractions() { return interactions; }
    public void setInteractions(String interactions) { this.interactions = interactions; }

    //contraindications methods
    public String getContraindications() { return contraindications; }
    public void setContraindications(String contraindications) { this.contraindications = contraindications; }

    //pregnancy safety methods
    public char getPregnancySafety() { return pregnancySafety; }
    public void setPregnancySafety(char pregnancySafety) { this.pregnancySafety = pregnancySafety; }

    //application methods
    public String getApplication() { return application; }
    public void setApplication(String application) { this.application = application; }

    //notes methods
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
