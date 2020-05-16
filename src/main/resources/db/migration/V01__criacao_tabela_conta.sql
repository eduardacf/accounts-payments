CREATE TABLE contas (
  id_conta 	          INTEGER NOT NULL AUTO_INCREMENT,
  nome                VARCHAR(60) NOT NULL,
  valor_original	  DOUBLE NOT NULL,
  valor_corrigido	  DOUBLE NULL,
  dias_atraso		  INTEGER NULL,
  data_vencimento 	  Date NOT NULL,
  data_Pagamento 	  Date NOT NULL,
  PRIMARY KEY (id_conta)
  )
