package magicGame.models.magicians;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.Magic;

public class MagicianImpl implements Magician{
    private String username;
    private int protection;
    private int health;
    private boolean isAlive;
    private Magic magic;

    public MagicianImpl(String username, int health, int protection,Magic magic) {
        this.setName(username);
        this.setHealth(health);
        this.setProtection(protection);
        this.setMagic(magic);
        this.setAlive();
    }

    public void setAlive() {
        if(protection > 0){
            this.isAlive = true;
        } else {
            this.isAlive = false;
        }
    }

    public void setName(String username) {
        if(username == null || username.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_NAME);
        }
        this.username = username;
    }

    public void setHealth(int health) {
        if(health < 0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
    }

    public void setProtection(int protection) {
        if(protection < 0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }

    public void setMagic(Magic magic) {
        if(magic == null){
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC);
        }
        this.magic = magic;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getProtection() {
        return protection;
    }

    @Override
    public Magic getMagic() {
        return magic;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void takeDamage(int points) {
        int protectionDamage = protection - points;
        if(protectionDamage >= 0){
            setProtection(protectionDamage);
        } else {
            setProtection(0);
            int healthDamage = getHealth() - Math.abs(protectionDamage);
            if(healthDamage > 0){
                setHealth(healthDamage);
            } else {
                setHealth(0);
                isAlive = false;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s: %s",getClass().getSimpleName(),username)).append(System.lineSeparator());
        sb.append(String.format("Health: %d",health)).append(System.lineSeparator());
        sb.append(String.format("Protection: %d",protection)).append(System.lineSeparator());
        sb.append(String.format("Magic: %s",magic.getName())).append(System.lineSeparator());
        return sb.toString().trim();
    }
}
