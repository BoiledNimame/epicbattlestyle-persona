package boilednimame.epicfightpersona.system.stats;

import boilednimame.epicfightpersona.system.Effect;

import java.util.HashMap;
import java.util.Map;

public class PlayerBattleStats implements IBattleStats {
    int hp;
    final int maxHp;
    int sp;
    final int maxSp;

    private final int level;

    int attack;
    final int baseAttack;
    int defense;
    final int baseDefence;
    int agility;
    final int baseAgility;

    Map<Effect, Integer> currentEffect;

    private PersonaStats persona;

    public PlayerBattleStats(int hp, int maxHp, int sp, int maxSp,
                             int baseStatAtk, int baseStatDef, int baseStatAgi,
                             int level, PersonaStats persona) {
        // これ`Player`クラス内で戦闘開始時に呼ばれるようにしたい
        // Playerのインスタンスも渡してそっからexpを取るように なんならexp系はそっちに移動してや;;

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

        // 後で使うやつら
        this.currentEffect = new HashMap<>();
        this.persona = persona;
    }

    // 戦闘ステータスのgetはやしといて
    public int getLevel() {
        return this.level;
    }

    // ペルソナ関連
    public PersonaStats getCurrentPersona() {
        return this.persona;
    }
    public void changeCurrentPersona(PersonaStats persona) {
        this.persona = persona; // PlayerStatsの保持ペルソナ側に含まれるかのチェックを挿れること
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
