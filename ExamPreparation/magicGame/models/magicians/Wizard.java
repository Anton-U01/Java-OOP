package magicGame.models.magicians;

import magicGame.models.magics.Magic;

public class Wizard extends MagicianImpl{
    public Wizard(String name, int health, int protection, Magic magic) {
        super(name, health, protection, magic);
    }
}
