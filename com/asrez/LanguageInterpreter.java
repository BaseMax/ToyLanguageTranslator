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
    public static int checkType(char input) {
        if(Character.isAlphabetic(input)) {
            switch(Character.toLowerCase(input)) {
                case 'a':
                case 'e':
                case 'o':
                case 'u':
                case 'i':
                    return 1;
                default:
                    return 0;
            }
        }
        return -1;
    }

    public static Boolean isValid(String input) {
        int i;
        for(i=0;i<input.length();i++) {
            if(checkType(input.charAt(i)) == 0) {
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
            if(checkType(input.charAt(i)) == 0) {
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

    public static void main(String arguments[]) {
        try {
            System.out.println(toEnglish("HoHeyoy alollol, hohelollolo hohowow arore yoyou koknonowowloledodgoge!"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(isValid("HoHeyoy alollol, hohelollolo hohowow arore yoyou koknonowowloledodgoge!"));
    }
}
