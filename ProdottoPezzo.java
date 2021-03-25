package esercizi.compito19mar;

/*
La classe ProdottoPezzo che rappresenta un prodotto venduto al pezzo, ha i dati:
    • Prezzo (float)
    • Iva (float)
Ed il metodo:
    • Prezzo che calcola il prezzo finale del prodotto

*/

public class ProdottoPezzo extends ProdottoForno{
    
    private float prezzo;

    public ProdottoPezzo(String codice, String nome, int giorniDaturata, float iva, float prezzo) {
        super(codice, nome, giorniDaturata, iva);
        this.prezzo = prezzo;
    }

    public ProdottoPezzo() {
        super();
        this.prezzo = 0;
    }

    public ProdottoPezzo(ProdottoPezzo p) {
        super(p);
        this.prezzo = p.prezzo;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public float calcolaPrezzo() {
        return prezzo + (prezzo*(getIva()/100));
    }

    @Override
    public String toString() {
        return super.toString() 
                + "\nVenduto al pezzo";
    }
    
}