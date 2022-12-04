package pl.sda.hibernate.fakturownia.komendy;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Firma;
import pl.sda.hibernate.fakturownia.model.Kontrahent;

public class KomendaDodajKontrahenta implements Komenda {

    private DataAccessObject<Kontrahent> dao = new DataAccessObject<Kontrahent>();

    @Override
    public String getKomenda() {
        return "dodaj kontrahenta";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj nazwe");
        String nazwa = Komenda.scanner.nextLine();
        System.out.println("Podaj nip");
        String nip  = Komenda.scanner.nextLine();
        System.out.println("Podaj adres");
        String adres = Komenda.scanner.nextLine();

        Kontrahent kontrahent = Kontrahent.builder()
                .adres(adres)
                .nazwa(nazwa)
                .nip(nip)
                .build();

        dao.insert(kontrahent);

    }
}
