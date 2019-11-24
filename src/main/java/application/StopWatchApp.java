package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalTime;

@SpringBootApplication
public class StopWatchApp {
    public static void main(String[] args) {
        System.out.println(LocalTime.now());
        SpringApplication.run(StopWatchApp.class);
    }
}
