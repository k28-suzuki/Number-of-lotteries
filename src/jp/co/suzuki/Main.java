package jp.co.suzuki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int NumOfTimes = 1;

	public static void main(String[] args) {
		Loto lo = new Loto();
		int cnt = 0;

		if(args.length != 0){
			while(cnt < Integer.parseInt(args[0])){
				lo.getLoto6();
				cnt++;
			}
		}else{
			getInput();
			while(cnt < NumOfTimes){
				lo.getLoto6();
				cnt++;
			}
		}
	}

	static void getInput(){
		 InputStreamReader isr = new InputStreamReader(System.in);
		 BufferedReader br = new BufferedReader(isr);

		 System.out.println("施行回数を入力してください");

		 try {
			String str = br.readLine();
			NumOfTimes = Integer.parseInt(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
