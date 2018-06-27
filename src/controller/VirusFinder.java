/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rajitha
 */
public class VirusFinder {

    private ArrayList<String> virusDefHashes = new ArrayList<String>();

    VirusFinder() {
        try (
                BufferedReader br = new BufferedReader(new FileReader(new File("VirusDefinition.md5.txt")))) {
            String line;
            while ((line = br.readLine()) != null) {
                virusDefHashes.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(VirusFinder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String calcMD5Hash(String path) {
        try {
            FileInputStream file = new FileInputStream(new File(path));
            String md5Hash = org.apache.commons.codec.digest.DigestUtils.md5Hex(file);
            file.close();
            return md5Hash;

        } catch (IOException ex) {
            Logger.getLogger(VirusFinder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<String> findVirus(String path) {
        ArrayList<String> results = new ArrayList<String>();
        String hash = calcMD5Hash(path);
        boolean status = virusDefHashes.contains(hash);
        String str = "File is not a virus";
        if (status) {
            str = "File is detected as a virus";
        }
        results.add("Status : " + str);
        results.add("MD5 Signature : " + hash);
        return results;
    }
}
