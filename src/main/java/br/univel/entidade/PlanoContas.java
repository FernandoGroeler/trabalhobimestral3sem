package br.univel.entidade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlanoContas {
	private int idPlanoContas;
	private String descricao;
	private String conta;
	private BigDecimal valor;
	private List<PlanoContas> filhas;
	private int levelId;
	
	public int getIdPlanoContas() {
		return this.idPlanoContas;
	}
	public void setIdPlanoContas(int idPlanoContas) {
		this.idPlanoContas = idPlanoContas;
	}
	public String getDescricao() {
		return this.descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getConta() {
		return this.conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public List<PlanoContas> getFilhas() {
		return filhas;
	}
	public void setFilhas(List<PlanoContas> filhas) {
		this.filhas = filhas;
	}
	public int getLevelId() {
		return levelId;
	}
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	
	private PlanoContas getFilha(int i) {
		PlanoContas filha = null;

		if (filhas == null) {
			filhas = new ArrayList<PlanoContas>();
		}

		for (PlanoContas c : filhas) {
			if (c.getLevelId() == i) {
				filha = c;
			}
		}

		if (filha == null) {
			filha = new PlanoContas();
			filha.setLevelId(i);
			filhas.add(filha);
		}

		return filha;
	}	
	
	public void add(PlanoContas pc) {
		String[] caminho = pc.getConta().split("\\.");
		int[] caminhoInt = new int[caminho.length];

		for (int i = 0; i < caminho.length; i++) {
			caminhoInt[i] = Integer.parseInt(caminho[i]);
		}

		PlanoContas step = this;
		for (int i = 0; i < caminhoInt.length; i++) {
			step = step.getFilha(caminhoInt[i]);
		}
		
		step.setIdPlanoContas(pc.getIdPlanoContas());
		step.setConta(pc.getConta());
		step.setDescricao(pc.getDescricao());
	}

	public void setValor(String codigo, BigDecimal valor) {
		String[] caminho = codigo.split("\\.");
		int[] caminhoInt = new int[caminho.length];

		for (int i = 0; i < caminho.length; i++) {
			caminhoInt[i] = Integer.parseInt(caminho[i]);
		}

		PlanoContas step = this;
		for (int i = 0; i < caminhoInt.length; i++) {
			step = step.getFilha(caminhoInt[i]);
		}

		step.setValor(valor);
	}

	private void zeraNulos(PlanoContas pc) {
		if (pc.getValor() == null) {
			pc.setValor(new BigDecimal(0));
		}

		if (pc.getFilhas() != null) {
			for (PlanoContas filha : pc.getFilhas()) {
				zeraNulos(filha);
			}
		}
	}
	
	public void zeraNulos() {
		zeraNulos(this);
	}

	private BigDecimal getTotalDasFilhas(PlanoContas pc) {
		BigDecimal total = new BigDecimal(0);

		if (pc.getFilhas() != null) {
			for (PlanoContas filha : pc.getFilhas()) {
				total = total.add(getTotalDasFilhas(filha));
			}
			
			pc.setValor(total);
		} else {
			if (pc.getValor() != null) {
				total = total.add(pc.getValor());
			}
		}
		
		return total;
	}
	
	public void updateTotalizadores() {
		BigDecimal total = new BigDecimal(0);

		if (getFilhas() != null) {
			for (PlanoContas filha : getFilhas()) {
				total = total.add(getTotalDasFilhas(filha));
			}

			setValor(total);
		} else {
			total = total.add(getValor());
		}
	}

	private String toString(int level, PlanoContas pc) {
		StringBuilder sb = new StringBuilder();

		sb.append(getDesenhoLinha(level));

		if (pc.getConta() == null) {
			sb.append("NULL");
		} else {
			sb.append(pc.getConta());
		}

		sb.append(" - ").append(pc.getIdPlanoContas()).append(" - ").append(pc.getDescricao()).append(" - ").append(pc.getValor()).append(" nivel: ").append(pc.getLevelId());
		sb.append('\n');

		if (pc.getFilhas() != null) {
			for (PlanoContas filha : pc.getFilhas()) {
				sb.append(toString(level + 1, filha));
			}
		}

		return sb.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		int level = 1;

		sb.append(toString(level, this));

		return sb.toString();
	}

	private String getDesenhoLinha(int level) {
		char[] ar = new char[level + 1];
		Arrays.fill(ar, ' ');
		ar[ar.length - 2] = '|';
		ar[ar.length - 1] = '-';
		return new String(ar);
	}	
}