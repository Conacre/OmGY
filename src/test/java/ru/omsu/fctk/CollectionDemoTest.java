package ru.omsu.fctk;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class CollectionDemoTest
{
    @Test
    public void countStartPosition()
    {
        ArrayList<String> strings = new ArrayList<>();
        Collections.addAll(strings, "apple", "cucumber", "nigga","abricozzzz");
        assertEquals(2, CollectionDemo.countStartPosition(strings, 'a'));
    }

    @Test
    public void getNamesakes()
    {
        ArrayList<Human> humans = new ArrayList<>(4);
        Human humanone = new Human("Студент", "Студентик", "Студентикович", 12);
        Human humantwo = new Human("Скобенко", "Дмитрий", "Анатольевич", -4);
        Human humanthree = new Human("Денисенко", "Гигачад", "Приколович", 2883);
        Human humanfour = new Human("Маер", "Дай", "Попарелович", 20);
        Collections.addAll(humans,humanone,humantwo,humanthree,humanfour);

        ArrayList<Human> result = new ArrayList<>(1);
        Collections.addAll(result, humanfour);

        assertEquals(result, CollectionDemo.getNamesakes(humans, humanfour));
    }

    @Test
    public void Copyright()
    {
        ArrayList<Human> humans = new ArrayList<>(4);
        Human humanone = new Human("Студент", "Студентик", "Студентикович", 12);
        Human humantwo = new Human("Скобенко", "Дмитрий", "Анатольевич", -4);
        Human humanthree = new Human("Денисенко", "Гигачад", "Приколович", 2883);
        Human humanfour = new Human("Маер", "Дай", "Попарелович", 20);
        Collections.addAll(humans,humanone,humantwo,humanthree,humanfour);

        ArrayList<Human> result = new ArrayList<>(3);
        Collections.addAll(result, humanone, humantwo, humanthree);

        assertEquals(result, CollectionDemo.Copyright(humans, humanfour));
    }
}