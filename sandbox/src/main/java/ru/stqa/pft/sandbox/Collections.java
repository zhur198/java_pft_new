package ru.stqa.pft.sandbox;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhur198 on 1/22/17.
 */
public class Collections {

  public static void main (String[] args) {

    String [] langs = {"Java", "C#", "Python", "PHP"};

//    List<String> languages = new ArrayList<String>();
//    languages.add("Java");
//    languages.add("C#");
//    languages.add("Python");
//    languages.add("PHP");

    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

//    for (int i = 0; i < langs.length; i++) {
//      System.out.println(" I want to learn " + langs[i]);

    for (String l : languages) {
      System.out.println(" I want to learn " + l);

//    for (int i = 0; i < languages.size(); i++) {
//      System.out.println(" I want to learn " + languages.get(i));
    }
  }
}
