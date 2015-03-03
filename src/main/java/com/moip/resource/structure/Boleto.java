package com.moip.resource.structure;

public class Boleto {
	class InstructionLines {
		private String first;
		private String second;
		private String third;

		public String getFirst() {
			return first;
		}

		public void setFirst(String first) {
			this.first = first;
		}

		public String getSecond() {
			return second;
		}

		public void setSecond(String second) {
			this.second = second;
		}

		public String getThird() {
			return third;
		}

		public void setThird(String third) {
			this.third = third;
		}
	}

	private String linecode;
	private String expirationDate;
	private InstructionLines instrucionLines;
	private String logoUri;

	public String getLinecode() {
		return linecode;
	}

	public void setLinecode(String linecode) {
		this.linecode = linecode;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public void setFirstInstructionLine(String first) {
		if (instrucionLines == null) {
			instrucionLines = new InstructionLines();
		}

		instrucionLines.setFirst(first);
	}

	public void setSecondInstructionLine(String second) {
		if (instrucionLines == null) {
			instrucionLines = new InstructionLines();
		}

		instrucionLines.setSecond(second);
	}

	public void setThirdInstructionLine(String third) {
		if (instrucionLines == null) {
			instrucionLines = new InstructionLines();
		}

		instrucionLines.setThird(third);
	}

	public InstructionLines getInstructionLines() {
		return instrucionLines;
	}

	public String getLogoUri() {
		return logoUri;
	}

	public void setLogoUri(String logoUri) {
		this.logoUri = logoUri;
	}
}
