package pl.sda.hibernate.fakturownia.komendy;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Firma;
import pl.sda.hibernate.fakturownia.model.Kontrahent;

import java.util.List;

public class KomendaListaKontrahent implements Komenda {
    private DataAccessObject<Kontrahent> dataAccessObject;

    public KomendaListaKontrahent() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista kontrahent";
    }

    @Override
    public void obsluga() {
        List<Kontrahent> kontrahenci = dataAccessObject.findAll(Kontrahent.class);
        kontrahenci.forEach(System.out::println);
    }
}
