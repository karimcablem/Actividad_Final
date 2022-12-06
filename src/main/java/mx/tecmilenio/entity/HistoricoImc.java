package mx.tecmilenio.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="historicoimc")
public class HistoricoImc {

	@Id
	@Column(name="idHistoricoIMC")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHistoricoIMC;
	
	@Column(name="idUsuario", nullable = false)
	private Integer 	idUsuario;
	
	@Column(name="altura" ,nullable = false)
	private Float	altura;
	
	@Column(name="peso" ,nullable = false)
	private Float	peso;
	
	@Column(name="imc" ,nullable = false)
	private Float 	imc;
	
	@Column(name="fecha_registro", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private  Date	fecha_registro;

	public Integer getIdHistoricoIMC() {
		return idHistoricoIMC;
	}

	public void setIdHistoricoIMC(Integer idHistoricoIMC) {
		this.idHistoricoIMC = idHistoricoIMC;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Float getAltura() {
		return altura;
	}

	public void setAltura(Float altura) {
		this.altura = altura;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Float getImc() {
		return imc;
	}

	public void setImc(Float imc) {
		this.imc = imc;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
	
	
}
