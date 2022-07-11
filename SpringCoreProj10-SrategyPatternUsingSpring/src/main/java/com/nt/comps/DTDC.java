// DTDC.java (Dependent class3)

package com.nt.comps;

public final class DTDC implements Courier { // rule 2 (implementation Courier(I))
	// -- rule3 taking the class as final class
	public DTDC() {
		System.out.println("DTDC :: 0-param constructor");
	}

	public String deliver(int orderId) {
		return "order id :: " + orderId + " products are set to deliver using DTDC Courier service";
	}

}
