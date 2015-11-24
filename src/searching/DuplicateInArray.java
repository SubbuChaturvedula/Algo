package searching;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DuplicateInArray {

	public static void main(String[] args) {
		int a[]=new int[]{3,2,1,2,2,3};
		findDuplicate(a);
		firstRepeated(a);
	}

	public static void findDuplicate(int a[]){
		Map<Integer,Integer>map=new HashMap<Integer,Integer>();
		int max=0,value=0;
		for(int i=0;i<a.length;i++){
			Integer count=map.get(a[i])==null?0:map.get(a[i]);
			map.put(a[i], count+1);	
		}
		for(Entry<Integer, Integer> entry:map.entrySet())
		{
			if(entry.getValue()>max){
				max=entry.getValue();
				value=entry.getKey();
			}
			
		}
		//System.err.println(map.toString());
		//System.out.println("Value: "+value+" Repeats: "+max);
	}
	public static void firstRepeated(int a[]){
		Set<Integer> set=new HashSet<Integer>();
		int index=-1;
		for(int i=a.length-1;i>=0;i--){
			if(set.contains(a[i])){
				index=i;
			}else{
				set.add(a[i]);
			}
		}
		System.out.println(a[index]);
	}
}
