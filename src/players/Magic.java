package players;

public class Magic extends Hero implements HavingSuperAbility{
    public Magic(int health, int damage ) {
        super(health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

    }
}
