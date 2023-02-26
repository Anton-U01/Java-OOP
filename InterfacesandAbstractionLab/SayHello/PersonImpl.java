package InterfacesandAbstractionLab.SayHello;


public abstract class PersonImpl implements Person {
    private String name;

    public PersonImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
