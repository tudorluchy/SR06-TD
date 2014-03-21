/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto_counter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author tudor
 */
public class TextAnalyser {

    private FileParser m_fileParser;
    private HashMap<String, Integer> m_res = new HashMap<String, Integer>();
    private ValueComparator m_vc = new ValueComparator(m_res);
    private TreeMap<String, Integer> m_res_freq = new TreeMap<String, Integer>(m_vc);

    /**
     *
     * @param fileParser
     * @throws Exception
     */
    public TextAnalyser(FileParser fileParser) throws Exception {
        if (fileParser == null) {
            throw new Exception("FileParser is null !");
        }
        m_fileParser = fileParser;
    }

    private int countSubstring(String subStr, String str) {
        int count = 0;
        for (int loc = str.indexOf(subStr); loc != -1;
                loc = str.indexOf(subStr, loc + subStr.length())) {
            count++;
        }
        return count;
    }

    /**
     *
     */
    public void simpleAnalyse() {
        String text = m_fileParser.getM_treatedText();
        for (int i = 0; i < text.length(); i++) {
            char car = text.charAt(i);
            int count = 0;
//            for (int j = 0; j < text.length(); j++) {
//                if (car == text.charAt(j)) {
//                    count++;
//                }
//            }
            count = countSubstring(Character.toString(car), text);
            m_res.put(Character.toString(car), new Integer(count));
        }
        m_res_freq.putAll(m_res);
    }

    /**
     *
     * @param interval
     * @throws Exception
     */
    public void multipleAnalyse(int interval) throws Exception {
        if (interval < 1) {
            throw new Exception("nb must be > 0");
        }
        String text = m_fileParser.getM_treatedText();
        for (int i = 0; i < (text.length() - interval); i++) {
            String tmp = text.substring(i, interval + i);
            int count = 0;
//            for (int j = 0; j < (text.length() - interval); j++) {
//                if (tmp.equals(text.substring(j, interval + j))) {
//                    count++;
//                }
//            }
            count = countSubstring(tmp, text);
            m_res.put(tmp, new Integer(count));
        }
        m_res_freq.putAll(m_res);;
    }

    /**
     *
     */
    public void showResult() {
        Set keys = m_res_freq.keySet();
        Iterator it = keys.iterator();
        while (it.hasNext()) {
            Object key = it.next();
            Object value = m_res_freq.get(key);
            System.out.println("Key : " + key + ", value : " + value);
        }
    }
}
