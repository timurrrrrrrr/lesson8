package players;

public class Medic extends Hero implements HavingSuperAbility {
    private int healPoints;

    public Medic(int health, int damage, int healPoints) {
        super(health, damage, SuperAbility.HEAL);
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                if (this != heroes[i]) {
                    heroes[i].setHealth(
                            heroes[i].getHealth() + healPoints);
                }
            }

        }

    }
}
