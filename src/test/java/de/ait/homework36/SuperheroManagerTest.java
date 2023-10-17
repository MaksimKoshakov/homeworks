package de.ait.homework36;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SuperheroManagerTest {
    private List<Superhero> superheroes;

    private SuperheroManager superheroManager;

    @BeforeEach
    void setUp() {
        superheroes = new ArrayList<>();
        superheroManager = new SuperheroManager();
    }

    @Test
    void addSuperheroSuccess() {
        Superhero superheroThor = new Superhero("Thor", 10, 1021);
        superheroManager.addSuperhero(superheroThor);
        List<Superhero> superheroesResult = superheroManager.getAllSuperheroes();
        int sizeResult = superheroManager.getAllSuperheroes().size();
        Assertions.assertEquals(1, sizeResult);
        Assertions.assertEquals(superheroThor, superheroesResult.get(0));
    }

    @Test
    void addSuperheroFail() {
        Superhero superheroThor = new Superhero("Thor", 10, 1021);
        superheroManager.addSuperhero(superheroThor);
        List<Superhero> superheroesResult = superheroManager.getAllSuperheroes();
        int sizeResult = superheroManager.getAllSuperheroes().size();
        Assertions.assertEquals(1, sizeResult);
        superheroManager.addSuperhero(superheroThor);
        Assertions.assertEquals(1, sizeResult);
    }

    @Test
    void removeSuperheroSuccess() {
        Superhero superheroIron = new Superhero("Iron Man", 10, 40);
        Superhero superheroBatman = new Superhero("Batman", 9, 40);
        Superhero superheroSuperman = new Superhero("Superman", 10, 33);

        superheroManager.addSuperhero(superheroIron);
        superheroManager.addSuperhero(superheroBatman);
        superheroManager.addSuperhero(superheroSuperman);

        List<Superhero> superheroesResult = superheroManager.getAllSuperheroes();
        int sizeResult = superheroesResult.size();
        Assertions.assertEquals(3, sizeResult);

        superheroManager.removeSuperhero("Batman");

        List<Superhero> superheroesResultRemove = superheroManager.getAllSuperheroes();
        Assertions.assertEquals(2, superheroesResultRemove.size());

        for (Superhero superhero : superheroesResultRemove) {
            Assertions.assertNotEquals("Batman", superhero.getName());
        }
    }

    void removeSuperheroFail() {
        Superhero superheroIron = new Superhero("Iron Man", 10, 40);
        Superhero superheroBatman = new Superhero("Batman", 9, 40);
        Superhero superheroSuperman = new Superhero("Superman", 10, 33);

        superheroManager.addSuperhero(superheroIron);
        superheroManager.addSuperhero(superheroBatman);
        superheroManager.addSuperhero(superheroSuperman);

        List<Superhero> superheroesResult = superheroManager.getAllSuperheroes();
        int sizeResult = superheroesResult.size();
        Assertions.assertEquals(3, sizeResult);

        superheroManager.removeSuperhero("SpiderMan");
        List<Superhero> superheroesResultRemove = superheroManager.getAllSuperheroes();
        Assertions.assertEquals(3, superheroesResultRemove.size());
    }


        @Test
    void getSuperheroSuccess() {
            Superhero superheroIron = new Superhero("Iron Man", 10, 40);
            superheroManager.addSuperhero(superheroIron);
            Assertions.assertNotNull(superheroManager.getSuperhero(superheroIron.getName()));
            Assertions.assertEquals(superheroIron, superheroManager.getSuperhero(superheroIron.getName()));
        }

    @Test
    void getSuperheroFail() {
        Superhero superhero = new Superhero("Iron Man", 10, 40);
        superheroManager.addSuperhero(superhero);
        Assertions.assertNull(superheroManager.getSuperhero("IronNan"));
    }



    @Test
    void getAllSuperheroes() {
        Superhero superheroIron = new Superhero("Iron Man", 10, 40);
        Superhero superheroBatman = new Superhero("Batman", 9, 40);
        Superhero superheroSuperman = new Superhero("Superman", 10, 33);

        superheroManager.addSuperhero(superheroIron);
        superheroManager.addSuperhero(superheroBatman);
        superheroManager.addSuperhero(superheroSuperman);

        List<Superhero> superheroesResult = superheroManager.getAllSuperheroes();
        Assertions.assertEquals(3, superheroesResult.size());
        Assertions.assertEquals(superheroIron, superheroesResult.get(0));
        Assertions.assertEquals(superheroBatman, superheroesResult.get(1));
        Assertions.assertEquals(superheroSuperman, superheroesResult.get(2));
    }

    @Test
    void addSuperheroWrongPower() {
        Superhero superheroThor = new Superhero("Thor", 100, 1021);
        superheroManager.addSuperhero(superheroThor);
        List<Superhero> superheroesResult = superheroManager.getAllSuperheroes();

        int sizeResult = superheroManager.getAllSuperheroes().size();
        Assertions.assertEquals(0, sizeResult);

    }

    @Test
    void testUpdateSuperheroSuccess (){
        Superhero superheroIron = new Superhero("Iron Man", 5, 40);
        superheroManager.addSuperhero(superheroIron);
        Superhero superheroIronUpdate = new Superhero("Iron Man", 10, 30);
        superheroManager.updateSuperhero("Iron Man", superheroIronUpdate);
        Superhero superheroResult = superheroManager.getSuperhero("Iron Man");
        Assertions.assertEquals(10,superheroResult.getPower());
        Assertions.assertEquals(30,superheroResult.getAge());


    }

}