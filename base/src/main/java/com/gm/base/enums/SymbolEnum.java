package com.gm.base.enums;

/**
 * 数学符号枚举
 * @author pqr
 */
public enum SymbolEnum {
	EQU("="), GT(">"), GT_EQU(">="), LESS("<"), LESS_EQU("<="), ADD("+"), MINUS("-"), MULTIPLY("*"), DIVISION("/");

	private String symbol;

	private SymbolEnum(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return this.symbol;
	}
}
