/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author rajitha
 */
public class FileUtilizer {

    public ArrayList<String> findFileType(String path) {
        ArrayList<String> results = new ArrayList<String>();
        try {
            Path filePath = FileSystems.getDefault().getPath(path);
            String contentType = Files.probeContentType(filePath);
            results.add("Content Type : " + contentType);
        } catch (IOException ex) {
            Logger.getLogger(FileUtilizer.class.getName()).log(Level.SEVERE, null, ex);
        }
        String fileExtension = FilenameUtils.getExtension(path);
        results.add("Extension : " + fileExtension);
        return results;
    }
}
