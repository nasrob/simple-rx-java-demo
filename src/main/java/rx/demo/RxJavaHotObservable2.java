package rx.demo;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class RxJavaHotObservable2 {

	public static void main(String[] args) {
		
		Observable<Long> observableInt = Observable.interval(2, TimeUnit.SECONDS);
		
		ConnectableObservable<Long> connectableObservable = observableInt.publish();
		connectableObservable.subscribe(i -> System.out.println("Observable #1 : " + i));
		
		connectableObservable.connect();
		
		addDelay(7000);
		
		connectableObservable.subscribe(i -> System.out.println("Observable #2 : " + i));
		
		addDelay(10000);
	}
	
	private static void addDelay(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
