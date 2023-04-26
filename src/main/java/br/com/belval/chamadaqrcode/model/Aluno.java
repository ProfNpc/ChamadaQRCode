package br.com.belval.chamadaqrcode.model;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter @Setter @NoArgsConstructor
public class Aluno {
	
	private int id;
	private String nome;
	private int rm;
	private String turma;
	private Date nascimento;

	public Aluno() {
	}

	public Aluno(int id, String nome, int rm, String turma, Date nascimento) {
		this.id = id;
		this.nome = nome;
		this.rm = rm;
		this.turma = turma;
		this.nascimento = nascimento;
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

	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
}
