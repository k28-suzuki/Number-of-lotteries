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

	void getLoto6(){



		Collections.shuffle(targetList);
		int cnt = 0;
		while(cnt < 6){
			HitNum.add(targetList.get(cnt));
			cnt++;
		}
		Collections.sort(HitNum);
		for(int num : HitNum){
		System.out.print(num + " ");
		}
		System.out.print("\n");

		HitNum.clear();
	}

	//初期処理
	void init(){
		for(int i= 1; i < 46; i++){
			targetList.add(i);
		}
	}
}
