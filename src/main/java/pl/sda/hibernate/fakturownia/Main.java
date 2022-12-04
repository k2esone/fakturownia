package pl.sda.hibernate.fakturownia;

import pl.sda.hibernate.fakturownia.komendy.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Komenda> listaKomend = new ArrayList<>(
                List.of(
                        new KomendaDodajFirme(),
                        new KomendaDodajKontrahenta(),
                        new KomendaDodajPlatnosc(),
                        new KomendaDodajFaktura(),
                        new KomendaListaFirma(),
                        new KomendaListaKontrahent(),
                        new KomendaListaPlatnosc(),
                        new KomendaListaFaktura(),
                        new KomendaUsunFirma(),
                        new KomendaUsunKontrahent(),
                        new KomendaUsunPlatnosc(),
                        new KomendaUsunFaktura()

                )
        );
        String komenda;
        do {
            System.out.println("Lista dostepnych komend:");
            for (int i = 0; i < listaKomend.size(); i++) {
                // wiersz po wierszu wypisza sie komendy w formie:
                // 1. dodaj x
                // 2. dodaj y...

                System.out.println((i + 1) + ". " + listaKomend.get(i).getKomenda());
            }
            System.out.println("Podaj komende:");
            komenda = Komenda.scanner.nextLine();

            for (Komenda dostepnaKomenda : listaKomend) {
                if (dostepnaKomenda.getKomenda().equalsIgnoreCase(komenda)) {
                    dostepnaKomenda.obsluga();
                }
            }
        } while (!komenda.equalsIgnoreCase("exit"));
    }
}
