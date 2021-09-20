package players;

public abstract class Hero extends Entity
        implements HavingSuperAbility {
    private SuperAbility superAbility;

    public SuperAbility getSuperAbility() {
        return superAbility;
    }

    public void setSuperAbility(SuperAbility superAbility) {
        this.superAbility = superAbility;
    }

    public Hero(int health, int damage, SuperAbility superAbility) {
        super(health, damage);
        this.superAbility=superAbility;
    }
}
