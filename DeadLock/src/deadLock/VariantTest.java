package deadLock;

public class VariantTest{
    public static int staticVar = 0;
    public int instanceVar = 0;
    public void VariantTest(){
        staticVar++;
        instanceVar++;
        System.out.println("staticVar:"+staticVar+"\ninstanceVar:"+instanceVar);
    }
    public static void main(String[] args) {
		VariantTest v = new VariantTest();
		v.VariantTest();
		
		VariantTest v1 = new VariantTest();
		v1.VariantTest();
		
		System.out.println(Math.round(-101.5));
	}

}