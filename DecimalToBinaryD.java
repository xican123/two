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
	/*����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ
	 * 
	 * ֱ�Ӳ���λ�ƣ���������渺��������ǲ����ʾ������ת��
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
