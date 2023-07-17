package com.example;

public class MagicFruitBasket {
    private int fruitCount = 0;

    public void addFruit() {
        ++fruitCount;
    }

    public int getFruitCount() {
        return fruitCount;
    }

    public static void main(String[] args) throws InterruptedException {
        final MagicFruitBasket basket = new MagicFruitBasket();

        class MagicTree extends Thread {
        	public void run() {
        		for (int i = 0; i < 10000; ++i) {
        			basket.addFruit();
                }
        	}
        }
        
        // Instantiate two `MagicTree`s and get them adding fruit

        System.out.println("Final fruit count in basket: " + basket.getFruitCount());
    }
}
