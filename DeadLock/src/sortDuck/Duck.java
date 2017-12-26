package sortDuck;

public class Duck implements Comparable {
	String name;
	int weight;
	

	public Duck(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return name+" weighs "+weight;
	}

	@Override
	public int compareTo(Object o) {
		Duck otherDck = (Duck)o;
		if (this.weight < otherDck.weight) {
			return 1;
		} else if (this.weight == otherDck.weight) {
			return 0;
		}
		return -1;
	}

}
