package models;

import java.util.ArrayList;

public class Columns {

    public int id;
    public java.util.List<Card> cards = new ArrayList<>();

    public Columns() {
    }

    public Columns(int id) {
        this.id = id;
    }
}
