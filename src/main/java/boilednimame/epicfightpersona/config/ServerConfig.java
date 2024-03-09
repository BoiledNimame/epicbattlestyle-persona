package boilednimame.epicfightpersona.config;

import boilednimame.epicfightpersona.Const;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

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

        // private final ForgeConfigSpec.xxValue some;

        public EpicPersona() {
            builder.push(MODID);

            // some = builder.comment("comment here")
            //        .defineInRange("some", 10, 0, Integer.MAX_VALUE);

            builder.pop();
        }

        // public int getUsage() {
        //    return some.get();
        // }
    }
}
