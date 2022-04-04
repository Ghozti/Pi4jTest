package pisample;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalOutputBuilder;
import com.pi4j.io.gpio.digital.DigitalOutputConfigBuilder;
import com.pi4j.io.gpio.digital.DigitalState;

import java.util.Scanner;

public class BlinkLED {
    public static void main() {
        Context context = Pi4J.newAutoContext();
        DigitalOutputConfigBuilder pinConfig = DigitalOutput.newConfigBuilder(context)
                .id("led pin")
                .name("pin 4")
                .address(4)
                .shutdown(DigitalState.LOW)
                .initial(DigitalState.LOW)
                .provider("pigpio-digital-output");

        DigitalOutput pin = context.create(pinConfig);

        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        while(!exit){
            if (scanner.nextLine().equals("on")){
                pin.high();
            }else if (scanner.nextLine().equals("off")){
                pin.low();
            }else {
                exit = true;
            }
        }
        context.shutdown();
    }
}
