package pl.sda.hibernate.fakturownia.komendy;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.FormaPlatnosci;
import pl.sda.hibernate.fakturownia.model.Kontrahent;
import pl.sda.hibernate.fakturownia.model.Platnosc;

public class KomendaDodajPlatnosc implements Komenda {

    private DataAccessObject<Platnosc> dao = new DataAccessObject<Platnosc>();

    @Override
    public String getKomenda() {
        return "dodaj platnosc";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj kwote");
        String kwotaString = Komenda.scanner.nextLine();
        Double kwota = Double.parseDouble(kwotaString);

        System.out.println("Podaj forme");
        String formaString = Komenda.scanner.nextLine();
        FormaPlatnosci forma = FormaPlatnosci.valueOf(formaString);

        Platnosc platnosc = Platnosc.builder()
                .kwota(kwota)
                .forma(forma)
                .build();

        dao.insert(platnosc);

    }
}
