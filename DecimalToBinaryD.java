package hust.xican;

public class DecimalToBinaryD {
	/*public  int  NumberOf1(int n) {
        if(n==0)return 0;
    else if(n>0){
    	return count(n);
    }
    else{
    	n=Math.abs(n);
    	n=(~n)+1;
    	return count(n);
    }
 }
	public static int count(int n) {
		int a=1;
    	int b =0;
    	int count=0;
    	while(a!=0){
    		a = n/2;
         	b = n%2;
         	if(b==1)count++;
         	n=a;
    	}
    	return count;
	}*/
	/*输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
	 * 
	 * 直接采用位移，计算机里面负数本身就是补码表示，不用转换
	 * */
	public static int  NumberOf1(int n) {
		int count=0;
		for(int i=0;i<32;i++){
			if(((n>>i)&1)!=0)count++;
		}
		return count;
	}

	public static void main(String[] args) {
		 System.out.println(NumberOf1(11));

	}

}
