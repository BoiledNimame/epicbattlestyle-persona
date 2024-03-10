package boilednimame.epicfightpersona.system;

public enum Effect {
    // Incapacitated
    Incapacitated("incapacitated"),

    // Status Ailments
    Down("down"),
    Burn("burn"),
    Freeze("freeze"),
    Shock("shock"),
    Dizzy("dizzy"),
    Forgot("forgot"),
    Sleep("sleep"),
    Confuse("confuse"),
    Fear("fear"),
    Despair("despair"),
    Rage("rage"),
    Brainwash("brainwash"),
    Hunger("hunger"),
    Mouse("mouse"),
    Paint("paint"),
    Lust("lust"),
    Wrath("wrath"),
    Envy("envy"),
    Desperation("desperation"),

    // Battle Conditions
    AttackUp("attackUp"),
    AttackDown("attackDown"),
    DefenseUp("defenseUp"),
    DefenseDown("defenseDown"),
    AgilityUp("agilityUp"),
    AgilityDown("agilityDown"),
    CriticalRateUp("criticalRateUP"),

    // Charged Effects
    Charged("charged"),
    Focused("focused"),

    // Protective Effects
    PhysicalBarrier("physBarrier"),
    MagicBarrier("magicBarrier"),

    // Elemental Walls (precedence over Elemental Break)
    FireWall("fireWall"),
    IceWall("iceWall"),
    ElecWall("elecWall"),
    WindWall("windWall"),
    NukeWall("nukeWall"),
    PsyWall("psyWall"),

    // Elemental Breaks
    FireBreak("fireBreak"),
    IceBreak("iceBreak"),
    ElecBreak("elecBreak"),
    WindBreak("windBreak"),
    NukeBreak("nukeBreak"),
    PsyBreak("psyBreak"),

    // Others
    AilmentSusceptibility("sick"),
    Decoy("decoy"),
    Concealment("hide"),
    Sent("sent"),
    Panicked("panicked"),
    ATKDown("atkDownSpecial");

    private String id;

    Effect(String id) {
        this.id = id;
    }

    public boolean equals(Effect e) {
        return this.id.equals(e.id);
    }
}
