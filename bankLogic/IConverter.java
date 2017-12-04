package bankLogic;

public  interface IConverter {
	
	double fromCurrencytoBLR(double summ, Currency cur);
	double fromBLRtoCarrency(double summ, Currency cur);
	double fromCarrencyToCarrency (double summa, Currency from , Currency to);

}
