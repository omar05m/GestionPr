package ma.eheio;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProduitServiceTest {
    ProduitService produitService;
    @org.junit.Before
    public void setUp() throws Exception {
        this.produitService = new ProduitService();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        produitService=null;
    }
    @Test
    public void testAjouterProduitSuccess() {
        Produit produit = new Produit(1,"sword",300.00,7);
        produitService.ajouterProduit(produit);
        // Assert that the product was added successfully
        assertEquals(produit, produitService.produits.get(produit.getId()));
    }

    @Test
    public void testAjouterProduitDuplicateId() {
        Produit existingProduct = new Produit(1,"drugs",200.00,5);
        produitService.ajouterProduit(existingProduct);

        Produit duplicateProduct = new Produit(1,"azerty",200.55,6);

        try {
            produitService.ajouterProduit(duplicateProduct);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Id du produit existe deja", e.getMessage());
        }
    }

    @Test
    public void testAjouterProduitDuplicateName() {
        Produit existingProduct = new Produit(1,"dragon",400.00,5);
        produitService.ajouterProduit(existingProduct);
        Produit duplicateProduct = new Produit(2,"dragon",500.00,6);
        try {
            produitService.ajouterProduit(duplicateProduct);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Le nom du produit avec id " + duplicateProduct.getId() + " existe deja change le nom.", e.getMessage());
        }
    }

}