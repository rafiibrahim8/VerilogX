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
public class ExecResult {

    String resultString;
    int resultCode;

    public ExecResult(String resultString, int resultCode) {
        this.resultCode = resultCode;
        this.resultString = resultString;
    }

    public int getResultCode() {
        return resultCode;
    }

    public String getResultString() {
        return resultString;
    }
}
