package com.asrez;
/**
 *
 * @Name : ToyLanguageTranslator
 * @File : com/asrez/ZariLanguageInterpreter.java
 * @Version : 1.0
 * @Programmer : Max
 * @Date : 2019-12-07
 * @Released under : https://github.com/BaseMax/ToyLanguageTranslator/blob/master/LICENSE
 * @Repository : https://github.com/BaseMax/ToyLanguageTranslator
 * @Reference : https://github.com/BaseMax/ToyLanguageTranslator
 *
 **/
public class ZariLanguageInterpreter {
    public static int checkCharType(char input) {
        if(Character.isAlphabetic(input)) {
            switch(Character.toLowerCase(input)) {
                case 'a':
                case 'e':
                case 'o':
                case 'u':
                case 'i':
                    return 1;// return false;
                default:
                    return 0;// return true;
            }
        }
        return -1;// return false;
    }

    public static int minimum(int []array) {
        int temp=-1;
        for(int i=0;i<array.length;i++) {
            if(array[i] > temp) {
                temp=array[i];
            }
        }
        return temp;
    }

    public static int indexOfChar(String input) {
        int index[]= {-1,-1,-1,-1,-1};
        index[0]=input.indexOf("a");
        index[1]=input.indexOf("e");
        index[2]=input.indexOf("o");
        index[3]=input.indexOf("u");
        index[4]=input.indexOf("i");
        int min=minimum(index);
        return min;
    }

    public static String toZari(String input) {
        String temp="";
        if(input.isEmpty()) {
            return temp;
        }
        if(checkCharType(input.charAt(0)) == 1) {
            temp=input+"way";
        }
        else {
            int first=indexOfChar(input);
            if(first == -1) {
                first=input.length();
//                return "";
            }
            temp=input.substring(first)+input.substring(0, first)+ "ay";
        }
        return temp;
    }

    public static void main(String arguments[]) {
        System.out.println(toZari("strength"));
        System.out.println(toZari("alpha"));
        System.out.println(toZari("strong"));
        System.out.println(toZari("frzzl"));
    }
}
