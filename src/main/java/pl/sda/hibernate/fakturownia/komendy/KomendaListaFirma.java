package pl.sda.hibernate.fakturownia.komendy;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Firma;

import java.util.List;

public class KomendaListaFirma implements Komenda {
    private DataAccessObject<Firma> dataAccessObject;

    public KomendaListaFirma() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista firma";
    }

    @Override
    public void obsluga() {
        List<Firma> firmy = dataAccessObject.findAll(Firma.class);
        firmy.forEach(System.out::println);
    }
}
