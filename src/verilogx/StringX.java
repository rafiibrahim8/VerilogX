/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verilogx;

/**
 *
 * @author ibrahim
 */
public class StringX {

    public String str;

    public StringX(String str) {
        this.str = str;
    }

    public StringX(byte[] bytes) {
        this.str = new String(bytes);
    }

    public void editTo(String str) {
        this.str = str;
    }

    public void addTop(String s) {
        this.str = s + System.lineSeparator() + this.str;
    }

    public void addBottom(String s) {
        this.str = this.str + System.lineSeparator() + s;
    }

    public void replace(String oldStr, String newStr) {
        this.str = this.str.replace(oldStr, newStr);
    }

    @Override
    public String toString() {
        return this.str;
    }

}
