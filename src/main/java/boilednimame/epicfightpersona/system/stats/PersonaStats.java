package boilednimame.epicfightpersona.system.stats;

import boilednimame.epicfightpersona.system.element.Element;
import boilednimame.epicfightpersona.system.element.ElementAffinity;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PersonaStats implements ElementAffinity {
    // RefinedStorageのDiskにもuuidついてるしそれ見ような！^^
    private final UUID uuid = UUID.randomUUID();
    private int level;
    private int nextExp;
    private static final int MAX_LEVEL = 99;
    private final Map<PersonaBaseStats, Integer> baseStatsMap;
    private final Element[][] elementsAffinity = new Element[ABSORB+1][];

    public PersonaStats(int level, int exp, int str, int ma, int ed, int agi, int luk, Map<Element, Integer> map) {
        this.level = level;
        this.nextExp = exp;
        this.baseStatsMap = new EnumMap<PersonaBaseStats, Integer>(PersonaBaseStats.class){{
            put(PersonaBaseStats.STR, str);
            put(PersonaBaseStats.MAG, ma);
            put(PersonaBaseStats.END, ed);
            put(PersonaBaseStats.AGI, agi);
            put(PersonaBaseStats.LUK, luk);
        }};
        for (int i = 0; i<ABSORB+1 ;i++) {
            elementsAffinity[i] = getElements(map, i);
        }
    }

    public void addExp(int gainedExp) {
        if (!(level <= MAX_LEVEL)) {
            LEVEL_UP: {
                int consumedExp = gainedExp;
                for (;;) {
                    if (nextExp <= consumedExp) {
                        consumedExp = consumedExp - nextExp;
                        level++;
                        /*
                         * おおよそx^2だが少しそれより大きい
                         * 主人公のLv.UP要求Expより体感低い気がしてるんで, 少し低くした
                         * もっと高くしてもいいかもしれない -> 絞首刑etc...
                         * ここの定数を弄る場合はGeoGebraを使ってテストするとよい.
                         */
                        nextExp = 20 + (level/6)*(3*level + 1) * (2*level + 1);
                    } else {
                        if (level == MAX_LEVEL) {
                            nextExp = 0;
                        } else {
                            nextExp = nextExp - consumedExp;
                        }
                        break LEVEL_UP;
                    }
                }
            }
        }
    }

    public Map<PersonaBaseStats, Integer> getStats() {
        return baseStatsMap;
    }

    private Element[] getElements(Map<Element, Integer> elements, int affinity) {
        return elements.entrySet().stream()
                .filter(f -> f.getValue()==affinity)
                .map(Map.Entry::getKey)
                .toList()
                .toArray(new Element[0]);
    }

    /**
     * get this persona's Element.
     * @param affinity use {@link boilednimame.epicfightpersona.system.element.ElementAffinity}
     * @return an Element belonging to the specified affinity.
     */
    public Element[] getElements(int affinity) {
        if (affinity<=elementsAffinity.length) {
            return elementsAffinity[affinity];
        } else {
            throw new IllegalArgumentException("inCollect affinity value!");
        }
    }
}
