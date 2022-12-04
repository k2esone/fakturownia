package pl.sda.hibernate.fakturownia.komendy;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Firma;

public class KomendaDodajFirme implements Komenda {

    private DataAccessObject<Firma> dao = new DataAccessObject<Firma>();

    @Override
    public String getKomenda() {
        return "dodaj firme";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj nazwa");
        String nazwa = Komenda.scanner.nextLine();
        System.out.println("Podaj nip");
        String nip = Komenda.scanner.nextLine();
        System.out.println("Podaj adres");
        String adres = Komenda.scanner.nextLine();

        Firma firma = Firma.builder()
                .adres(adres)
                .nazwa(nazwa)
                .nip(nip)
                .build();

        dao.insert(firma);

    }
}
