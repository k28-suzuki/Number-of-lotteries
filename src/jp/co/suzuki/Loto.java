package jp.co.suzuki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Loto {

	List<Integer> targetList = new ArrayList<>();
	ArrayList<Integer> HitNum = new ArrayList<Integer>();
	Loto(){
		init();
	}

	String getLoto6(){

		String str = "";

		Collections.shuffle(targetList);
		int cnt = 0;
		while(cnt < 6){
			HitNum.add(targetList.get(cnt));
			cnt++;
		}
		Collections.sort(HitNum);
		cnt = 0;
		for(int num : HitNum){
			if(cnt <= 4){
				str = str + num+",";
//				System.out.print(num + ",");
			}else{
				str = str + num;
//				System.out.print(num);
			}
			cnt++;
		}
		str = str + "\n";
//		System.out.print("\n");

		HitNum.clear();
		return str;
	}

	//初期処理
	void init(){
		for(int i= 1; i <= 46; i++){
			targetList.add(i);
		}
	}
}
