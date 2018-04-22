package ua.kiev.prog.model;

import javax.persistence.*;

@Entity
@Table (name = "client_account")
public class Client_account {

    @Id
    @Column (name = "id")
    @GeneratedValue
    private long id;

    @Column (name = "barcode")
    private int barcode;

    @Column(name = "bonus")
    private int bonus;


    public Client_account(int barcode, int bonus) {
        this.barcode = barcode;
        this.bonus = bonus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}

