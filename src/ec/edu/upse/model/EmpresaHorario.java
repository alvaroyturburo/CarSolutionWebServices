package ec.edu.upse.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class EmpresaHorario {

	@Getter @Setter private int idempresa_horario;
	@Getter @Setter private String estado;
	@Getter @Setter private int id_empresa;
	@Getter @Setter private String dia;
	@Getter @Setter private String hora_inicio;
	@Getter @Setter private String hora_fin;
	
}
