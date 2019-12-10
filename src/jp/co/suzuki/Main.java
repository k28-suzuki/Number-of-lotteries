package jp.co.suzuki;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	static int NumOfTimes = 1;

	static FileWriter fw;

	public static void main(String[] args) throws IOException {
		Loto lo = new Loto();
		int cnt = 0;

		fw = new FileWriter("./tmp/loto.txt",true);

		if(args.length != 0){
			while(cnt < Integer.parseInt(args[0])){
				fw.write(lo.getLoto6());
				cnt++;
			}
		}else{
			getInput();
			while(cnt < NumOfTimes){
				fw.write(lo.getLoto6());
				cnt++;
			}
		}
		fw.close();

		getFileRead();

	}

	private static void getFileRead() throws IOException {


		File file = new File("./tmp/loto.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);


		int numnum[] = new int [46];

		//空の配列作成
		List<List<Integer>> DataName = new ArrayList<List<Integer>>();

		String str = "";
		String data[] = new String [6];
		for(int i = 0; i <= 46; i++){
			DataName.add(Arrays.asList(i,0));
		}

		while((str = br.readLine()) != null) {
			data = str.split(",");
			int cnt = 0;

			for(String num : data){
				numnum[Integer.parseInt(num)-1] = numnum[Integer.parseInt(num)-1]+1;
			}
		}

		int cn = 0;
		for(int i = 1; i < DataName.size(); i++){
			//System.out.println("Data: "+DataName.get(i));
			System.out.println("Data: "+ i + " "+ numnum[i-1]);

		}
		int result = 0;
		for(int num : numnum){
			result = result + num;
		}

		fw = new FileWriter("./tmp/log.txt",false);

		//ヘッダー
		fw.write("int,val,probability\n");

		int ccnt = 1;
		String str2 = "";
		for(int num : numnum){
			fw.write(ccnt+","+	num + "," + (String.format("%.2f",((double)num /(double)result)*100)) + "%" + "\n");
			ccnt++;
		}

		fw.close();
		br.close();
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
