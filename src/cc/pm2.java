package cc;

class Base {
	public Base() {
		System.out.println("base called");
	}
	public static void show() {
		System.out.println("Base::show() called");
	}
}

class Derived extends Base {
	public static void show() {
		System.out.println("Derived::show() called");
		System.out.println(a);
	}
}

class pm2 {

	public static void main(String[] args) {
		Base b = new Derived();
		b.show();
	}
}
