package br.arantes.util;

public class Pagination {
	private static final int SMPAGESIZE = 100;
	private static final int MDPAGESIZE = 1000;
	private static final int BGPAGESIZE = 5000;

	public static int getSmpagesize() {
		return SMPAGESIZE;
	}

	public static int getMdpagesize() {
		return MDPAGESIZE;
	}

	public static int getBgpagesize() {
		return BGPAGESIZE;
	}

}
