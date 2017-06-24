package ec.edu.upse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class EmpresaServicios {

	@Getter @Setter private int idempresa_servicio;
	@Getter @Setter private String estado;
	@Getter @Setter private int id_empresa;
	@Getter @Setter private int id_servicios;
}
