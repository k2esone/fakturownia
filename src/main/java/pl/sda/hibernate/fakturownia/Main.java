package pl.sda.hibernate.fakturownia;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.komendy.Komenda;
import pl.sda.hibernate.fakturownia.model.Firma;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//
        new DataAccessObject<Firma>().findAll(Firma.class);


    }
}
