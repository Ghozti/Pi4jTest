import com.pi4j.io.gpio.*;

public class Main {
    public static void main(String[] args) {
        GpioController factory = GpioFactory.getInstance();

        GpioPinDigitalOutput pin = factory.provisionDigitalOutputPin(RaspiPin.GPIO_04,"LED", PinState.LOW);
        pin.setShutdownOptions(true, PinState.LOW);

        try {
            // toggle pin state for 25 times
            for (int i = 0; i < 25; i++) {
                pin.toggle();
                Thread.sleep(2500);
            }
            // done shut down the GPIO controller now
            factory.shutdown();
        } catch (InterruptedException e) {
        }
    }
}
