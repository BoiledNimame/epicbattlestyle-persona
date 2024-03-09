package boilednimame.epicfightpersona.system;

public enum PersonaBaseStats {
    STR("st"),
    MAG("ma"),
    END("ed"),
    AGI("ag"),
    LUK("lu");

    private final String id;

    PersonaBaseStats(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public boolean equals(PersonaBaseStats s) {
        return this.id.equals(s.id);
    }
}