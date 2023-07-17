package com.example;

public class MagicFruitBasket2 {

    private Long fruitCount;

    private Boolean isOverFlown;

    public MagicFruitBasket2(final Long fruitCount, final Boolean isOverFlown) {
        this.fruitCount = fruitCount;
        this.isOverFlown = isOverFlown;
    }

    public void incrementAndFlip() {
        synchronized (fruitCount) {
            ++fruitCount;
            synchronized (isOverFlown) {
                isOverFlown = fruitCount % 3 == 0;
            }
        }
    }

    public void decrementIfFlipped() {
        synchronized (isOverFlown) {
            synchronized (fruitCount) {
                if (isOverFlown) {
                    --fruitCount;
                }
            }
        }
    }

    public Boolean isOverFlown() {
        synchronized (isOverFlown) {
            return isOverFlown;
        }
    }

    public Long getFruitCount() {
        synchronized (fruitCount) {
            return fruitCount;
        }
    }

    public static void main(String[] args) {

    }

}
