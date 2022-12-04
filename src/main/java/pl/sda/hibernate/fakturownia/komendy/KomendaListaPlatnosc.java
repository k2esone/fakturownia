package pl.sda.hibernate.fakturownia.komendy;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Firma;
import pl.sda.hibernate.fakturownia.model.Platnosc;

import java.util.List;

public class KomendaListaPlatnosc implements Komenda {
    private DataAccessObject<Platnosc> dataAccessObject;

    public KomendaListaPlatnosc() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista platnosci";
    }

    @Override
    public void obsluga() {
        List<Platnosc> platnosci = dataAccessObject.findAll(Platnosc.class);
        platnosci.forEach(System.out::println);
    }
}
