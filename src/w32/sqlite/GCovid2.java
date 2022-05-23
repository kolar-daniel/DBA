package w32.sqlite;

import javafx.beans.property.*;

public class GCovid2 {
    private final StringProperty datum =
            new SimpleStringProperty(this, "datum", null);
    private final IntegerProperty prumernyVek =
            new SimpleIntegerProperty(this, "prumernyVek");
    private final IntegerProperty pocetMuzu =
            new SimpleIntegerProperty(this, "pocetMuzu");
    private final IntegerProperty pocetZen =
            new SimpleIntegerProperty(this, "pocetZen");
    private final IntegerProperty celkovyPocet =
            new SimpleIntegerProperty(this, "celkovyPocet");


    public String getDatum() {
        return datum.get();
    }

    public StringProperty datumProperty() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum.set(datum);
    }

    public int getPrumernyVek() {
        return prumernyVek.get();
    }

    public IntegerProperty prumernyVekProperty() {
        return prumernyVek;
    }

    public void setPrumernyVek(int prumernyVek) {
        this.prumernyVek.set(prumernyVek);
    }

    public int getPocetMuzu() {
        return pocetMuzu.get();
    }

    public IntegerProperty pocetMuzuProperty() {
        return pocetMuzu;
    }

    public void setPocetMuzu(int pocetMuzu) {
        this.pocetMuzu.set(pocetMuzu);
    }

    public int getPocetZen() {
        return pocetZen.get();
    }

    public IntegerProperty pocetZenProperty() {
        return pocetZen;
    }

    public void setPocetZen(int pocetZen) {
        this.pocetZen.set(pocetZen);
    }

    public int getCelkovyPocet() {
        return celkovyPocet.get();
    }

    public IntegerProperty celkovyPocetProperty() {
        return celkovyPocet;
    }

    public void setCelkovyPocet(int celkovyPocet) {
        this.celkovyPocet.set(celkovyPocet);
    }

    public GCovid2(String datum, int prumernyVek, int pocetMuzu, int pocetZen, int celkovyPocet) {
        this.datum.set(datum);
        this.prumernyVek.set(prumernyVek);
        this.pocetMuzu.set(pocetMuzu);
        this.pocetZen.set(pocetZen);
        this.celkovyPocet.set(celkovyPocet);
    }
}
