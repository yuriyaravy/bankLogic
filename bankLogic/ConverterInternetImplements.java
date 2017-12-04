package bankLogic;
import java.util.Map;

public class ConverterInternetImplements implements IConverter{
	
		Map<Currency, Double> curMap = InternetCurrency.InterCur();
		
		
	public double fromCurrencytoBLR(double summ, Currency cur){
		if(cur == Currency.BLR){
			return summ;
		}else{
			return summ*curMap.get(cur);
		}
	}	
	public double fromBLRtoCarrency(double summ, Currency cur){
		if(cur == Currency.BLR){
			return summ;
		}else{
			return summ/curMap.get(cur);
		}
	}	
	public double fromCarrencyToCarrency (double summa, Currency from , Currency to){
		double summaInBLR = fromCurrencytoBLR(summa, from);
		return fromBLRtoCarrency(summaInBLR, to);
	}
}
