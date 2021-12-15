/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.Objects;

/**
 *
 * @author gio
 */
public class Word {

    private String first;
    private String second;

    public Word(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public String getFirst() {
        return this.first;
    }

    public String getSecond() {
        return this.second;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Word other = (Word) obj;


        if (other.getFirst().equals(((Word) obj).getFirst())) {
            return true;
        }
        if (other.getFirst().equals(((Word) obj).getSecond())) {
            return true;
        }
        if (other.getSecond().equals(((Word) obj).getSecond())) {
            return true;
        }
        if (other.getSecond().equals(((Word) obj).getFirst())) {
            return true;
        }
        return false;
    }

}
