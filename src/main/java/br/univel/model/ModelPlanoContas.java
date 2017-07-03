package br.univel.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.entidade.PlanoContas;

public class ModelPlanoContas extends AbstractTableModel {
	private static final long serialVersionUID = -3148297896041893068L;
	
	private List<PlanoContas> itens = new ArrayList<>();
	
	public void setResultado(List<PlanoContas> resultado) {
		this.itens = resultado;
		fireTableDataChanged();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
 		return itens.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		PlanoContas pc = itens.get(arg0);
		
		switch (arg1) {
		case 0:
			return pc.getIdPlanoContas();
			
		case 1:
			return pc.getDescricao();
			
		case 2:
			return pc.getConta();
		}
		
		return "";
	}
	
	public void addNovoPlanoContas(PlanoContas pc) {
		itens.add(pc);
		super.fireTableDataChanged();
	}

	@Override
	public String getColumnName(int arg0) {
		switch (arg0) {
		case 0:
			return "Código";
			
		case 1:
			return "Descricao";
			
		case 2:
			return "Conta";
		}
		
		return super.getColumnName(arg0);
	}
	
	public PlanoContas getConta(int index) {
		if (index >= this.itens.size())
			return null;
		
		return this.itens.get(index);
	}
}