package oops;

class Base {
	int a;
	public Base() {
		a=5;
		System.out.println("base constructor called");
	}
}
class Derived extends Base {
	public Derived() {
		System.out.println(super.a);
		System.out.println("derived constructor called");
	}
}


public class constructor_examples {

	public static void main(String[] args) {
		Derived derived = new Derived();
	}

}
