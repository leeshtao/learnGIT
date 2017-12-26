import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetRemove {

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(0);
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(6);
		set.add(7);
		set.add(8);
		set.add(9);
		/**
		 * 错误的方法
		 */
//		for(Integer i : set){
//			if (i%2==0) {
//				set.remove(i);
//			}
//		}
		/**
		 * 正确的方法
		 */
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			Integer i = it.next();
			if (i%2==0) {
				it.remove();
			}
		}
		
		for(Integer i : set){
			System.out.println(i);
		}
	}
}
