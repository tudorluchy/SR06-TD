/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto_counter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tudor
 */
public class FileParser {

    private String m_simpleText;
    private String m_treatedText;
    private String m_filePath;

    /**
     * Constructor
     *
     * @param filePath
     * @throws java.lang.Exception
     */
    public FileParser(String filePath) throws Exception {
        if (filePath.isEmpty()) {
            throw new Exception("File path is empty");
        }
        m_filePath = filePath;
    }

    /**
     * Get simple text
     *
     */
    public void constructSimpleText() {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            is = new FileInputStream(m_filePath);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        isr = new InputStreamReader(is);
        br = new BufferedReader(isr);

        // reading
        m_simpleText = new String();
        String line;
        try {
            while ((line = br.readLine()) != null) {
                m_simpleText += line;
            }
        } catch (IOException ex) {
            Logger.getLogger(FileParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(FileParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Get treated text
     *
     */
    public void constructTreatedText() {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            is = new FileInputStream(m_filePath);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        isr = new InputStreamReader(is);
        br = new BufferedReader(isr);

        // reading
        m_treatedText = new String();
        String line;
        try {
            while ((line = br.readLine()) != null) {
                m_treatedText += line.replaceAll("\\s+", "").toUpperCase();
            }
        } catch (IOException ex) {
            Logger.getLogger(FileParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(FileParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @return
     */
    public String getM_simpleText() {
        return m_simpleText;
    }

    /**
     *
     * @return
     */
    public String getM_treatedText() {
        return m_treatedText;
    }

    /**
     *
     * @return
     */
    public String getM_filePath() {
        return m_filePath;
    }
}
