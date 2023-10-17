package de.ait.homework36;

import java.util.ArrayList;
import java.util.List;

public class SuperheroManager {

    private List<Superhero> superheroes = new ArrayList<>();

    void addSuperhero(Superhero superhero) {
        if (!checkSuperhero(superhero.getName()) && checkPower(superhero)) {
            superheroes.add(superhero);
        } else {
            System.out.println("Hero " + superhero.getName() + " can not be added ");
        }
    }

    void removeSuperhero(String name) {
        if (checkSuperhero(name)) {
            for (Superhero superhero : superheroes) {
                if (superhero.getName().equals(name)) {
                    superheroes.remove(superhero);
                }
            }
        } else {
            System.out.println("Hero " + name + " can not be added, was not found");

        }

    }

    Superhero getSuperhero(String name) {
        return  searchSuperhero(name);
    }


    List<Superhero> getAllSuperheroes() {
        return superheroes;
    }

    public boolean updateSuperhero(String name, Superhero newSuperhero){
        Superhero superhero = searchSuperhero(name);

        if (superhero !=null){
            superhero.setName(newSuperhero.getName());
            superhero.setAge(newSuperhero.getAge());
            superhero.setPower(newSuperhero.getPower());
            return true;
        }
        return false;
    }

    private boolean checkSuperhero(String superheroName) {
        for (Superhero superhero : superheroes) {
            if (superheroName.equals(superhero.getName())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkPower(Superhero superhero) {
        if (superhero.getPower() >= 1 && superhero.getPower() <= 10) {
            return true;
        }
        return false;
    }

    private Superhero searchSuperhero(String nama) {
        for (Superhero superhero : superheroes) {
            if (superhero.getName().equals(superhero.getName())) {
                return superhero;
            }
        }
        return null;

    }
}