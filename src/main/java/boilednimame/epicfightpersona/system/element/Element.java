package boilednimame.epicfightpersona.system.element;

import boilednimame.epicfightpersona.EP;
import net.minecraft.client.resources.language.I18n; // lang ごとに違うの呼び出す guiとかで使いましょうね;;
import net.minecraft.locale.Language;

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
    private final String elementName;
    public final boolean canReflectPhysBarrier;
    public final boolean CanReflectMagicBarrier;



    Element(String id, boolean canReflectPhysBarrier, boolean canReflectMagicBarrier) {
        this.id = id;
        this.canReflectPhysBarrier = canReflectPhysBarrier;
        this.CanReflectMagicBarrier = canReflectMagicBarrier;
        if (!Language.DEFAULT.equals(EP.SERVER_CONFIG.getEP().getLang())) {
            EP.LOGGER.warn("The config and current language are different! Some displays may have unexpected results.");
        }this.elementName = I18n.get("element.epicpersona.".concat(id));
    }

    public boolean equals(Element e) {
        return this.id.equals(e.id);
    }

    // WARN サーバー側で呼ばれちゃいけない. 鯖側からのレスポンスとして使用しないこと. または, configで決める
    public String getNameOnCurrentLang() {
        return this.elementName;
    }
}
