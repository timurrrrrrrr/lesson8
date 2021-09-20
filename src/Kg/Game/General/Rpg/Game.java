package Kg.Game.General.Rpg;

import players.*;

import java.util.Random;

public class Game {
    public static Random random = new Random();

    public static void startGame() {

        Boss boss = new Boss(700, 50);
        Warrior warrior = new Warrior(290, 15);
        Magic magic = new Magic(250, 20);
        Medic doc = new Medic(200, 5, 15);
        Berserk berserk = new Berserk(220, 25);
        Medic assistant = new Medic(230, 10, 10);
        Hero[] heroes = {warrior, magic, doc, berserk, assistant};

        printStatistics(boss, heroes);
        while (isGameFinished(boss, heroes)) {
            round(boss,heroes);
        }
    }

    private static void heroesapplysuperabilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 &&
                    boss.getHealth() > 0) {
                heroes[i].applySuperPower(boss,heroes);
            }



        }
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth()>0 && boss.getHealth()>0){
            heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }

    }
    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth()>0 && heroes[i].getHealth()>0){
                boss.setHealth(heroes[i].getHealth() - heroes[i].getDamage());
            }
        }

    }


    private static void round(Boss boss, Hero[] heroes) {
        bossHits(boss, heroes);
        heroesHit(boss,heroes);
        heroesapplysuperabilities(boss, heroes);
        printStatistics(boss, heroes);

    }


    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("____________");
        System.out.println("Boss health:" + boss.getHealth() + "[" + boss.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() + " health:" + heroes[i].getHealth() + "[" + heroes[i].getDamage() + "]");
        }
        System.out.println("_________");
    }

    public static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;

            }


            if (allHeroesDead) {
                System.out.println("Boss won!!!");
            }

        }
        return allHeroesDead;
    }
}
