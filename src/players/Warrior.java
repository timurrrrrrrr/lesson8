package players;

import Kg.Game.General.Rpg.Game;

public class Warrior extends Hero implements HavingSuperAbility{
    public Warrior(int health, int damage ) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int coeff= Game.random.nextInt(5)+2;
        boss.setHealth(this.getHealth()
                -this.getDamage()*coeff);
        System.out.println("Critical Damage"+this.getDamage()*coeff);

    }
}
