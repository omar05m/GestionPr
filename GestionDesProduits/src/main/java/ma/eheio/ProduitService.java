package ma.eheio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ProduitService {
    Map<Long,Produit> produits = new HashMap<Long, Produit>();

    //supprimer un produits
    public void supprimerProduit(Produit produit) {
        if (produits.containsValue(produit)) {
            produits.values().remove(produit);
            System.out.println("produit supprime");
        } else {
            System.out.println("produit existe pas");
        }
    }
}
