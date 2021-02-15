package entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;



/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="direccion")
@NamedQuery(name="Direccion.findAll", query="SELECT d FROM Direccion d")
public class Direccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="direccion_personal")
	private String direccion_personal;

	@Column(name="ldireccion_personal2")	
	private String direccion_personal2;
	
	@Column
	private boolean done;
	
	@ManyToOne()
	@JoinColumn(name="usuario_id")
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDireccion_personal() {
		return direccion_personal;
	}

	public void setDireccion_personal(String direccion_personal) {
		this.direccion_personal = direccion_personal;
	}

	public String getDireccion_personal2() {
		return direccion_personal2;
	}

	public void setDireccion_personal2(String direccion_personal2) {
		this.direccion_personal2 = direccion_personal2;
	}

	
	
	
	
	
	
}
