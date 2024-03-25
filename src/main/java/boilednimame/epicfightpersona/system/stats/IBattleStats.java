package boilednimame.epicfightpersona.system.stats;

import boilednimame.epicfightpersona.system.Effect;

import java.util.Map;

public interface IBattleStats {
    Map<Effect, Integer> getEffects();
}
