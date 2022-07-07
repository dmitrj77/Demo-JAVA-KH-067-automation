package utils;

import io.qameta.allure.Description;

public class WorkWithPrice {
    @Description("Get a price of the product and make it over from String to int")
    public static int getintFromPrice(String price) {
        String[] splitedString = price.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < splitedString.length - 1; i++) {
            stringBuilder.append(splitedString[i]);
        }
        String joinedString = stringBuilder.toString();
        int intPrice = Integer.parseInt(joinedString);
        return intPrice;
    }

}

