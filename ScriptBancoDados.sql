CREATE DATABASE "trabalhobimestral3sem"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
    
Create table "planocontas"
(
	"idplanocontas" Serial NOT NULL,
	"descricao" Varchar(100) NOT NULL,
	"conta" Varchar(100) NOT NULL,
	"valor" Numeric(18,2) DEFAULT 0,
 primary key ("idplanocontas")
);

INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Comercial', '1.1');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Serviços', '1.1.1');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Vendas', '1.1.3');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Financeiro', '1.2');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Depósito', '1.2.1');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Reembolso', '1.2.2');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Investimentos', '1.3');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Dividendos', '1.3.1');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Ganhos de capital', '1.3.2');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Juros', '1.3.3');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Escritório', '2.1');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Aluguel', '2.1.1');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Equipamentos', '2.1.2');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Jornais/Revistas', '2.1.3');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Móveis', '2.1.4');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Financeiro', '2.2');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Cobrança', '2.2.1');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Contabilidade', '2.2.2');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Juros', '2.2.3');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Saque', '2.2.4');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Tarifa bancária', '2.2.5');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Transferência', '2.2.6');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Impostos', '2.3');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('COFINS', '2.3.3');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('CPMF', '2.3.3');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('CSS', '2.3.3');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('CSLL', '2.3.4');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('ICMS', '2.3.5');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Importação', '2.3.6');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('INSS', '2.3.7');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('IOF', '2.3.8');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('IPTU', '2.3.9');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('IRPJ', '2.3.10');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('IRPF', '2.3.11');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('ISS', '2.3.12');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('PIS', '2.3.13');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Manutenção', '2.4');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Jardinagem', '2.4.1');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Limpeza', '2.4.2');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Pintura', '2.4.3');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Reparos', '2.4.4');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Pessoal', '2.5');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('13º Salário', '2.5.1');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Cesta Básica', '2.5.2');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Férias', '2.5.3');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('FGTS', '2.5.4');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Horas Extras', '2.5.5');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Plano de Saúde', '2.5.6');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Salário', '2.5.7');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Vale Transporte', '2.5.8');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Serviços Públicos', '2.6');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Água e Esgoto', '2.6.1');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Eletrecidade(Energia)', '2.6.2');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Gás', '2.6.3');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Internet', '2.6.4');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Segurança', '2.6.5');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Telefone Celular', '2.6.6');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Telefone Fixo', '2.6.7');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Suprimentos', '2.7');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Dispensa(Cozinha)', '2.7.1');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Impressora/Fax', '2.7.2');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Limpeza/Higiene', '2.7.3');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Papelaria', '2.7.4');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Transporte', '2.8');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Combustível', '2.8.2');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Estacionamento', '2.8.2');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Manutenção', '2.8.3');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Multa', '2.8.4');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Vendas', '2.9');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Comissão', '2.9.1');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Viagem', '2.10');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Aluguel de carro', '2.10.1');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Combustível', '2.10.2');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Hospedagem', '2.10.3');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Alimentação', '2.10.4');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Ligações Telefônicas', '2.10.5');
INSERT INTO PLANOCONTAS (DESCRICAO, CONTA)
                 VALUES ('Passagens', '2.10.6');