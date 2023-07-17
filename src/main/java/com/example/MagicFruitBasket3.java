package com.example;

public class MagicFruitBasket3 {
    private Long fruitCount;
    private Boolean isOverflown;
    private final Object lock = new Object();

    public MagicFruitBasket3(final Long fruitCount, final Boolean isOverflown) {
        this.fruitCount = fruitCount;
        this.isOverflown = isOverflown;
    }

    public void addFruitAndCheckOverflow() {
        synchronized(lock) {
            ++fruitCount;
            isOverflown = fruitCount % 3 == 0;
        }
    }

    public void removeFruitIfOverflown() {
        synchronized(lock) {
            if (isOverflown) {
                --fruitCount;
            }
        }
    }

    public void resetBasket() {
        if (lock != null) {
            synchronized(lock) {
                fruitCount = 0L;
                isOverflown = false;
            }
        }
    }

    public Boolean isOverflown() {
        return isOverflown;
    }

    public Long getFruitCount() {
        return fruitCount;
    }
}
