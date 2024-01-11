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


}