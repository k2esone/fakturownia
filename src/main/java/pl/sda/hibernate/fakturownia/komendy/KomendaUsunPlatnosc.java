package pl.sda.hibernate.fakturownia.komendy;

import pl.sda.hibernate.fakturownia.database.DataAccessObject;
import pl.sda.hibernate.fakturownia.model.Firma;
import pl.sda.hibernate.fakturownia.model.Platnosc;

public class KomendaUsunPlatnosc implements Komenda {
    private DataAccessObject<Platnosc> dataAccessObject;

    public KomendaUsunPlatnosc() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "usun platnosc";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id usuwanej platnosci:");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        if (dataAccessObject.delete(Platnosc.class, id)) {
            System.out.println("Usunieto platnosc!");
        } else {
            System.err.println("Nie udalo sie usunac platnosci!");
        }
    }
}
