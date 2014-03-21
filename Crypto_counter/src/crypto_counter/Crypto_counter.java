/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto_counter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tudor
 */
public class Crypto_counter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String filePath = "resources/mono.txt";
        FileParser fileReader = null;
        try {
            fileReader = new FileParser(filePath);
        } catch (Exception ex) {
            Logger.getLogger(Crypto_counter.class.getName()).log(Level.SEVERE, null, ex);
        }

        // treated text
        fileReader.constructTreatedText();

        // analyse
        TextAnalyser textAnalyser = null;
        try {
            textAnalyser = new TextAnalyser(fileReader);
        } catch (Exception ex) {
            Logger.getLogger(Crypto_counter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            textAnalyser.multipleAnalyse(2);
            textAnalyser.showResult();
        } catch (Exception ex) {
            Logger.getLogger(Crypto_counter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
