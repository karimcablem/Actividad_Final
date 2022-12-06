package mx.tecmilenio.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@Column(name="idUsuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	
	@Column(name="usuario", nullable = false, length = 50)
	private String 	usuario;
	
	@Column(name="nombre" ,nullable = false, length = 100)
	private String	nombre;
	
	@Column(name="edad" ,nullable = false)
	private Integer	edad;
	
	@Column(name="sexo" ,nullable = false, length = 1)
	private String 	sexo;
	
	@Column(name="password" ,nullable = false, length = 45)
	private String 	password;
	
	@Column(name="fecha_creacion", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private  Date	fecha_creacion;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	
	
	
}
