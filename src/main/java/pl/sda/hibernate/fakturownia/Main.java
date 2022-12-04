package pl.sda.hibernate.fakturownia;

import pl.sda.hibernate.fakturownia.komendy.Komenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Komenda> listaKomend = new ArrayList<>(
                List.of(

                )
        );

        System.out.println("Lista dostepnych komend:");
        listaKomend.forEach(komenda -> System.out.println(komenda.getKomenda()));
        System.out.println("Podaj komende:");
        String komenda = Komenda.scanner.nextLine();

        for (Komenda dostepnaKomenda : listaKomend) {
            if (dostepnaKomenda.getKomenda().equalsIgnoreCase(komenda)) {
                dostepnaKomenda.obsluga();
            }
        }


    }
}
