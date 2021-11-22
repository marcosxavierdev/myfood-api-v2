package br.com.marcosxavierdev.myfood.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cozinha {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column (nullable=false)
	private String nome;

}

/*
 * @Entity - define a classe como uma representação de uma entidade (que vai ser
 * traduzida como uma tabela no banco)
 * 
 * @Table(name = "tab_cozinhas") - pode dar um nome diferente a tabela no banco
 * de dados (por padrão o nome da tabela seria a da classe)
 * 
 * @Id - define que este atributo será o identificador da tabela (chave
 * primária)
 * 
 * @Column(name = "nome_cozinha") - define algumas configurações do atributo
 * (coluna) da entidade, nesse caso o nome do campo na tabela.
 * 
 * @Column (nullable = false) - define que o campo nao pode ser nulo (pode ser nulo = falso) no banco de dados
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) - configura a
 * responsabilidade do auto-incremento para o banco de dados
 * 
 * @Getter / @Setter / @EqualsAndHashCodes - substitui os codigos boilerplate
 * equivalentes
 * 
 * @Data - Substitui todos os boilerplate acima de uma só vez
 * 
 * @EqualsAndHashCode(onlyExplicitlyIncluded = true) - utiliza somente se
 * incluido explictamente
 * 
 * @EqualsAndHashCode.Include - inclue as solicitações explicitas
 * 
 */