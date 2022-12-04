package pl.sda.hibernate.fakturownia.komendy;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Faktura;
import pl.sda.hibernate.fakturownia.model.Firma;

import java.util.List;

public class KomendaListaFaktura implements Komenda {
    private DataAccessObject<Faktura> dataAccessObject;

    public KomendaListaFaktura() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista faktura";
    }

    @Override
    public void obsluga() {
        List<Faktura> faktury = dataAccessObject.findAll(Faktura.class);
        faktury.forEach(System.out::println);
    }
}
