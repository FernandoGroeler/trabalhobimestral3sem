package br.univel.apresentacao.planocontas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.border.EmptyBorder;

import br.univel.dao.PlanoContasDao;
import br.univel.entidade.PlanoContas;
import br.univel.model.ModelPlanoContas;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelPesquisarPlanoContas extends JPanel {
	private static final long serialVersionUID = -3634788743779089473L;
	private JTextField txtPesquisa;
	private JTable table;
	private Consumer<PlanoContas> consumerOnOk;
	private Runnable runnableOnCancel;
	
	/**
	 * Create the panel.
	 */
	public PanelPesquisarPlanoContas() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(4, 4, 4, 4));
		panel.setPreferredSize(new Dimension(10, 30));
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		txtPesquisa = new JTextField();
		GridBagConstraints gbc_txtPesquisa = new GridBagConstraints();
		gbc_txtPesquisa.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPesquisa.gridx = 0;
		gbc_txtPesquisa.gridy = 0;
		panel.add(txtPesquisa, gbc_txtPesquisa);
		txtPesquisa.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		// $hide>>$
		configuraTela();
		// $hide<<$		
	}
	
	private void configuraTela() {
		ModelPlanoContas model = new ModelPlanoContas();
		table.setModel(model);
		
		txtPesquisa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_DOWN:
					table.getSelectionModel().setSelectionInterval(0, 0);
					txtPesquisa.transferFocus();
					return;
					
				case KeyEvent.VK_ESCAPE:
					if (PanelPesquisarPlanoContas.this.runnableOnCancel != null) {
						PanelPesquisarPlanoContas.this.runnableOnCancel.run();
					}				
					return;

				default:
					busca(txtPesquisa.getText().trim());
				}
			}
		});
		
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					e.consume();
					table.transferFocusBackward();
				}
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					e.consume();
					
					int idx = table.getSelectedRow();
					if (idx != -1) {
						PlanoContas pc = ((ModelPlanoContas)table.getModel()).getConta(idx);
						if (pc == null) {
							return;
						}
						PanelPesquisarPlanoContas.this.consumerOnOk.accept(pc);
					}
				}
				
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					if (PanelPesquisarPlanoContas.this.runnableOnCancel != null) {
						PanelPesquisarPlanoContas.this.runnableOnCancel.run();
					}
				}
			}
		});
	}

	protected void busca(String palavra) {
		List<PlanoContas> lista = buscaNoBanco(palavra);
		((ModelPlanoContas) table.getModel()).setResultado(lista);
	}

	private List<PlanoContas> buscaNoBanco(String palavra) {
		List<PlanoContas> lista = new ArrayList<PlanoContas>();
		PlanoContasDao dao = new PlanoContasDao();
		List<PlanoContas> listaBancoDados = dao.getTodos();
		
		for (int i = 0; i < listaBancoDados.size(); i++) {
			PlanoContas pc = listaBancoDados.get(i);
			
			if (pc.getConta().toLowerCase().startsWith(palavra) || pc.getDescricao().toLowerCase().startsWith(palavra)) {
				PlanoContas pc1 = new PlanoContas();
				pc1.setIdPlanoContas(pc.getIdPlanoContas());
				pc1.setConta(pc.getConta());
				pc1.setDescricao(pc.getDescricao());
				
				lista.add(pc1);
			}
		}

		return lista;
	}

	public void setOnOk(Consumer<PlanoContas> c) {
		this.consumerOnOk = c;
	}

	public void setOnCancel(Runnable r) {
		this.runnableOnCancel = r;
	}

	@Override
	public void setVisible(boolean arg0) {
		super.setVisible(arg0);
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				txtPesquisa.requestFocusInWindow();
			}
		});
	}	
}