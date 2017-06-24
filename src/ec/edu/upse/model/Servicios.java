package ec.edu.upse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Servicios {

	@Getter @Setter private int id_servicios;
	@Getter @Setter private String descripcion_servicio;
	@Getter @Setter private String estado;
	
}
