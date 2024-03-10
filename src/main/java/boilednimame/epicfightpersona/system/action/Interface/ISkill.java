package boilednimame.epicfightpersona.system.action.Interface;

import boilednimame.epicfightpersona.system.Effect;
import boilednimame.epicfightpersona.system.Element;
import boilednimame.epicfightpersona.system.stats.PlayerStats;

import java.util.UUID;

public interface ISkill {
    UUID id = null;

    boolean isSelectable = false;
    Element includeElement = null;

    boolean isConsumeStats = false;
    PlayerStats consumedStats = null;

    boolean isDealDamage = false;
    long baseDamage = -1;

    boolean isEvadable = false;
    int baseAccuracyRate = -1;

    short TargetSelf = 0;
    short TargetAlly = 1;
    short TargetEnemy = 2;
    short TargetAll = 3;
    int TargetableObject = -1;

    boolean isInflictEffects = false;
    Effect[] inflictEffects = new Effect[]{};
}
