enum TrafficLightColor {
    RED, GREEN, YELLOW
}

class TrafficLightSimulator implements Runnable {
    private TrafficLightColor tlc;
    private boolean stop = false;
    private boolean changed = false;

    TrafficLightSimulator(TrafficLightColor init) {
        tlc = init;
    }

    TrafficLightSimulator() {
        tlc = TrafficLightColor.RED;
    }

    public void run() {
        while (!stop) {
            try {
                switch (tlc) {
                    case GREEN:
                        Thread.sleep(100);
                        break;
                    case YELLOW:
                        Thread.sleep(200);
                        break;
                    case RED:
                        Thread.sleep(120);
                        break;
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            changeColor();
        }
    }

    // Change color.
    synchronized void changeColor() {
        switch (tlc) {
            case RED:
                tlc = TrafficLightColor.GREEN;
                break;
            case YELLOW:
                tlc = TrafficLightColor.RED;
                break;
            case GREEN:
                tlc = TrafficLightColor.YELLOW;
                break;
        }
        changed = true;
        notify(); // signal that the light has changed
    }

    // Wait until a light change occurs.
    synchronized void waitForChange() {
        try {
            while (!changed) {
                wait(); // wait for light to change
            }
            changed = false;
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    // Return current color.
    synchronized TrafficLightColor getColor() {
        return tlc;
    }

    // Stop the traffic light.
    synchronized void cancel() {
        stop = true;
    }
}

class TrafficLightDemo {
    public static void main(String[] args) {
        TrafficLightSimulator t1 = new TrafficLightSimulator(TrafficLightColor.GREEN);
        Thread thrd = new Thread(t1);
        thrd.start();

        for (int i = 0; i < 9; i++) {
            System.out.println(t1.getColor());
            t1.waitForChange();
        }

        t1.cancel();
    }
}

// GREEN
// YELLOW
// RED
// GREEN
// YELLOW
// RED
// GREEN
// YELLOW
// RED
