package br.com.marcosxavierdev.myfood.domain.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_cozinha")
public class Cozinha {

	@Id
	private Long id;

	@Column(name = "nome_cozinha")
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
 * @Table - pode dar um nome diferente a tabela no banco de dados (por padrão o
 * nome da tabela seria a da classe)
 * 
 * @Id - define que este atributo será o identificador da tabela (chave
 * primária)
 * 
 * @Column - define algumas configurações do atibuto (coluna) da entidade.
 * 
 * 
 * 
 * 
 */