/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;

/**
 *
 * @author rajitha
 */
public class Analyzer {

    private VirusFinder virusFinder;
    private FileUtilizer fileUtilizer;

    public Analyzer() {
        virusFinder = new VirusFinder();
        fileUtilizer = new FileUtilizer();
    }

    public ArrayList<String> analyzeFile(String path) {
        ArrayList<String> virusResults = virusFinder.findVirus(path);
        ArrayList<String> fileTypeResults = fileUtilizer.findFileType(path);
        virusResults.addAll(fileTypeResults);
        return virusResults;
    }
}
