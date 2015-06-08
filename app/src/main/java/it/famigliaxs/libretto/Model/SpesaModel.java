package it.famigliaxs.libretto.Model;

import java.util.Date;

/**
 * Created by federicosanchi on 26/03/15.
 */
public class SpesaModel {

    private long Importo;
    private Date Data;
    private String Descrizione;
    private String Utente;

    public SpesaModel(long Importo, Date Data, String Descrizione, String Utente){
        this.Importo = Importo;
        this.Data = Data;
        this.Descrizione = Descrizione;
        this.Utente = Utente;
    }

    public SpesaModel(){

    }

    public long getImporto() {
        return Importo;
    }

    public Date getData() {
        return Data;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public String getUtente() {
        return Utente;
    }

    public void setImporto(long importo) {
        Importo = importo;
    }

    public void setData(Date data) {
        Data = data;
    }

    public void setDescrizione(String descrizione) {
        Descrizione = descrizione;
    }

    public void setUtente(String utente) {
        Utente = utente;
    }
}
