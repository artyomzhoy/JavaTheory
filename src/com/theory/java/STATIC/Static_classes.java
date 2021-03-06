package com.theory.java.STATIC;

import java.util.ArrayList;

@1.Статические вложенные классы


/**
 * В языке Java вполне можно объявлять классы внутри классов.
 * И даже классы внутри классов, которые внутри классов внутри классов.
 * <p>Внутренние классы бывают статические и нестатические.
 * Статические классы еще называют вложенными (static nested class),
 * нестатические просто называют внутренними классами (inner class).
 */

public class Static_classes {

    static ArrayList<Point> points = new ArrayList<Point>();

    public static void main(String[] args) {

        Point point = new Point();
        point.x = 100;
        point.y = 200;
        points.add(point);
        System.out.println(Box.volume(5, 6, 7));


    }

    static class Point { // Вложенный класс.

        int x;
        int y;

    }

    /**
     * Статические вложенные классы можно использовать вне своего родительского класса.
     * Если у такого класса стоит модификатор доступа public, его можно использовать в любом месте программы.
     * Такие классы фактически ничем не отличаются от любого обычного класса. Хотя есть пара отличий.
     */

    public static class Box { // Публичный вложенный класс.

        public static int zxc = 100;

        int z;
        int x;
        int c;

        static int volume(int z, int x, int c) { // Статический метод вложенного класса.
            return z * x * c;
        }

    }

    /** 1. Имя класса.
     * <p>Если вы хотите обратиться к статическому вложенному классу не из его класса-родителя,
     * а из другого места в программе, вам нужно будет указать имя класса:
     * оно состоит из имени класса родителя и имени вложенного класса. Общий вид этого имени такой:
     */

    Static_classes.Point; // КлассРодитель.ВложенныйКласс.

    /** Если вложенный класс имеет свой вложенный класс, их имена просто склеиваются через точку.*/

    /**
     * 2. Создание объекта.
     * <p>Создать объект вложенного статического класса очень легко. Выглядит это так:
     */

    Static_classes.Point point = new Static_classes.Point();

    /** 3. Обращение к статическим методам
     <p>Если у статического класса есть статические методы, обращаться к ним можно точно так же,
     как к статическим методам обычных классов (только имя класса теперь двойное).*/

    Static_classes.Box.volume(1,2,3);

    /** 4. Обращение к статическим переменным
     * <p>Обращаться к публичным статическим переменным вложенного класса тоже легко:
     */

    Static_classes.Box.zxc;

}

@2.Особенности статических классов

/**
 * Статические внутренние классы меньше всего стоило бы называть статическими.
 * Они ведут себя точно так же, как обычные классы. Никаких ограничений на обращение к ним из нестатических методов нет.
 *
 * <p>Если вы возьмете какой-то вложенный статический класс и вынесете его из его класса родителя,
 * все, что изменится, так это то,
 * что новый класс потеряет способность обращаться к private static переменным и методам бывшего класса-родителя.
 */

public class Solution {
    private static ArrayList<Point> points;

    static class Point // Вложенный статический класс Point
    {
        int x;
        int y;

        public static void main(String[] args) {
            Point point = new Point();
            point.x = 100;
            point.y = 200;

            // Будет работать.
            points = new ArrayList<Point>();
            points.add(point);
        }
    }
}

/**
 * Метод main в обычном классе Point не может обращаться к private static переменной points класса Solution!
 * <p>Это, собственно, и есть главное отличие вложенного статического класса от обычного класса.
 * Методы вложенного статического класса имеют доступ ко всем статическим переменным и методам своего класса родителя,
 * даже если те объявлены private.
 * <p>Ну а если разобраться, что тут удивительного?
 * Модификатор private прямо говорит, что к переменным и методам, обозначенным этим модификатором,
 * можно обращаться только изнутри их класса. Внутренний статический класс находится внутри класса-родителя?
 * Да, тогда никаких проблем: обращайтесь сколько хотите.
 */

public class Solution {
    private static ArrayList<Point> points;
}

class Point {
    int x;
    int y;

    public static void main(String[] args) {
        Point point = new Point();
        point.x = 100;
        point.y = 200;

        // Тут будет ошибка.
        points = new ArrayList<Point>();
        points.add(point);
    }
}
// https://javarush.ru/groups/posts/2181-vlozhennihe-vnutrennie-klassih доделать доки по этой статье.

