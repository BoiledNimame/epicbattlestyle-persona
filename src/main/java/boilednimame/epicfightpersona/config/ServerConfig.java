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

        public EpicPersona() {
            builder.push(MODID);

            menuLang = builder.comment("The language referred to by the string used in the response from the server.")
                    .define(Arrays.asList("en-us", "ja-jp"),"en-us");
            //        .defineInRange("some", 10, 0, Integer.MAX_VALUE);

            builder.pop();
        }

        public String getLang() {
            return menuLang.get();
        }
    }
}
