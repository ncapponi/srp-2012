package com.kelkoo.agile.samples;

import java.io.PrintStream;

class Calculator { // this class is only responsible for adding numbers
	public static int add(int x, int y) {
		return x + y;
	}
	
	static class PrintStreamDecider { // this class is only responsible for deciding which
		// PrintStream is to be used
		public static PrintStream getPrintStream() {
			return System.out;
		}
	}
	
	static class ResultPrinter { // this class is only responsible for printing int values
		public static void printResult(int value) {
			PrintStreamDecider.getPrintStream().print(value);
		}
	}
	
	static class CalculatingMachine { // this class is only responsible for processing the
		// add-two-numbers request
		public static void processTheAddCommand(int x, int y) {
			int result = Calculator.add(x, y);
			ResultPrinter.printResult(result);
		}
	}
}

