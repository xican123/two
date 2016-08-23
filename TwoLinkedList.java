package hust.xican;

import java.util.Scanner;
/*输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则*/
public class TwoLinkedList {

	class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	/*first connect the two linkedlist 
	using the quick sort methond*/
	public ListNode Merge1(ListNode list1,ListNode list2) {
		ListNode p,q,list,temp=null;
		ListNode head = list1;
	
		if(list1==null)return list2;
		if(list2==null)return list1;
		//链接list1 and list2
        while(list1!=null){
        	 if(list1.next==null)break;
        	list1 = list1.next;
        }
        list1.next=list2;
        //quick sort
        list=head;
        q=list;
        list = list.next;
        p=list;               
        
        
        while(q!=null){
        	int min = q.val;
        	temp=q;
        	while(p!=null){
        		if(p.val<min){
        			min = p.val; 
        			temp = p;
        		}
        		
        		p=p.next;
        	}
        	 
        	temp.val =q.val;
        	q.val=min;
        	if(list.next==null)break;
        	list=list.next;
        	p=list;
        	q=q.next;
        }
        return head;
        
    }
	/*public static int [] ssort(int a[]){
		for(int i=0;i<a.length;i++){
			int min=a[i];
			int k=i;//k的最初值必须指向最小的那个坐标，因为后面会出现min本身就是最小值，即本身以原坐标进行交换
			for(int j=i+1;j<a.length;j++){
				if(a[j]<min){
					min=a[j];
					k=j;
				}								
			}
			int temp = a[i];
			a[i]=a[k];
			a[k]=temp;
		}
		return a;
		
	}
	*/
	/*递归调用*/
	public ListNode Merge(ListNode list1,ListNode list2) {
		if(list1==null)return list2;
		if(list2==null)return list1;
		ListNode headList = null;
		if(list1.val<list2.val){
			headList = list1;
			headList.next = Merge(list1.next, list2);
		}else {
			headList = list2;
			headList.next = Merge(list2.next, list1);
		}
		return headList;
	}
	
	
	public static void main(String[] args) {
		TwoLinkedList twoLinkedList = new TwoLinkedList();
		ListNode list1 = twoLinkedList.new ListNode(0);
		ListNode head =list1;
		ListNode list2 = twoLinkedList.new ListNode(0);
		ListNode head2 =list2;
		Scanner input = new Scanner(System.in);
		/*while(input.hasNextInt()){
			 
			ListNode q = twoLinkedList.new ListNode(input.nextInt());
			
			head.next=q;
			head =head.next;
			  
		}*/
		for(int i=0;i<5;i++){
			ListNode q = twoLinkedList.new ListNode(input.nextInt());
			
			head.next=q;
			head =head.next;
			q  = twoLinkedList.new ListNode(input.nextInt());
			
			head2.next=q;
			head2 =head2.next;
		}
		ListNode c = twoLinkedList.Merge1(list1, list2);
		while(c!=null){
			System.out.println(c.val);
			c=c.next;
		}

	}
		/*int a[]={9,4,2,7,4,0,2,6};
		a=ssort(a);
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
	}*/
}
