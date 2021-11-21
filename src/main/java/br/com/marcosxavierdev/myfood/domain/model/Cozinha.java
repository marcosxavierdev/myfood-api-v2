package br.com.marcosxavierdev.myfood.domain.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Cozinha {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cozinha other = (Cozinha) obj;
		return Objects.equals(id, other.id);
	}


	
	

}

/*
 * @Entity - define a classe como uma representação de uma entidade (que vai ser
 * traduzida como uma tabela no banco)
 * 
 * @Table(name = "tab_cozinhas") - pode dar um nome diferente a tabela no banco de dados (por padrão o
 * nome da tabela seria a da classe)
 * 
 * @Id - define que este atributo será o identificador da tabela (chave
 * primária)
 * 
 * @Column(name = "nome_cozinha") - define algumas configurações do atibuto (coluna) da entidade, nesse caso o nome da tabela.
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) - configura a responsabilidade do auto-incremento para o banco de dados
 * 
 * 
 */