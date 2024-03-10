package boilednimame.epicfightpersona.system.action.Interface;

import boilednimame.epicfightpersona.system.Effect;
import boilednimame.epicfightpersona.system.Element;

import java.util.UUID;

public interface ISkill {
    UUID id = null;

    boolean isSelectable = false;
    Element includeElement = Element.Almighty;

    boolean isDealDamage = false;
    long baseDamage = -1;

    boolean isEvadable = false;
    short baseAccuracyRate = -1;

    short TargetSelf = 0;
    short TargetAlly = 1;
    short TargetEnemy = 2;
    short TargetAll = 3;
    int TargetableObject = -1;

    boolean isInflictEffects = false;
    Effect[] inflictEffects = new Effect[]{};
}
