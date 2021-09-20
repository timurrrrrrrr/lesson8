package players;

public class Berserk extends Hero implements HavingSuperAbility{
    public Berserk(int health, int damage ) {
        super(health, damage,
                SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

    }
}
