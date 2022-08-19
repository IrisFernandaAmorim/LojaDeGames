package com.lojagame.lojagameverso.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_produto")
public class ProdutoModel {
	
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotBlank (message = "É obrigatório colocar o nome do produto")
		@Size (min = 5, max = 60)
		private String nome;
		
		private int quantidade;
		
		@NotBlank (message = "É obrigatório colocar a marca do produto")
		@Size (min = 4, max = 30)
		private String marca;
		
		@Positive (message = "Digite um valor maior do que zero")
		private BigDecimal preco;
		
		//Relacionamentos
		
		@ManyToOne
		@JsonIgnoreProperties ("produto")
		private CategoriaModel categoria;
		
		@ManyToOne
		@JsonIgnoreProperties("produto")
		private UsuarioModel usuario;

		//Métodos Getters/Setters
		
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

		public int getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

		public BigDecimal getPreco() {
			return preco;
		}

		public void setPreco(BigDecimal preco) {
			this.preco = preco;
		}

		public CategoriaModel getCategoria() {
			return categoria;
		}

		public void setCategoria(CategoriaModel categoria) {
			this.categoria = categoria;
		}

		public UsuarioModel getUsuario() {
			return usuario;
		}

		public void setUsuario(UsuarioModel usuario) {
			this.usuario = usuario;
		}
		
}
