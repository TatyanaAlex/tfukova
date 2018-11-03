package ru.job4j.threads;

import javafx.scene.shape.Rectangle;

/**
 * Class RectangleMove.
 */
public class RectangleMove implements Runnable {

    private final Rectangle rect;

    /**
     * Constructor.
     *
     * @param rect rectangle.
     */
    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        boolean moveStraight = true;
        while (!Thread.currentThread().isInterrupted()) {
            if (this.rect.getX() == 295) {
                moveStraight = false;
            }
            if (this.rect.getX() == 0) {
                moveStraight = true;
            }
            if (moveStraight) {
                this.rect.setX(this.rect.getX() + 1);
            } else {
                this.rect.setX(this.rect.getX() - 1);
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
