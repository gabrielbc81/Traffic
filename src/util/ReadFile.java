/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author roger.vargas
 */
public class ReadFile {

    private String[] fields;
    private String separator;
    private Scanner sc;

    public ReadFile(String filename, String separator)
            throws FileNotFoundException {
        sc = new Scanner(new java.io.FileReader(filename));
        configure(separator);
    }

    private void configure(String separator) {
        this.separator = separator;
        sc.useDelimiter("[" + separator + "\r\n]");
        sc.useLocale(Locale.US);
        String firstline = sc.nextLine();
        fields = firstline.split(separator);
    }

    public String[] getFields() {
        String[] res = new String[fields.length];
        System.arraycopy(fields, 0, res, 0, fields.length);
        return res;
    }

    public boolean hasNext() {
        return sc.hasNext();
    }

    public String[] nextRecord() {
        return sc.nextLine().split(separator);
    }

    public String next() {
        return sc.next();
    }

    public int nextInt() {
        return sc.nextInt();
    }

    public double nextDouble() {
        return sc.nextDouble();
    }

    public void skipNext() {
        sc.next();
    }

    public void skipNext(int amount) {
        for (int i = 0; i < amount; i++) {
            skipNext();
        }
    }

    public int getRecordSize() {
        return fields.length;
    }
}
