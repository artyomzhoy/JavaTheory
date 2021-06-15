package com.theory.java.WRAPPERS;

Примитивный тип     Класс-обертка
        byte            Byte
        short           Short
        int             Integer
        long            Long
        float           Float
        double          Double
        char            Character
        boolean         Boolean

/** Названия примитивных типов пишутся с маленькой буквы, а классов — с большой.
Также названия классов немного длиннее: Integer вместо int и Character вместо char и т.д.
 <p> Все объекты классов-оберток являются неизменяемыми (immutable).
 <p>Упрощенный код класса Integer выглядит примерно так:*/

public class Integer {
    private int value;

    Integer(int x) {
        this.value = x;
    }

    public int intValue() {
        return this.value;
    }

    public static Integer valueOf(int x) {
        return new Integer(x);
    }
}
