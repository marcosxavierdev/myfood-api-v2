package br.com.marcosxavierdev.myfood.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column (nullable=false)
	private String nome;

	@Column(name = "taxa_frete", nullable=false) 
	private BigDecimal taxaFrete;
	
	@ManyToOne
	@JoinColumn(name="cozinha_id", nullable = false)
	private Cozinha cozinha;

}


/* @Column (nullable = false) - define que o campo nao pode ser nulo (pode ser nulo = falso) no banco de dados
 * 
 * @Column(name = "taxa_frete") - define algumas configurações do atributo (coluna) da entidade, nesse caso o nome do campo na tabela.
 *
 * @ManyToOne - muitos para um (muitos restaurantes para uma cozinha)
 *
 * @JoinColumn(name="cozinha_id") - especifica o nome da coluna criada para a foreign key (caso queira diferente do padrão "cozinha_id")
 * 
 * 
 * 
 * 
 * 
 * 
 * /
 */