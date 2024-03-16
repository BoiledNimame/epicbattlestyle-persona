package boilednimame.epicfightpersona.system.stats;

import boilednimame.epicfightpersona.system.Effect;

import java.util.HashMap;
import java.util.Map;

public class PlayerStats {
    int hp;
    final int maxHp;
    int sp;
    final int maxSp;

    private int level;
    private final int MAX_LEVEL = 99;
    private final int[] nextExps = new int[MAX_LEVEL+1];

    int attack;
    final int baseAttack;
    int defense;
    final int baseDefence;
    int agility;
    final int baseAgility;

    Map<Effect, Integer> currentEffect;

    public PlayerStats(int hp, int maxHp, int sp, int maxSp,
                       int baseStatAtk, int baseStatDef, int baseStatAgi,
                       int level, int nextExp) {
        // これ`Player`クラス内で戦闘開始時に呼ばれるようにしたい

        // 基礎ステ
        this.hp = hp;
        this.sp = sp;
        this.attack = baseStatAtk;
        this.defense = baseStatDef;
        this.agility = baseStatAgi;
        this.maxHp = maxHp;
        this.maxSp = maxSp;
        this.baseAttack = baseStatAtk;
        this.baseDefence = baseStatDef;
        this.baseAgility = baseStatAgi;
        this.level = level;
        this.nextExps[level] = nextExp;

        // 後で使うやつら
        currentEffect = new HashMap<>();

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

    // Effect
    public void applyEffect(Effect effect, int duration_turn) {
        if (currentEffect.containsKey(effect)) {
            currentEffect.replace(effect, duration_turn);
        } else {
            currentEffect.put(effect, duration_turn);
        }
    }
    public Map<Effect, Integer> getEffects() {
        return currentEffect;
    }
}
