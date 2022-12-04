package pl.sda.hibernate.fakturownia.komendy;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Firma;

public class KomendaUsunFirma implements Komenda {
    private DataAccessObject<Firma> dataAccessObject;

    public KomendaUsunFirma() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "usun firma";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id usuwanej firmy:");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        if (dataAccessObject.delete(Firma.class, id)) {
            System.out.println("Usunieto firme!");
        } else {
            System.err.println("Nie udalo sie usunac firmy!");
        }
    }
}
