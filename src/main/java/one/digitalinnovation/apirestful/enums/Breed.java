package one.digitalinnovation.apirestful.enums;

import java.util.stream.Stream;

public enum Breed {
    HUMAN("human"),
    ELF("elf"),
    ORC("orc"),
    PALADIN("paladin"),
    DWARF("dwarf");

    private final String value;

    Breed(String value) {
        this.value = value;
    }

    public static Breed of(String value) {
        return Stream.of(Breed.values())
                .filter(it -> it.getValue().equals(value))
                .findFirst()
                .orElseThrow();
    }

    public String getValue() {
        return value;
    }
}
