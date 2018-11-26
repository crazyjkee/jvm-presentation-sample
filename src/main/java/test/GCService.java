package test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class GCService {
    private static ArrayList<BigDecimal> closingPrices = new ArrayList();

    private static final BigDecimal averagePrice = BigDecimal.valueOf(100);

    static {
        for (int iDecimal = 0; iDecimal < getRandomPriceBetweenMinAndMax(50, 150); iDecimal++) {
            BigDecimal randFromDouble = new BigDecimal(Math.random());
            closingPrices.add(randFromDouble);
        }
    }


    public String averagePrice() {
        BigDecimal sum = new BigDecimal(0);
        for (BigDecimal closingPrice : closingPrices) {
            BigDecimal diff = closingPrice.subtract(averagePrice);
            diff = diff.multiply(diff);
            sum = sum.add(diff);
        }

        return "done";
    }


    /**
     * Получаем случайную цену в заданном диапазоне
     *
     * @param min минимальная цена
     * @param max максимальная цена
     * @return
     */
    private static int getRandomPriceBetweenMinAndMax(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("Максимальное значение должно быть больше минимального");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
