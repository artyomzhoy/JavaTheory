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

/** Чтобы преобразовать тип int к типу Integer, нужно написать код:*/

Integer имя = new Integer(оборачиваемое значение типа int, например 18 или i);

    Integer age = new Integer(18);
    int x = age.intValue();

    int i = 110;
    Integer zero = new Integer(i);
    int z = zero.intValue();

/**  Автоматическое преобразование int в Integer называется autoboxing (box — коробка, класть в коробку),
а обратная операция — Integer к int — unboxing.
Благодаря autoboxing и unboxing, можно спокойно присваивать тип int типу Integer и наоборот.*/

class IntegerToInt {

    Код:

        Integer a = 5;
        int b = a;
        Integer c = a + b;
        int d = a + b + c;

    Что сгенерирует компилятор:

        Integer a = Integer.valueOf(5);
        int b = a.intValue();
        Integer c = Integer.valueOf(a.intValue() + b);
        int d = a.intValue() + b + c.intValue();
}

/** Если вы сравниваете Integer и Integer, происходит сравнение ссылок, а не значений.
 * Переменные a и b хранят не значения (как типы int), а ссылки на объекты. Поэтому важно помнить, как правильно их сравнивать:
 */

class Equals {

    Если вы сравниваете int и Integer, Integer преобразовывается в int:

        Integer a = 1000;
        Integer b = 1000;
        int c = 500;

        System.out.println(a == b); // сравнение ссылок - false. При autoboxing не всегда создается действительно новый объект Integer.
                                    // Для значений от -128 до 127 включительно объекты кэшируются.
                                    // При а и b = 100 результат был бы true.
        System.out.println(a == c); // Integer a преобразовывается в int - true.
        System.out.println(b == c); // Integer b преобразовывается в int - true.

    Правильное сравнение ссылок:

        Integer a = 1000;
        Integer b = 1000;

        System.out.println(a.equals(b));
}