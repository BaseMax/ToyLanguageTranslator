package com.asrez;
/**
 *
 * @Name : ToyLanguageTranslator
 * @File : com/asrez/ToyLanguageTranslator.java
 * @Version : 1.0
 * @Programmer : Max
 * @Date : 2019-12-07
 * @Released under : https://github.com/BaseMax/ToyLanguageTranslator/blob/master/LICENSE
 * @Repository : https://github.com/BaseMax/ToyLanguageTranslator
 * @Reference : https://github.com/BaseMax/ToyLanguageTranslator
 *
 **/
public class LanguageInterpreter {
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

    public static Boolean isValid(String input) {
        int i;
        for(i=0;i<input.length();i++) {
            if(checkCharType(input.charAt(i)) == 0) {
                if(input.length() > i+2 && input.charAt(i+1) == 'o' && input.charAt(i) == input.charAt(i+2)) {
                    i+=2;
                }
                else {
                    return false;
                }
            }
        }
        if(i == input.length()) {
            return true;
        }
        return false;
    }

    public static String toEnglish(String input) throws Exception {
        String temp="";
        for(int i=0;i<input.length();i++) {
            temp+=input.charAt(i);
            if(checkCharType(input.charAt(i)) == 0) {
                if(input.length() > i+2 && input.charAt(i+1) == 'o' && input.charAt(i) == input.charAt(i+2)) {
                    i+=2;
                }
                else {
                    throw new Exception("The input is not valid!");
                }
            }
        }
        return temp;
    }

    public static String toRomani(String input) {
        String temp="";
        for(int i=0;i<input.length();i++) {
            temp+=input.charAt(i);
            if(checkCharType(input.charAt(i)) == 0) {
                temp+='o';
                temp+=input.charAt(i);
            }
        }
        return temp;
    }

    public static void main(String arguments[]) {
        try {
            System.out.println(toEnglish("HoHeyoy alollol, hohelollolo hohowow arore yoyou koknonowowloledodgoge!"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(isValid("HoHeyoy alollol, hohelollolo hohowow arore yoyou koknonowowloledodgoge!"));
        System.out.println(toRomani("Hey all, hello how are you knowledge!"));
    }
}
