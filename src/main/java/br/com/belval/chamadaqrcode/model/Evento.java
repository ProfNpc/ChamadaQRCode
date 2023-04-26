package br.com.belval.chamadaqrcode.model;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Evento {
	
	private int id;
	private String nome;
	private String descricao;
	private Date dataInicio;
	private Date dataTermino;
	private String local;

	public Evento() {
	}

	public Evento(int id, String nome, String descricao, Date dataInicio, Date dataTermino, String local) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.local = local;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
	
	
}
