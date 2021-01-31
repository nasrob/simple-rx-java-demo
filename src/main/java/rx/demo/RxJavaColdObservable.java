package rx.demo;

import io.reactivex.Observable;

public class RxJavaColdObservable {
	
	// cold observable => data created by the Observable itself
	public static void main(String[] args) {
		Observable<String> source = Observable.just("One", "Two", "Three", "Four", "Five");
		
		// first Observer
		source.filter(data -> data.contains("o"))
			.subscribe(data -> System.out.println("Observer 1 Received: " + data));
		
		// second observer
		source.subscribe(data -> System.out.println("Observer 2 Received: " + data));
		
	}
}
