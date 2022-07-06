package utils;

import io.qameta.allure.Description;

public class WorkWithPrice {
    @Description("Get a price of the product and make it over from String to int")
    public static int makeOverPriceFromStringToInt(String price) {
        String[] splitedString = price.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        int k = splitedString.length - 1;
        for (int i = 0; i < k; i++) {
            stringBuilder.append(splitedString[i]);
        }
        String joinedString = stringBuilder.toString();
        int intPrice = Integer.parseInt(joinedString);
        return intPrice;
    }

}

