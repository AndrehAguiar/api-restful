package one.digitalinnovation.apirestful.dto;

public class Soldier {
    private String cpf;
    private String name;
    private String breed;
    private String weapon;

    public Soldier(String cpf, String name, String breed, String weapon) {
        this.cpf = cpf;
        this.name = name;
        this.breed = breed;
        this.weapon = weapon;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", weapon='" + weapon + '\'' +
                '}';
    }
}
