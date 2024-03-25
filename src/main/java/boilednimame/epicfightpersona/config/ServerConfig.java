package boilednimame.epicfightpersona.config;

import boilednimame.epicfightpersona.Const;
import net.minecraftforge.common.ForgeConfigSpec;
import java.util.Arrays;

public class ServerConfig implements Const {
    private final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    private final ForgeConfigSpec spec;
    private final EpicPersona ePersona;

    public ServerConfig() {
        ePersona = new EpicPersona();

        spec = builder.build();
    }

    public EpicPersona getEP() {
        return ePersona;
    }

    public ForgeConfigSpec getSpec() {
        return spec;
    }

    public class EpicPersona {

        private final ForgeConfigSpec.ConfigValue<String> menuLang;
        private final ForgeConfigSpec.ConfigValue<Integer> playerMaxHP;
        private final ForgeConfigSpec.ConfigValue<Integer> playerMaxSP;

        public EpicPersona() {
            builder.push(MODID);

            menuLang = builder.comment("The language referred to by the string used in the response from the server.")
                    .define(Arrays.asList("en-us", "ja-jp"),"en-us");

            playerMaxHP = builder.comment("Maximum HP of the player in combat.")
                            .defineInRange("max_HP", 999, 1, Integer.MAX_VALUE);

            playerMaxSP = builder.comment("Maximum SP of the player.")
                            .defineInRange("max_SP", 999, 1, Integer.MAX_VALUE);

            builder.pop();
        }

        public String getLang() {
            return menuLang.get();
        }

        public Integer getPlayerMaxHP() {
            return playerMaxHP.get();
        }

        public Integer getPlayerMaxSP() {
            return playerMaxSP.get();
        }
    }
}
