package pl.michalzadrozny.asweek9.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimerAspect {

    private long startTime;
    private long endTime;

    @Before("@annotation(pl.michalzadrozny.asweek9.annotation.Timer)")
    private void timerBeforeMethod() {
        startTime = System.nanoTime();
    }

    @After("@annotation(pl.michalzadrozny.asweek9.annotation.Timer)")
    private void timerAfterMethod() {
        endTime = System.nanoTime();
        long timeElapsed = (endTime - startTime) / 1_000_000;
        System.out.println("Time: " + timeElapsed + "ms");
    }
}
