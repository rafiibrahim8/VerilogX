/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verilogx;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FileFilterer extends FileFilter {

    private String description;
    private String[] extensions;
    private boolean allowDir;

    public FileFilterer(String description, String[] extensions, boolean allowDir) {
        this.description = description;
        this.extensions = extensions;
        this.allowDir = allowDir;
    }

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return allowDir;
        }
        if (this.extensions == null) {
            return true;
        }
        String path = file.getAbsolutePath().toString();
        for (String extension : extensions) {
            if (path.endsWith(extension)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

}
