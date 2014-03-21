/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto_counter;

import java.util.Comparator;
import java.util.Map;

/**
 *
 * @author tudor
 */
class ValueComparator implements Comparator<String> {

    private Map<String, Integer> m_base;

    /**
     *
     * @param base
     */
    public ValueComparator(Map<String, Integer> base) {
        this.m_base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.    
    @Override
    public int compare(String a, String b) {
        Integer x = m_base.get(a);
        Integer y = m_base.get(b);
        if (x.equals(y)) {
            return a.compareTo(b);
        }
        return x.compareTo(y);
    }
}
