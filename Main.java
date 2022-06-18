import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String poker[] = {"1-A","1-B","1-C","1-D","2-A","2-B","2-C","2-D","3-A","3-B","3-C","3-D",
				"4-A","4-B","4-C","4-D","5-A","5-B","5-C","5-D","6-A","6-B","6-C","6-D","7-A","7-B","7-C","7-D",
				"8-A","8-B","8-C","8-D","9-A","9-B","9-C","9-D","10-A","10-B","10-C","10-D","11-A","11-B","11-C","11-D",
				"12-A","12-B","12-C","12-D","13-A","13-B","13-C","13-D"};
		
		// Royal_StraightFlush同花大順 Straight_Flush同花順 Four_kind四條 Full_house葫蘆 Flush同花
		// Straight順子 Three_kind三條 Two_pair兩對 Pair一對 High_card高牌
		
		int Royal_StraightFlush=0;int Straight_Flush=0;int Four_kind=0;int Full_house=0;int Flush=0;
		int Straight=0;int Three_kind=0;int Two_pair=0;int Pair=0;int High_card=0;
        
        int times = 0;
        System.out.println("請問要執行幾次");
        int n = sc.nextInt();
        
		while(times<n) {
			String hand = "手牌：";
			String public_card = "公牌：";
			int card[] = {-1,-1,-1,-1,-1,-1,-1};
	        for(int i=0;i<7;i++) {
	        	int num=0;
	        	boolean flag = false;
	        	while(flag==false) {
	        		num = (int)(Math.random()*52);
	        		for(int j=0;j<7;j++) {
	        			if(card[j]==num) {
	        				break;
	        			}else if(j==6&&card[j]!=num) {
	        				flag = true;
	        			}
	        		}
	        	}
	        	card[i] = num;
	        	if(i==1||i==0) 
					hand +=poker[num]+" ";
	        	else 
	        		public_card+=poker[num]+" ";
	        }
	        
	        System.out.print(hand+" "+public_card);
	        String list="";
	        Arrays.sort(card);
	        for(int j=0;j<7;j++) {
	        	list+=poker[card[j]]+" ";
	        }
	        
	        boolean flag = false;
	        
	        if(Royal_str(list)==true&&flag==false) {
	        	System.out.println(" 同花大順!");
	        	flag = true;
	        	Royal_StraightFlush++;
	        }
	        else if(Comman_str(list)==true&&flag==false) {
	        	System.out.println(" 同花順!");
	        	flag = true;
	        	Straight_Flush++;
	        }
	        else if(four_str(list)==true&&flag==false) {
	        	System.out.println(" 四條!");
	        	flag = true;
	        	Four_kind++;
	        }
	        else if(fullhouse(list)==true&&flag==false) {
	        	System.out.println(" 葫蘆!");
	        	flag = true;
	        	Full_house++;
	        }
	        else if(flush(list)==true&&flag==false) {
	        	System.out.println(" 順子!");
	        	flag = true;
	        	Flush++;
	        }
	        else if(straight(list)==true&&flag==false) {
	        	System.out.println(" 同花!");
	        	flag = true;
	        	Straight++;
	        }
	        else if(three_str(list)==true&&flag==false) {
	        	System.out.println(" 三條!");
	        	flag = true;
	        	Three_kind++;
	        }
	        else if(twopair(list)==true&&flag==false) {
	        	System.out.println(" 兩對!");
	        	flag = true;
	        	Two_pair++;
	        }
	        else if(pair(list)==true&&flag==false) {
	        	System.out.println(" 一對!");
	        	flag = true;
	        	Pair++;
	        }
	        else {
	        	System.out.println(" 高牌!");
	        	flag = true;
	        	High_card++;
	        }
	        
	        times++;
		}

        
		double percentage = Royal_StraightFlush/(double)n*100;
	    System.out.println("同花大順次數："+Royal_StraightFlush+" 占比："+percentage+"%");
	        
	    percentage = Straight_Flush/(double)n*100;
	    System.out.println("同花順次數："+Straight_Flush+" 占比："+percentage+"%");
	        
	    percentage = Four_kind/(double)n*100;
	    System.out.println("四條次數："+Four_kind+" 占比："+percentage+"%");
	        
	    percentage = Full_house/(double)n*100;
	    System.out.println("葫蘆次數："+Full_house+" 占比："+percentage+"%");
	        
	    percentage = Flush/(double)n*100;
	    System.out.println("同花次數："+Flush+" 占比："+percentage+"%");
	        
	    percentage = Straight/(double)n*100;
	    System.out.println("順子次數："+Straight+" 占比："+percentage+"%");
	        
	    percentage = Three_kind/(double)n*100;
	    System.out.println("三條次數："+Three_kind+" 占比："+percentage+"%");
	        
	    percentage = Two_pair/(double)n*100;
	    System.out.println("兩對次數："+Two_pair+" 占比："+percentage+"%");
	        
	    percentage = Pair/(double)n*100;
	    System.out.println("一對次數："+Pair+" 占比："+percentage+"%");
	        
	    percentage = High_card/(double)n*100;
	    System.out.println("高牌次數："+High_card+" 占比："+percentage+"%");

	}
	
	
	static boolean Royal_str(String list) {
	    String[] arr = list.split(" ");
		ArrayList<String> A = new ArrayList<String>();
		ArrayList<String> B = new ArrayList<String>();
		ArrayList<String> C = new ArrayList<String>();
		ArrayList<String> D = new ArrayList<String>();
	    for(int i=0;i<7;i++) {
	    	int num = Integer.valueOf(arr[i].split("-")[0]);
	    	if(num==1||num==10||num==11||num==12||num==13) {
	    		if(arr[i].contains("A"))
	    			A.add(arr[i]);
	    		else if(arr[i].contains("B"))
	    			B.add(arr[i]);
	    		else if(arr[i].contains("C"))
	    			C.add(arr[i]);
	    		else
	    			D.add(arr[i]);
	    	}	
	    }
	    
	    if(A.size()==5) 
	    	return true;
	    else if(B.size()==5)
	    	return true;
	    else if(C.size()==5)
	    	return true;
	    else if(D.size()==5)
	    	return true;
	    else
	    	return false;
	   
	}

	static boolean Comman_str(String list) {
	    String[] arr = list.split(" ");
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();
		ArrayList<Integer> C = new ArrayList<Integer>();
		ArrayList<Integer> D = new ArrayList<Integer>();
	    for(int i=0;i<7;i++) {
	    	int num = Integer.valueOf(arr[i].split("-")[0]);
	    	if(arr[i].contains("A"))
	    		A.add(num);
	    	else if(arr[i].contains("B"))
	    		B.add(num);
	    	else if(arr[i].contains("C"))
	    		C.add(num);
	    	else
	    		D.add(num);	
	    }
	    
	    if(A.size()>=5) {
	    	if(A.size()==5) {
	    		if(A.get(0)==1&&A.get(1)==10&&A.get(2)==11&&A.get(3)==12&&A.get(4)==13)
	    			return true;
	    		for(int i=1;i<5;i++) {
	    			if(A.get(i-1)-A.get(i)!=1)
	    				return false;
	    		}
	    		return true;
	    	}else if(A.size()==6) {
	    		if(A.get(0)==1&&A.get(5)==13) {
	    			int count = 0;
	    			for(int i=1;i<5;i++) {
	    				if(A.get(i)==10||A.get(i)==11||A.get(i)==12)
	    					count++;
	    			}
	    			if(count==3)
	    				return true;
	    		}
	    		else {
		    		for(int i=1;i<6;i++) {
		    			if(A.get(i-1)-A.get(i)!=1)
		    				break;
		    			else if(i==5) 
		    				return true;
		    		}
		    		for(int i=2;i<7;i++) {
		    			if(A.get(i-1)-A.get(i)!=1)
		    				break;
		    			else if(i==6) 
		    				return true;
		    		}
		    		return false;
	    		}
	    	}else{
	    		if(A.get(0)==1&&A.get(6)==13) {
	    			int count = 0;
	    			for(int i=1;i<6;i++) {
	    				if(A.get(i)==10||A.get(i)==11||A.get(i)==12)
	    					count++;
	    			}
	    			if(count==3)
	    				return true;
	    		}
	    		else {
		    		for(int i=1;i<6;i++) {
		    			if(A.get(i-1)-A.get(i)!=1)
		    				break;
		    			else if(i==6) 
		    				return true;
		    		}
		    		for(int i=1;i<6;i++) {
		    			if(A.get(i-1)-A.get(i)!=1)
		    				break;
		    			else if(i==6) 
		    				return true;
		    		}
		    		for(int i=1;i<6;i++) {
		    			if(A.get(i-1)-A.get(i)!=1)
		    				break;
		    			else if(i==6) 
		    				return true;
		    		}
		    		return false;
	    		}
	    	}
	    }
	    else if(B.size()>=5) {
	    	if(B.size()==5) {
	    		if(B.get(0)==1&&B.get(1)==10&&B.get(2)==11&&B.get(3)==12&&B.get(4)==13)
	    			return true;
	    		for(int i=1;i<5;i++) {
	    			if(B.get(i-1)-B.get(i)!=1)
	    				return false;
	    		}
	    		return true;
	    	}else if(B.size()==6) {
	    		if(B.get(0)==1&&B.get(5)==13) {
	    			int count = 0;
	    			for(int i=1;i<5;i++) {
	    				if(B.get(i)==10||B.get(i)==11||B.get(i)==12)
	    					count++;
	    			}
	    			if(count==3)
	    				return true;
	    		}
	    		else {
		    		for(int i=1;i<6;i++) {
		    			if(B.get(i-1)-B.get(i)!=1)
		    				break;
		    			else if(i==5) 
		    				return true;
		    		}
		    		for(int i=2;i<7;i++) {
		    			if(B.get(i-1)-B.get(i)!=1)
		    				break;
		    			else if(i==6) 
		    				return true;
		    		}
		    		return false;
	    		}
	    	}else{
	    		if(B.get(0)==1&&B.get(6)==13) {
	    			int count = 0;
	    			for(int i=1;i<6;i++) {
	    				if(B.get(i)==10||B.get(i)==11||B.get(i)==12)
	    					count++;
	    			}
	    			if(count==3)
	    				return true;
	    		}
	    		else {
		    		for(int i=1;i<6;i++) {
		    			if(B.get(i-1)-B.get(i)!=1)
		    				break;
		    			else if(i==6) 
		    				return true;
		    		}
		    		for(int i=1;i<6;i++) {
		    			if(B.get(i-1)-B.get(i)!=1)
		    				break;
		    			else if(i==6) 
		    				return true;
		    		}
		    		for(int i=1;i<6;i++) {
		    			if(B.get(i-1)-B.get(i)!=1)
		    				break;
		    			else if(i==6) 
		    				return true;
		    		}
		    		return false;
	    		}
	    	}
	    }
	    else if(C.size()>=5) {
	    	if(C.size()==5) {
	    		if(C.get(0)==1&&C.get(1)==10&&C.get(2)==11&&C.get(3)==12&&C.get(4)==13)
	    			return true;
	    		for(int i=1;i<5;i++) {
	    			if(C.get(i-1)-C.get(i)!=1)
	    				return false;
	    		}
	    		return true;
	    	}else if(C.size()==6) {
	    		if(C.get(0)==1&&C.get(5)==13) {
	    			int count = 0;
	    			for(int i=1;i<5;i++) {
	    				if(C.get(i)==10||C.get(i)==11||C.get(i)==12)
	    					count++;
	    			}
	    			if(count==3)
	    				return true;
	    		}
	    		else {
		    		for(int i=1;i<6;i++) {
		    			if(C.get(i-1)-C.get(i)!=1)
		    				break;
		    			else if(i==5) 
		    				return true;
		    		}
		    		for(int i=2;i<7;i++) {
		    			if(C.get(i-1)-C.get(i)!=1)
		    				break;
		    			else if(i==6) 
		    				return true;
		    		}
		    		return false;
	    		}
	    	}else{
	    		if(C.get(0)==1&&C.get(6)==13) {
	    			int count = 0;
	    			for(int i=1;i<6;i++) {
	    				if(C.get(i)==10||C.get(i)==11||C.get(i)==12)
	    					count++;
	    			}
	    			if(count==3)
	    				return true;
	    		}
	    		else {
		    		for(int i=1;i<6;i++) {
		    			if(C.get(i-1)-C.get(i)!=1)
		    				break;
		    			else if(i==6) 
		    				return true;
		    		}
		    		for(int i=1;i<6;i++) {
		    			if(C.get(i-1)-C.get(i)!=1)
		    				break;
		    			else if(i==6) 
		    				return true;
		    		}
		    		for(int i=1;i<6;i++) {
		    			if(C.get(i-1)-C.get(i)!=1)
		    				break;
		    			else if(i==6) 
		    				return true;
		    		}
		    		return false;
	    		}
	    	}
	    }
	    else if(D.size()>=5) {
	    	if(D.size()==5) {
	    		if(D.get(0)==1&&D.get(1)==10&&D.get(2)==11&&D.get(3)==12&&D.get(4)==13)
	    			return true;
	    		for(int i=1;i<5;i++) {
	    			if(D.get(i-1)-D.get(i)!=1)
	    				return false;
	    		}
	    		return true;
	    	}else if(D.size()==6) {
	    		if(D.get(0)==1&&D.get(5)==13) {
	    			int count = 0;
	    			for(int i=1;i<5;i++) {
	    				if(D.get(i)==10||D.get(i)==11||D.get(i)==12)
	    					count++;
	    			}
	    			if(count==3)
	    				return true;
	    		}
	    		else {
		    		for(int i=1;i<6;i++) {
		    			if(D.get(i-1)-D.get(i)!=1)
		    				break;
		    			else if(i==5) 
		    				return true;
		    		}
		    		for(int i=2;i<7;i++) {
		    			if(D.get(i-1)-D.get(i)!=1)
		    				break;
		    			else if(i==6) 
		    				return true;
		    		}
		    		return false;
	    		}
	    	}else{
	    		if(D.get(0)==1&&D.get(6)==13) {
	    			int count = 0;
	    			for(int i=1;i<6;i++) {
	    				if(D.get(i)==10||D.get(i)==11||D.get(i)==12)
	    					count++;
	    			}
	    			if(count==3)
	    				return true;
	    		}
	    		else {
		    		for(int i=1;i<6;i++) {
		    			if(D.get(i-1)-D.get(i)!=1)
		    				break;
		    			else if(i==6) 
		    				return true;
		    		}
		    		for(int i=1;i<6;i++) {
		    			if(D.get(i-1)-D.get(i)!=1)
		    				break;
		    			else if(i==6) 
		    				return true;
		    		}
		    		for(int i=1;i<6;i++) {
		    			if(D.get(i-1)-D.get(i)!=1)
		    				break;
		    			else if(i==6) 
		    				return true;
		    		}
		    		return false;
	    		}
	    	}
	    }
	    else
	    	return false;
		return false;
	    
	}
	
	static boolean four_str(String list) {
		String[] arr = list.split(" ");
		int count[] = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		for(int i=0;i<7;i++) {
			int num = Integer.valueOf(arr[i].split("-")[0]);
			count[num-1]++;
		}
		for(int i=0;i<count.length;i++)
			if(count[i]==4)
				return true;
		return false;
	}
	
	static boolean fullhouse(String list) {
		String[] arr = list.split(" ");
		int count[] = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		for(int i=0;i<7;i++) {
			int num = Integer.valueOf(arr[i].split("-")[0]);
			count[num-1]++;
		}
		boolean f1 = false;
		boolean f2 = false;
		for(int i=0;i<count.length;i++) {
			if(count[i]==3&&f1==false)
				f1 = true;
			else if(count[i]==2&&f2==false)
				f2 = true;
		}
		if(f1==true&&f2==true)
			return true;
		else
			return false;
	}
	
	static boolean flush(String list) {
		String[] arr = list.split(" ");
		int count[] = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		for(int i=0;i<7;i++) {
			int num = Integer.valueOf(arr[i].split("-")[0]);
			count[num-1]++;
		}
		
		if(count[0]!=0&&count[1]!=0&&count[2]!=0&&count[3]!=0&&count[4]!=0) {
			return true;
		}
		else if(count[1]!=0&&count[2]!=0&&count[3]!=0&&count[4]!=0&&count[5]!=0) {
			return true;
		}
		else if(count[2]!=0&&count[3]!=0&&count[4]!=0&&count[5]!=0&&count[6]!=0) {
			return true;
		}
		else if(count[3]!=0&&count[4]!=0&&count[5]!=0&&count[6]!=0&&count[7]!=0) {
			return true;
		}
		else if(count[4]!=0&&count[5]!=0&&count[6]!=0&&count[7]!=0&&count[8]!=0) {
			return true;
		}
		else if(count[5]!=0&&count[6]!=0&&count[7]!=0&&count[8]!=0&&count[9]!=0) {
			return true;
		}
		else if(count[6]!=0&&count[7]!=0&&count[8]!=0&&count[9]!=0&&count[10]!=0) {
			return true;
		}
		else if(count[7]!=0&&count[8]!=0&&count[9]!=0&&count[10]!=0&&count[11]!=0) {
			return true;
		}
		else if(count[8]!=0&&count[9]!=0&&count[10]!=0&&count[11]!=0&&count[12]!=0) {
			return true;
		}
		else
			return false;
	}
	
	static boolean straight(String list) {
		 String[] arr = list.split(" ");
			ArrayList<Integer> A = new ArrayList<Integer>();
			ArrayList<Integer> B = new ArrayList<Integer>();
			ArrayList<Integer> C = new ArrayList<Integer>();
			ArrayList<Integer> D = new ArrayList<Integer>();
		    for(int i=0;i<7;i++) {
		    	int num = Integer.valueOf(arr[i].split("-")[0]);
		    	if(arr[i].contains("A"))
		    		A.add(num);
		    	else if(arr[i].contains("B"))
		    		B.add(num);
		    	else if(arr[i].contains("C"))
		    		C.add(num);
		    	else
		    		D.add(num);	
		    }
		    if(A.size()>=5||B.size()>=5||C.size()>=5||D.size()>=5)
		    	return true;
		    else
		    	return false;
	}
	
	static boolean three_str(String list) {
		String[] arr = list.split(" ");
		int count[] = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		for(int i=0;i<7;i++) {
			int num = Integer.valueOf(arr[i].split("-")[0]);
			count[num-1]++;
		}
		for(int i=0;i<count.length;i++)
			if(count[i]==3)
				return true;
		return false;
	}
	
	static boolean twopair(String list) {
		String[] arr = list.split(" ");
		int count[] = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		for(int i=0;i<7;i++) {
			int num = Integer.valueOf(arr[i].split("-")[0]);
			count[num-1]++;
		}
		int num = 0;
		for(int i=0;i<count.length;i++)
			if(count[i]==2)
				num++;
		if(num>=2)
			return true;
		else
			return false;
	}
	
	static boolean pair(String list) {
		String[] arr = list.split(" ");
		int count[] = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		for(int i=0;i<7;i++) {
			int num = Integer.valueOf(arr[i].split("-")[0]);
			count[num-1]++;
		}
		int num = 0;
		for(int i=0;i<count.length;i++)
			if(count[i]==2)
				num++;
		if(num==1)
			return true;
		else
			return false;
	}
}