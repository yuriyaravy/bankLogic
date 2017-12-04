package bankLogic;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class InternetCurrency {
	
	

	public static Map<Currency, Double> InterCur(){
		try{
		String usd = getCur("USD");
		String eur = getCur("EUR");
		String pln = getCur("PLN");
		Gson gs = new Gson();
		Staff objU = gs.fromJson(usd, InternetCurrency.Staff.class);
		Staff objE = gs.fromJson(eur, InternetCurrency.Staff.class);
		Staff objP = gs.fromJson(pln, InternetCurrency.Staff.class);
		
		Map<Currency, Double> hashMap = new HashMap<Currency, Double>();
		hashMap.put(objU.Cur_Abbreviation, objU.Cur_OfficialRate);
		hashMap.put(objE.Cur_Abbreviation, objE.Cur_OfficialRate);
		hashMap.put(objP.Cur_Abbreviation, objP.Cur_OfficialRate);
		hashMap.put(Currency.BLR, 1.00);
	//	System.out.println(hashMap);
		return (Map)hashMap;
			}catch(IOException e){
				System.out.println(e.getMessage());
			}
		return null;
	}
	public static String getCur(String dsfsdf) throws IOException{
		
		String url = "http://www.nbrb.by/API/ExRates/Rates/"+dsfsdf+"?ParamMode=2";

        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"cp1251"));
        String inputLine;
        StringBuffer response = new StringBuffer();

        	while ((inputLine = in.readLine()) != null) {
        		response.append(inputLine);
        	}
        	in.close();
        	
        	String s = response.toString();
        return s;
	}
	
	public class Staff {
		Currency Cur_Abbreviation;
		double Cur_OfficialRate;
	//	int Cur_ID;
	}
}
