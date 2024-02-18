package ru.omsu.fctk;

import java.util.Objects;

class Human
{
    String Surname;
    String Name;
    String Otchestvo;
    int Age;

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getOtchestvo() {
        return Otchestvo;
    }

    public void setOtchestvo(String otchestvo) {
        Otchestvo = otchestvo;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Age == human.Age && Objects.equals(Surname, human.Surname) && Objects.equals(Name, human.Name) && Objects.equals(Otchestvo, human.Otchestvo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Surname, Name, Otchestvo, Age);
    }
    Human(String Surname,String Name, String Otchestvo, int Age)
    {
        this.Surname = Surname;
        this.Name = Name;
        this.Otchestvo = Otchestvo;
        this.Age = Age;
    }
}