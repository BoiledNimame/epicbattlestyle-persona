package boilednimame.epicfightpersona.system.stats;

import boilednimame.epicfightpersona.EP;
import boilednimame.epicfightpersona.config.ServerConfig;
import net.minecraft.world.entity.player.Player;

import javax.annotation.Nullable;

public class PlayerStats {
    final ServerConfig.EpicPersona SERVER_CONFIG = EP.SERVER_CONFIG.getEP();

    final int hpLimit = SERVER_CONFIG.getPlayerMaxHP();
    final int spLimit = SERVER_CONFIG.getPlayerMaxSP();

    int hp;
    int sp;
    int level;
    private final int MAX_LEVEL = 99;
    private final int[] nextExps = new int[MAX_LEVEL+1];

    // 所持してるやつのリスト id式にしたら, LinkedHashMapでもいいかも?
    private PersonaStats[] possessionPersonas;

    public PlayerStats(Player player, int hp, int sp, int level, int nextExp, @Nullable PersonaStats[] possessionPersonas) {
        if (hp == -1) {
            this.hp = Math.round(player.getMaxHealth());
        } else {
            this.hp = hp;
        }
        if (sp == -1) {
            this.sp = spLimit;
        } else {
            this.sp = sp;
        }

        this.level = level;
        this.nextExps[level] = nextExp;
        this.possessionPersonas = possessionPersonas;

        /*
         * 参照-主人公の必要Exp:
         * https://docs.google.com/spreadsheets/d/16wn20G5MJ0x9_rMgdVgHLhGgfKOhmy8PkbELmBlBNVg/edit#gid=0
         * 計算式: 一つ前Lvの必要Exp + 現在Lv^2
         */
        nextExps[0] = 0;
        nextExps[1] = 0;
        nextExps[2] = 15;
        for (int i=3; i<(MAX_LEVEL+1);){
            nextExps[i] = nextExps[i-1] + level*level;
            i++;
        }
    }

    // level up
    public void addExp(int gainedExp) {
        if (!(level <= MAX_LEVEL)) {
            LEVEL_UP: {
                int consumedExp = gainedExp;
                for (;;) {
                    if (nextExps[level] <= consumedExp) {
                        consumedExp = consumedExp - nextExps[level];
                        level++;
                    } else {
                        if (level == MAX_LEVEL) {
                            nextExps[level] = 0;
                        } else {
                            nextExps[level] = nextExps[level] - consumedExp;
                        }
                        break LEVEL_UP;
                    }
                }
            }
        }
    }
}
