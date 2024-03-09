package boilednimame.epicfightpersona.system;

import net.minecraft.client.resources.language.I18n; // lang ごとに違うの呼び出す guiとかで使いましょうね;;

public enum Element {
    Phys("physical", true, false),
    Strike("strike", true, false),
    Slash("slash", true, false),
    Pierce("pierce", true, false),
    Gun("gun", true, false),
    Fire("fire", false, true),
    Ice("ice", false, true),
    Elec("electric", false, true),
    Wind("wind", false, true),
    Psy("psy", false, true),
    Nuke("nuke", false, true),
    Bless("bless", false, true),
    Curse("curse", false, true),
    Almighty("almighty", false, false),
    Ailment("ailment", false, false),
    Healing("healing", false, false),
    Support("support", false, false),
    Passive("passive", false, false);


    private final String id;
    public final boolean canReflectPhysBarrier;
    public final boolean CanReflectMagicBarrier;

    public final String lang;
    private final String langSuffix = "element.epicpersona.";

    Element(String id, boolean canReflectPhysBarrier, boolean canReflectMagicBarrier) {
        this.id = id;
        this.lang = langSuffix.concat(id);
        this.canReflectPhysBarrier = canReflectPhysBarrier;
        this.CanReflectMagicBarrier = canReflectMagicBarrier;
    }

    public boolean equals(Element e) {
        return this.id.equals(e.id);
    }
}
