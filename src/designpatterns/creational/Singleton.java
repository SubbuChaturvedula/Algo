package designpatterns.creational;


public class Singleton {

	private static volatile Singleton _instance;

	private Singleton(){}
	/**
	 * * Double checked locking code on Singleton * @return Singleton instance
	 */
	public static Singleton getInstance() {
		if (_instance == null) {
			synchronized (Singleton.class) {
				if (_instance == null) {
					_instance = new Singleton();
				}
			}
		}
		return _instance;
	}
}

