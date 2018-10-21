package Problem10;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {

	ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

	public void schedule(Runnable r, int delayInSeconds) {
		service.schedule(r, delayInSeconds, TimeUnit.SECONDS);
	}

	public static void main(String... args) {
		var app = new App();
		app.schedule(() -> {
			System.out.println("Hello World!");
		}, 10);
	}
}
