package pl.sda.hibernate.fakturownia.komendy;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Faktura;

public class KomendaUsunFaktura implements Komenda {
    private DataAccessObject<Faktura> dataAccessObject;

    public KomendaUsunFaktura() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "usun faktura";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id usuwanej faktury:");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        if (dataAccessObject.delete(Faktura.class, id)) {
            System.out.println("Usunieto firme!");
        } else {
            System.err.println("Nie udalo sie usunac faktury!");
        }
    }
}
