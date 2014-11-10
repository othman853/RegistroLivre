package br.com.aceleradora.RegistroLivre.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import br.com.aceleradora.RegistroLivre.dao.Entidade;

@Entity
@SequenceGenerator(initialValue=1, allocationSize=1, name="geradorId", sequenceName="empresa_sequence")
public class Empresa extends Entidade{
	
	public List<Socio> getSocios() {
		return socios;
	}

	public void setSocios(List<Socio> socios) {
		this.socios = socios;
	}

	@Column(nullable = false)
	private String cnpj;
	private String razaoSocial;
	@Column(nullable = false) 
	private String nomeFantasia;
	private String endereco;
	private Date dataCriacao;
	private Date dataEmissaoDocumento;
	
	@ManyToMany
	@JoinTable(name="empresa_socios", joinColumns={@JoinColumn(name="empresa_id")}, inverseJoinColumns={@JoinColumn(name="socio_id")})
	private List<Socio> socios;
	
	public Empresa(){
		socios = new ArrayList<Socio>();
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataEmissaoDocumento() {
		return dataEmissaoDocumento;
	}

	public void setDataEmissaoDocumento(Date dataEmissaoDocumento) {
		this.dataEmissaoDocumento = dataEmissaoDocumento;
	}
	
	public void adicionaSocio(Socio socio){
		socios.add(socio);
	}
}