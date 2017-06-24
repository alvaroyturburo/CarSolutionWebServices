package ec.edu.upse.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Empresa {

	@Getter @Setter private int id_empresa;
	@Getter @Setter private String nombre;
	@Getter @Setter private String direccion;
	@Getter @Setter private String telefono;
	@Getter @Setter private String descripcion_empresa;
	@Getter @Setter private String latitud;
	@Getter @Setter private String longitud;
	@Getter @Setter private int id_parroquia;
	@Getter @Setter private String ruta_imagen;
	@Getter @Setter private String path_foto;
	@Getter @Setter private byte[] foto;
	@Getter @Setter private String estado;
	@Getter @Setter private int idtipo_empresa;
	
	@Getter @Setter private List<EmpresaHorario> empresahorarios;
	@Getter @Setter private List<String> empresaservicios;
	
	
	
	
}
