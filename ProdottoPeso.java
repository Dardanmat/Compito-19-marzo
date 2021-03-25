package esercizi.compito19mar;

/*
La classe ProdottoPeso che rappresenta un prodotto venduto a peso, ha i dati:
    • PrezzoAlKg (float)
    • PesoKg (float)
    • Iva (float)
ed il metodo:
    • Prezzo che calcola il prezzo finale del prodotto
*/

public class ProdottoPeso extends ProdottoForno{
    
    private float prezzoAlKg;
    private float pesoKg;

    public ProdottoPeso(float prezzoAlKg, float pesoKg, String codice, String nome, int giorniDaturata, float iva) {
        super(codice, nome, giorniDaturata, iva);
        this.prezzoAlKg = prezzoAlKg;
        this.pesoKg = pesoKg;
    }

    public ProdottoPeso() {
        super();
        this.prezzoAlKg = 0;
        this.pesoKg = 0;
    }

    public ProdottoPeso(ProdottoPeso p) {
        super(p);
        this.prezzoAlKg = p.prezzoAlKg;
        this.pesoKg = p.pesoKg;
    }

    public float getPrezzoAlKg() {
        return prezzoAlKg;
    }

    public void setPrezzoAlKg(float prezzoAlKg) {
        this.prezzoAlKg = prezzoAlKg;
    }

    public float getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(float pesoKg) {
        this.pesoKg = pesoKg;
    }

    @Override
    public float calcolaPrezzo() {
        return (prezzoAlKg*pesoKg) + ((prezzoAlKg*pesoKg)*(getIva()/100));
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nPeso: " + pesoKg + "Kg" 
                + "\nPrezzo al Kg: " + prezzoAlKg + "€";
    }
    
}