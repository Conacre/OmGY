package ru.omsu.fctk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class CollectionDemo
{
    public static int countStartPosition(Collection<String> strings, char a)
    {
        int result = 0;
        for (String string: strings)
        {
            if (string.charAt(0) == a) result++;
        }
        return result;
    }

    public static List<Human> getNamesakes(ArrayList<Human> humans, Human current)
    {
        List<Human> result = new ArrayList<>();
        for (Human human: humans)
        {
            if (human.getSurname().equals(current.getSurname()))
            {
                result.add(human);
            }
        }
        return result;
    }
    public static List<Human> Copyright(ArrayList<Human> humans, Human copy)
    {
        List<Human> result = new ArrayList<>();
        for (Human human: humans)
        {
            if (!human.equals(copy)) result.add(human);
        }
        return result;
    }
}

