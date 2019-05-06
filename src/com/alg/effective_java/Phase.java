package com.alg.effective_java;

import java.util.EnumMap;
import java.util.Map;

public enum Phase {
    SOLID, LIQUID, GAS;

    public enum Transistion {

        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);

        private Phase from;
        private Phase to;

        Transistion(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

        private static final Map<Phase, Map<Phase, Transistion>> m = new EnumMap<>(Phase.class);

        static {
            for (Transistion tr : Transistion.values()) {
                if (m.get(tr.from) == null) {
                    m.put(tr.from, new EnumMap<>(Phase.class));
                }
                m.get(tr.from).put(tr.to, tr);
            }
        }

        public static Transistion from(Phase from, Phase to) {
            return m.get(from).get(to);
        }
    }


    public static void main(String[] args) {
        System.out.println(Transistion.from(SOLID, GAS));
    }
}
