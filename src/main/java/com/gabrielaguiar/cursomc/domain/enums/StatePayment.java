package com.gabrielaguiar.cursomc.domain.enums;

public enum StatePayment {
	
	PENDENTE (1, "Pendente"),QUITADO(2, "Quitado"),CANCELADO(3, "Cancelado");
	
	private int cod;
	private String description;

	private StatePayment(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public static StatePayment toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (StatePayment x : StatePayment.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Invalid id: " + cod);

	}

}
