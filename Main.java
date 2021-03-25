package esercizi.compito19mar;

public class Main {
    public static void main(String[] args) {
        
//        ProdottoPeso ppeso1 = new ProdottoPeso(1, 1, "ABC", "Pane", 3, 23);
//        ProdottoPezzo ppezzo1 = new ProdottoPezzo("BBB", "Schiacciata", 5, 22, 1);
//        
//        System.out.println("Prezzo: " + ppezzo1.calcolaPrezzo());
//        System.out.println("ToString:\n" + ppezzo1.toString());
        
        Forno forno = new Forno("Pane e Schiacciate e Crostate", "Via del pane di segale 45");
        
        System.out.println("Inserimento peso 1:" + forno.addProdotto(new ProdottoPeso(3, 1, "Peso1", "Pane Bello", 2, 10)));
        System.out.println("Inserimento peso 2:" + forno.addProdotto(new ProdottoPeso(4, 2, "Peso2", "Pane Piccante", 12, 40)));
        System.out.println("Inserimento peso 3:" + forno.addProdotto(new ProdottoPeso(5, 3, "Peso3", "Pane Falso", 100, 23)));
        
        System.out.println("Inserimento pezzo 1:" + forno.addProdotto(new ProdottoPezzo("Pezzo1", "Schiacciata di segale", 4, 12, 5)));
        System.out.println("Inserimento pezzo 2:" + forno.addProdotto(new ProdottoPezzo("Pezzo2", "Schiacciata di mais", 6, 12, 7)));
        System.out.println("Inserimento pezzo 1(non dovrebbe funzionare):" + forno.addProdotto(new ProdottoPezzo("Pezzo1", "Schiacciata di verità", 20, 23, 50)));
        System.out.println("Inserimento pezzo 4:" + forno.addProdotto(new ProdottoPezzo("Pezzo4", "Schiacciata di segatura", 150, 5, 26)));
        
        System.out.println("\n---------------Lista prodotti peso---------------\n");
        for(ProdottoPeso p: forno.listaProdottiPeso()){
            System.out.println("\n" + p +"\n");
        }
        
        System.out.println("\n-------------NUMERO PRODOTTI PESO: " +forno.numeroProdottiPeso());
        
//        System.out.println("\n---------------Lista prodotti pezzo---------------\n");
//        for(ProdottoPezzo p: forno.listaProdottiPezzo()){
//            System.out.println("\n" + p +"\n");
//        }
        
        System.out.println("\n---------------Lista prodotti pezzo col prezzo maggiore di 3€---------------\n");
        for(ProdottoForno p: forno.listaProdottiPezzoConPrezzoMinimo(3)){
            System.out.println("\n" + p +"\n");
        }
        
        System.out.println("\n---------------ToString del prodotto peso con durata maggiore-----------------\n\n" + forno.prodottoPesoConPiuDurata().toString());
        
        System.out.println("\n\n--------------DATI DEL FORNO------------\n");
        System.out.println(forno.toString());
        
        System.out.println("\n---------------Lista di prodotti con prezzo superiore al prezzo medio(" + forno.prezzoMedioProdotti() + "€)---------------\n");
        for(ProdottoForno p: forno.listaProdottiPiuCostosiDellaMedia()){
            System.out.println("\n" + p +"\n");
        }
        
    }
}