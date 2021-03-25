package esercizi.compito19mar;

/*
Ogni ProdottoForno hai i seguenti dati:
    • Codice (string)
    • Nome (stringa)
    • GiorniDaturata (int)
ed i metodi:
    • Costruttore()
    • Get e Set
    • Prezzo
*/

public abstract class ProdottoForno {
    
    private String codice;
    private String nome;
    private int giorniDaturata;
    private float iva;
    
    //costruttori

    public ProdottoForno(String codice, String nome, int giorniDaturata, float iva) {
        this.codice = codice;
        this.nome = nome;
        this.giorniDaturata = giorniDaturata;
        this.iva = iva;
    }
    
    public ProdottoForno() {
        this.codice = "";
        this.nome = "";
        this.giorniDaturata = 0;
        this.iva = 0;
    }
    
    public ProdottoForno(ProdottoForno p) {
        this.codice = p.codice;
        this.nome = p.nome;
        this.giorniDaturata = p.giorniDaturata;
        this.iva = p.iva;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getGiorniDaturata() {
        return giorniDaturata;
    }

    public void setGiorniDaturata(int giorniDaturata) {
        this.giorniDaturata = giorniDaturata;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    @Override
    public String toString() {
        return "Nome: " + nome
                + "\nPrezzo: " + calcolaPrezzo() + "€"
                + "\nGiorni daturata: " + giorniDaturata;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof ProdottoForno){
            return ((ProdottoForno)o).codice.equals(this.codice);
        }
        return false;
    }
    
    public abstract float calcolaPrezzo();
    
}