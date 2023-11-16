package morpion;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 *
 */
public class CoordonneesTest {

    @Test
    public void testEstDansPlateau() {
        assertTrue(Coordonnees.estDansPlateau(
                new Coordonnees(
                0, 
                0), 
                14));
        assertTrue(Coordonnees.estDansPlateau(
                new Coordonnees(
                13, 
                13), 
                14));
        assertTrue(Coordonnees.estDansPlateau(
                new Coordonnees(
                0, 
                1), 
                14));
        assertFalse(Coordonnees.estDansPlateau(
                new Coordonnees(
                -1, 
                1), 
                14));
        assertTrue(Coordonnees.estDansPlateau(
                new Coordonnees(
                7, 
                13), 
                14));
        assertFalse(Coordonnees.estDansPlateau(
                new Coordonnees(
                7, 
                14), 
                14));
        assertTrue(Coordonnees.estDansPlateau(
                new Coordonnees(
                13, 
                0), 
                14));
        assertFalse(Coordonnees.estDansPlateau(
                new Coordonnees(
                14, 
                0), 
                14));
        assertTrue(Coordonnees.estDansPlateau(
                new Coordonnees(
                7, 
                0), 
                14));
        assertFalse(Coordonnees.estDansPlateau(
                new Coordonnees(
                7, 
                -1), 
                14));
        assertTrue(Coordonnees.estDansPlateau(
                new Coordonnees(
                0, 
                1), 
                2));
        assertFalse(Coordonnees.estDansPlateau(
                new Coordonnees(
                0, 
                1), 
                1));
    }

    @Test
    public void testSuivante() {
        assertEquals(new Coordonnees(5, 4),
                Coordonnees.suivante(
                        new Coordonnees(4, 4), 
                        Direction.SUD));
        assertEquals(new Coordonnees(0, 0),
                Coordonnees.suivante(
                        new Coordonnees(1, 1), 
                        Direction.NORD_OUEST));
        assertEquals(new Coordonnees(-1, -1),
                Coordonnees.suivante(
                        new Coordonnees(0, 0), 
                        Direction.NORD_OUEST));
        assertEquals(new Coordonnees(199, 201),
                Coordonnees.suivante(
                        new Coordonnees(200, 200), 
                        Direction.NORD_EST));
    }
    
    @Test
    public void testVoisines() {
        Coordonnees[] casesEnCoin = {
            new Coordonnees(0, 0), 
            new Coordonnees(2, 0), 
            new Coordonnees(0, 2), 
            new Coordonnees(2, 2)
        };
        
        Coordonnees[] caseCentreBord = {
            new Coordonnees(1, 0),
            new Coordonnees(0, 1),
            new Coordonnees(2, 1),
            new Coordonnees(1, 2)
        };
        
        for (Coordonnees c : casesEnCoin) {
            assertEquals(3, c.voisines(c, 3).length);
        } 
        for (Coordonnees c : caseCentreBord) {
            assertEquals(5, c.voisines(c, 3).length);
        }
        Coordonnees centre = new Coordonnees(1, 1);
        assertEquals(8, centre.voisines(centre, 3).length);
        
        centre.ligne = -2;
        centre.colonne = -2;
        assertEquals(0, centre.voisines(centre, 3).length);
    }
}
