package esercizi.compito19mar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
Scrivere la classe Forno che contiene una lista di oggetti di tipo ProdottoForno con i
dati:
    • Nome (stringa)
    • Indirizzo (stringa)
Ed i metodi:
    • Metodo che aggiunge un prodotto alla lista dei prodotti del forno (solo se non è
già presente, controllare il codice)
    • Metodo che restituisce il numero di prodotti venduti a peso
    • Metodo che restituisce una lista di prodotti venduti al pezzo con prezzo maggiore
di un valore passato come parametro
    • Metodo che restituisce il prodotto venduto a peso con la durata maggiore
    • Metodo che restituisce una stringa con tutti i dati dei prodotti del forno
*/

public class Forno {
    
    private String nome;
    private String indirizzo;
    ArrayList<ProdottoForno> listaProdotti;

    public Forno(String nome, String indirizzo, ArrayList<ProdottoForno> listaProdotti) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.listaProdotti = (ArrayList<ProdottoForno>)listaProdotti.clone();
    }
    
    public Forno() {
        this.nome = "";
        this.indirizzo = "";
        this.listaProdotti = new ArrayList<>();
    }
    
    public Forno(String nome, String indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.listaProdotti = new ArrayList<>();
    }
    
    public Forno(Forno f) {
        this.nome = f.nome;
        this.indirizzo = f.indirizzo;
        this.listaProdotti = (ArrayList<ProdottoForno>)f.listaProdotti.clone();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public ArrayList<ProdottoForno> getListaProdotti() {
        return listaProdotti;
    }

    public void setListaProdotti(ArrayList<ProdottoForno> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }
    
    public boolean addProdotto(ProdottoForno p){
        if(p == null) return false;
        if(cercaProdotto(p) != -1) return false; //il prodotto è presente
        return listaProdotti.add(p);
    }
    
    public ProdottoForno removeProdotto(ProdottoForno p){
        if(p == null) return null;
        int pos = cercaProdotto(p);
        if(pos != -1) return listaProdotti.remove(pos);
        return null;
    }
    
    private int cercaProdotto(ProdottoForno p){
        for (int i = 0; i < listaProdotti.size(); i++) {
            if(listaProdotti.get(i).equals(p)) return i;
        }
        return -1;
    }
    
    public int numeroProdottiPeso(){
        return listaProdottiPeso().size();
    }
    
    public ArrayList<ProdottoPeso> listaProdottiPeso(){
        ArrayList<ProdottoPeso> lista = new ArrayList<>();
        for(ProdottoForno p: listaProdotti){
            if(p instanceof ProdottoPeso) lista.add((ProdottoPeso)p);
        }
        return lista;
    }
    
    public ArrayList<ProdottoPezzo> listaProdottiPezzo(){
        ArrayList<ProdottoPezzo> lista = new ArrayList<>();
        for(ProdottoForno p: listaProdotti){
            if(p instanceof ProdottoPezzo) lista.add((ProdottoPezzo)p);
        }
        return lista;
    }
    
    public ArrayList<ProdottoPezzo> listaProdottiPezzoConPrezzoMinimo(float prezzoMinimoNonCompreso){
        ArrayList<ProdottoPezzo> lista = listaProdottiPezzo();
        
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).calcolaPrezzo() < prezzoMinimoNonCompreso) lista.remove(i);
        }
        
        return lista;
    }
    
    public ProdottoPeso prodottoPesoConPiuDurata(){
        int max = 0;
        ArrayList<ProdottoPeso> lista = listaProdottiPeso();
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getGiorniDaturata() > lista.get(max).getGiorniDaturata()) max = i;
        }
        return lista.get(max);
    }

    @Override
    public String toString() {
        String s = nome + " all'indirizzo: " + indirizzo;
        
        for (ProdottoForno p : listaProdotti) {
            s += "\n" + p.toString() + "\n";
        }
        
        return s;
    }
    
    public float prezzoMedioProdotti(){
        if(listaProdotti.isEmpty()) return 0;
        float somma = 0;
        for(ProdottoForno p: listaProdotti) somma += p.calcolaPrezzo();
        return somma/listaProdotti.size();
    }
    
    private ArrayList<ProdottoForno> listaProdottiConPrezzoMinimo(float prezzoMinimo){
        ArrayList<ProdottoForno> lista = new ArrayList<>();
        float media = prezzoMedioProdotti();
        
        for(ProdottoForno p: listaProdotti){
            if(p.calcolaPrezzo() > prezzoMinimo) lista.add(p);
        }
        
        return lista;
    }
    
    public ArrayList<ProdottoForno> listaProdottiPiuCostosiDellaMedia(){
        ArrayList<ProdottoForno> lista = listaProdottiConPrezzoMinimo(prezzoMedioProdotti());
        Collections.sort(lista, Comparator.comparing(ProdottoForno::getGiorniDaturata).reversed());
        return lista;
    }
    
}