package org.barkovsky;

public class UserRu {

    UserRu (String name, String zipCode, String country, String city, String street, String home, String flat, String phoneNumber, int users, float errors) {
        addErrors(name, zipCode, country, city, street, home, flat,phoneNumber, users, errors);
    }

    public static void addErrors (String name, String zipCode, String country, String city, String street, String home, String flat, String phoneNumber, int users, float errors) {
        int n = users;
        float m = errors;
        double k = Math.random() * n * (m + 1);
        for (int i = 0; i < errors; i++) {

            if (k < n) break;
            else {
                int count = (int) Math.round(1 + Math.random() * 7);
                switch (count) {
                    case 1:
                        name = selectError(name);
                        break;
                    case 2:
                        zipCode = selectError(zipCode);
                        break;
                    case 3:
                        country = selectError(country);
                        break;
                    case 4:
                        city = selectError(city);
                        break;
                    case 5:
                        street = selectError(street);
                        break;
                    case 6:
                        home = selectError(home);
                        break;
                    case 7:
                        flat = selectError(flat);
                        break;
                    case 8:
                        phoneNumber = selectError(phoneNumber);
                        break;
                }
            }

        }
        System.out.println(name + "; " + zipCode + "; " + country + "; г. " + city + ", " + street + ", д. " + home + ", кв. " + flat + "; " + phoneNumber);

    }

    public static String swap (String str) {
        String firstStr = str;
        char [] secondStr = firstStr.toCharArray();
        int n = (int) Math.round(1 + Math.random() * (secondStr.length - 1));
        if (n >= secondStr.length - 1 && secondStr.length != 1) n = secondStr.length - 2; // возможно надо будет все в одну строку сделать
        else if(secondStr.length == 1) return str;
        char buff;
        buff = secondStr[n];
        secondStr[n] = secondStr[n + 1];
        secondStr[n + 1] = buff;
        String lastStr = new String(secondStr);
        return lastStr;
    }

    public static String deleteSymbol (String str) {
        String firstStr = str;
        int n = (int) (1 + Math.random() * firstStr.length() - 1);
        if (n >= firstStr.length()) n = n - 1;
        if (firstStr.length() == 1) return str;
        StringBuffer sb = new StringBuffer(firstStr);
        sb.delete(n, n + 1);
        return sb.toString();
    }

    public static String addSymbol (String str) {
        String firstStr = str;
        char [] secondStr = firstStr.toCharArray();
        int n = (int) Math.round(1 + Math.random() * secondStr.length - 1);
        if (n >= secondStr.length) n = n - 1;
        StringBuilder sb = new StringBuilder(firstStr);
        int m = (int) Math.round(1 + Math.random() * firstStr.length() - 1);
        if (m >= firstStr.length()) m = m - 1;
        if(secondStr[n] == ' ')  n = (int) Math.round(1 + Math.random() * secondStr.length - 1);
        sb.insert(n, secondStr[m]);
        return sb.toString();
    }

    public static String selectError (String str) {
        int n = (int) Math.round(1 + Math.random() * 2);
        String firstStr = str;
        switch (n) {
            case 1: firstStr = swap(str); break;
            case 2: firstStr = deleteSymbol(str); break;
            case 3: firstStr = addSymbol(str); break;
        }
        return firstStr;
    }


}
