package bankTransferTest;

import org.junit.Assert;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import bankLogic.ConverterInternetImplements;
import bankLogic.Currency;
import bankLogic.IConverter;

public class ConvertInterImplemTest {
	
	@Test
	public void testFromCurrencytoBLR() {
		IConverter con = new ConverterInternetImplements ();
	    double s1 = con.fromCurrencytoBLR(10, Currency.EUR); // EUR = 2.3646
	    if(s1 != 23.646){
	    	Assert.fail();
	    }
	}

	@Test
	public void testFromBLRtoCarrency() {
		IConverter con = new ConverterInternetImplements ();
	    double s1 = con.fromBLRtoCarrency(10, Currency.EUR);
	    if(s1 != 4.22904508){										// = 4,22904508
	    	Assert.fail();
	    }
	}
	

	@Test
	public void testFromCarrencyToCarrency() {
		IConverter con = new ConverterInternetImplements ();
		double sumBLR = con.fromCarrencyToCarrency(10, Currency.BLR, Currency.EUR);
		if(sumBLR != 23.646){
	    	Assert.fail();
		}
	}
}
