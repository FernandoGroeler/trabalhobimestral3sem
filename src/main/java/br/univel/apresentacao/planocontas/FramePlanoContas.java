package br.univel.apresentacao.planocontas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.univel.dao.PlanoContasDao;
import br.univel.entidade.PlanoContas;

import java.awt.GridBagLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class FramePlanoContas extends JFrame {
	private static final long serialVersionUID = -8806784488006876651L;
	private JPanel contentPane;
	private JTextField txtDescricao;
	private JTextField txtValor;
	private JFormattedTextField frmtdtxtfldConta;
	private PlanoContas pcSelecionado;
	private JTextArea txtrPlanocontas;
	private int idSelecionado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePlanoContas frame = new FramePlanoContas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FramePlanoContas() {
		setMinimumSize(new Dimension(800, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(4, 4, 4, 4));
		panel.setPreferredSize(new Dimension(150, 10));
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblConta = new JLabel("Conta (F2)");
		GridBagConstraints gbc_lblConta = new GridBagConstraints();
		gbc_lblConta.anchor = GridBagConstraints.WEST;
		gbc_lblConta.insets = new Insets(0, 0, 5, 0);
		gbc_lblConta.gridx = 0;
		gbc_lblConta.gridy = 0;
		panel.add(lblConta, gbc_lblConta);
		
		frmtdtxtfldConta = new JFormattedTextField();
		frmtdtxtfldConta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_F2) {
					abreBusca();
				}
			}
		});
		GridBagConstraints gbc_frmtdtxtfldConta = new GridBagConstraints();
		gbc_frmtdtxtfldConta.insets = new Insets(0, 0, 5, 0);
		gbc_frmtdtxtfldConta.fill = GridBagConstraints.HORIZONTAL;
		gbc_frmtdtxtfldConta.gridx = 0;
		gbc_frmtdtxtfldConta.gridy = 1;
		panel.add(frmtdtxtfldConta, gbc_frmtdtxtfldConta);
		
		JLabel lblDescricao = new JLabel("Descricao");
		GridBagConstraints gbc_lblDescricao = new GridBagConstraints();
		gbc_lblDescricao.anchor = GridBagConstraints.WEST;
		gbc_lblDescricao.insets = new Insets(0, 0, 5, 0);
		gbc_lblDescricao.gridx = 0;
		gbc_lblDescricao.gridy = 2;
		panel.add(lblDescricao, gbc_lblDescricao);
		
		txtDescricao = new JTextField();
		GridBagConstraints gbc_txtDescricao = new GridBagConstraints();
		gbc_txtDescricao.insets = new Insets(0, 0, 5, 0);
		gbc_txtDescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescricao.gridx = 0;
		gbc_txtDescricao.gridy = 3;
		panel.add(txtDescricao, gbc_txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		GridBagConstraints gbc_lblValor = new GridBagConstraints();
		gbc_lblValor.anchor = GridBagConstraints.WEST;
		gbc_lblValor.insets = new Insets(0, 0, 5, 0);
		gbc_lblValor.gridx = 0;
		gbc_lblValor.gridy = 4;
		panel.add(lblValor, gbc_lblValor);
		
		txtValor = new JTextField();
		GridBagConstraints gbc_txtValor = new GridBagConstraints();
		gbc_txtValor.insets = new Insets(0, 0, 5, 0);
		gbc_txtValor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtValor.gridx = 0;
		gbc_txtValor.gridy = 5;
		panel.add(txtValor, gbc_txtValor);
		txtValor.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirmar();
				limparCampos();
				atualizarArvore();
			}
		});
		GridBagConstraints gbc_btnConfirmar = new GridBagConstraints();
		gbc_btnConfirmar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnConfirmar.insets = new Insets(0, 0, 5, 0);
		gbc_btnConfirmar.gridx = 0;
		gbc_btnConfirmar.gridy = 6;
		panel.add(btnConfirmar, gbc_btnConfirmar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
				limparCampos();
				atualizarArvore();
			}
		});
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnExcluir.gridx = 0;
		gbc_btnExcluir.gridy = 7;
		panel.add(btnExcluir, gbc_btnExcluir);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		txtrPlanocontas = new JTextArea();
		txtrPlanocontas.setEditable(false);
		txtrPlanocontas.setText("PlanoContas");
		scrollPane.setViewportView(txtrPlanocontas);
		
		/*
		MaskFormatter mask;
		try {
			mask = new MaskFormatter("#.#.#.###");
			mask.install(frmtdtxtfldConta);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		*/
		
		atualizarArvore();
		
	}
	
	protected void abreBusca() {
		PanelPesquisarPlanoContas pesquisarPlanoContas = new PanelPesquisarPlanoContas();

		pesquisarPlanoContas.setOnOk(new Consumer<PlanoContas>() {
			@Override
			public void accept(PlanoContas t) {
				getGlassPane().setVisible(false);
				preencher(t);				
			}
		});

		pesquisarPlanoContas.setOnCancel(new Runnable() {
			@Override
			public void run() {
				limparCampos();
				getGlassPane().setVisible(false);
			}
		});

		setGlassPane(pesquisarPlanoContas);
		pesquisarPlanoContas.setVisible(true);
	}

	protected void limparCampos() {
		frmtdtxtfldConta.setText("");
		txtDescricao.setText("");
		txtValor.setText("");
		pcSelecionado = null;
		idSelecionado = 0;
	}

	protected void preencher(PlanoContas t) {
		frmtdtxtfldConta.setText(t.getConta());
		txtDescricao.setText(t.getDescricao());
		System.out.println(t.getValor());
		txtValor.setText("0");
		pcSelecionado = t;
		idSelecionado = t.getIdPlanoContas();
	}
	
	protected void atualizarArvore() {
		PlanoContas pcRoot = new PlanoContas();
 		PlanoContasDao dao = new PlanoContasDao();
 		
		List<PlanoContas> lista = new ArrayList<>();
		lista = dao.getTodos();
		
		for (PlanoContas pc : lista) {
			PlanoContas pc1 = new PlanoContas();
			pc1.setIdPlanoContas(pc.getIdPlanoContas());
			pc1.setConta(pc.getConta());
			pc1.setDescricao(pc.getDescricao());
			pc1.setValor(pc.getValor());
			
			pcRoot.add(pc1);
		}
		
		txtrPlanocontas.setText(pcRoot.toString());
	}
	
	protected void excluir() {
		if (pcSelecionado != null) {
			PlanoContasDao dao = new PlanoContasDao();
			dao.excluir(pcSelecionado);
		}
	}
	
	protected void inserir(PlanoContas t) {
		PlanoContasDao dao = new PlanoContasDao();
		dao.inserir(t);
	}
	
	protected void atualizar(PlanoContas t) {
		PlanoContasDao dao = new PlanoContasDao();
		dao.atualizar(t);
	}
	
	protected void confirmar() {
		if (pcSelecionado == null) {
			PlanoContas pc = new PlanoContas();
			pc.setConta(frmtdtxtfldConta.getText());
			pc.setDescricao(txtDescricao.getText());
			pc.setValor(new BigDecimal(txtValor.getText()));
			inserir(pc);
		} else {
			pcSelecionado.setIdPlanoContas(this.idSelecionado);
			pcSelecionado.setConta(frmtdtxtfldConta.getText());
			pcSelecionado.setDescricao(txtDescricao.getText());
			pcSelecionado.setValor(new BigDecimal(txtValor.getText()));
			atualizar(pcSelecionado);
		}
	}
}