package boilednimame.epicfightpersona.system.stats;

import boilednimame.epicfightpersona.system.element.Element;
import boilednimame.epicfightpersona.system.element.ElementAffinity;

import java.util.AbstractMap;
import java.util.Map;

public class PersonaStats implements ElementAffinity {
    private final Element[][] elementsAffinity = new Element[ABSORB+1][];

    AbstractMap.SimpleEntry<PersonaBaseStats, Integer> STR = new AbstractMap.SimpleEntry<>(PersonaBaseStats.STR, -1);
    AbstractMap.SimpleEntry<PersonaBaseStats, Integer> MAG = new AbstractMap.SimpleEntry<>(PersonaBaseStats.MAG, -1);
    AbstractMap.SimpleEntry<PersonaBaseStats, Integer> END = new AbstractMap.SimpleEntry<>(PersonaBaseStats.END, -1);
    AbstractMap.SimpleEntry<PersonaBaseStats, Integer> AGI = new AbstractMap.SimpleEntry<>(PersonaBaseStats.AGI, -1);
    AbstractMap.SimpleEntry<PersonaBaseStats, Integer> LUK = new AbstractMap.SimpleEntry<>(PersonaBaseStats.LUK, -1);

    public PersonaStats(int str, int ma, int ed, int agi, int luk, Map<Element, Integer> map) {
        this.STR.setValue(str);
        this.MAG.setValue(ma);
        this.END.setValue(ed);
        this.AGI.setValue(agi);
        this.LUK.setValue(luk);
        for (int i = 0; i<ABSORB+1 ;i++) {
            elementsAffinity[i] = getElements(map, i);
        }
    }

    private Element[] getElements(Map<Element, Integer> elements, int affinity) {
        return elements.entrySet().stream()
                .filter(f -> f.getValue()==affinity)
                .map(Map.Entry::getKey)
                .toList()
                .toArray(new Element[0]);
    }

    public Element[] getElements(int affinity) {
        if (affinity<=elementsAffinity.length) {
            return elementsAffinity[affinity];
        } else {
            throw new IllegalArgumentException("inCollect affinity value!");
        }
    }
}
