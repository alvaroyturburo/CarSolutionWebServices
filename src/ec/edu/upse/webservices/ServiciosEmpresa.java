package ec.edu.upse.webservices;

import ec.edu.upse.model.DBEmpresa;



public class ServiciosEmpresa {
	DBEmpresa bdempresa;
	
	/*public ServiciosEmpresa() {
		// TODO Auto-generated constructor stub
	}*/
	
	public String listaEmpresasTipo(String request){
		bdempresa = new DBEmpresa();
        String json = bdempresa.listaEmpresasTipo(request);
        //System.out.println(json);
		return json;
		//empresa horario
	}
	
	/*public static void main(String[] args) {
		ServiciosEmpresa se = new ServiciosEmpresa();
		System.out.println(se.empresa_por_nombreEmpresa("Texsaco"));
	}*/
	
	public String empresa_por_idempresa (String request){
		bdempresa = new DBEmpresa();
		String json = bdempresa.empresa_por_idempresa(request);
		//System.out.println(json);
		return json;
		//los datos de empresa horario y empresa servicio
	}
	
	public String empresa_por_nombreEmpresa (String request){
		bdempresa = new DBEmpresa();
		String json = bdempresa.empresa_por_nombreEmpresa(request);
		//System.out.println(json);
		return json;
		//los datos de empresa horario y empresa servicio
	}
	
	public String listaEmpresa_sin_parametros(){
		bdempresa = new DBEmpresa();
		String json = bdempresa.ListaEmpresas_sin_parametros();
		//System.out.println(json);
		return json;
		//la lista de la empresa con su tipo
	}


	
}
