package ec.edu.upse.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;



public class DBEmpresa {
	List<Empresa> empresas;
	List<EmpresaHorario> horarios;
	List<String> servicios;
	
	public String listaEmpresasTipo(String idTipo){
		String jsonResultado;
		
		int cont = 0;
		ResultSet resultado = null;
		ResultSet resultado2 = null;
		DBManager dbmanager = new DBManager();
		Connection conexion = dbmanager.getConection();
		if (conexion == null) {
			System.out.println("Conexion no se pudo realizar");
		}
		Statement state = null;
		Statement state2 = null;
		try {
			state = (Statement) conexion.createStatement();
			//resultado = state.executeQuery("SELECT * FROM empresa as e ,tipo_empresa as tp where e.idtipo_empresa=tp.idtipo_empresa and e.estado='A' and tp.estado='A' and (e.idtipo_empresa ="+idTipo+");");
			resultado = state.executeQuery("SELECT * FROM empresa as e ,tipo_empresa as tp where e.idtipo_empresa=tp.idtipo_empresa and e.estado='A' and tp.estado='A' and e.idtipo_empresa ="+idTipo+";");
			
			empresas = new ArrayList<Empresa>();
			while(resultado.next()){
				cont = cont + 1;
				Empresa emp = new Empresa();
				
				
				emp.setId_empresa(resultado.getInt(1));
				emp.setNombre(resultado.getString(2));
				emp.setDireccion(resultado.getString(3));
				emp.setTelefono(resultado.getString(4));
				emp.setDescripcion_empresa(resultado.getString(5));
				emp.setLatitud(resultado.getString(6));
				emp.setLongitud(resultado.getString(7));
				emp.setId_parroquia(resultado.getInt(8));
				emp.setRuta_imagen(resultado.getString(9));
				emp.setPath_foto(resultado.getString(10));
				emp.setFoto(resultado.getBytes(11));
				emp.setEstado(resultado.getString(12));
				emp.setIdtipo_empresa(resultado.getInt(13));
				
				
				
				state2 = (Statement) conexion.createStatement();
				resultado2 = state2.executeQuery("SELECT * FROM empresa_horario WHERE estado = 'A' AND id_empresa ="+resultado.getInt(1)+";");
				
				horarios = new ArrayList<EmpresaHorario>();
				while(resultado2.next()){
					EmpresaHorario horario = new EmpresaHorario();
					horario.setIdempresa_horario(resultado2.getInt(1));
					horario.setEstado(resultado2.getString(2));
					horario.setId_empresa(resultado2.getInt(3));
					horario.setDia(resultado2.getString(4));
					horario.setHora_inicio(resultado2.getString(5));
					horario.setHora_fin(resultado2.getString(6));
					horarios.add(horario);
				}
				emp.setEmpresahorarios(horarios);
				empresas.add(emp);
			}
			
			
			conexion.close();
			if(cont>0){
				Gson gson = new Gson();  
				jsonResultado = gson.toJson(empresas);
			}else{
				jsonResultado=null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResultado=null;
		}
		
		
		return jsonResultado;
	}


	public String empresa_por_idempresa(String id_empresa){
		String jsonResultado;
		int cont = 0;
		ResultSet resultado = null;
		ResultSet resultado2 = null;
		ResultSet resultado3 = null;
		DBManager dbmanager = new DBManager();
		Connection conexion = dbmanager.getConection();
		if (conexion == null) {
			System.out.println("Conexion no se pudo realizar");
			//return jsonempresa.toString();
		}
		Empresa emp = new Empresa();
		Statement state = null;
		Statement state2 = null;
		Statement state3 = null;
		try {
			state = (Statement) conexion.createStatement();
			resultado = state.executeQuery("SELECT * FROM empresa where estado='A' and id_empresa = "+id_empresa+";");
			while(resultado.next()){
				cont = cont + 1;
				
				emp.setId_empresa(resultado.getInt(1));
				emp.setNombre(resultado.getString(2));
				emp.setDireccion(resultado.getString(3));
				emp.setTelefono(resultado.getString(4));
				emp.setDescripcion_empresa(resultado.getString(5));
				emp.setLatitud(resultado.getString(6));
				emp.setLongitud(resultado.getString(7));
				emp.setId_parroquia(resultado.getInt(8));
				emp.setRuta_imagen(resultado.getString(9));
				emp.setPath_foto(resultado.getString(10));
				emp.setFoto(resultado.getBytes(11));
				emp.setEstado(resultado.getString(12));
				emp.setIdtipo_empresa(resultado.getInt(13));
				
				state2 = (Statement) conexion.createStatement();
				resultado2 = state2.executeQuery("SELECT * FROM empresa_horario WHERE estado = 'A' AND id_empresa ="+resultado.getInt(1)+";");
				
				horarios = new ArrayList<EmpresaHorario>();
				while(resultado2.next()){
					EmpresaHorario horario = new EmpresaHorario();
					horario.setIdempresa_horario(resultado2.getInt(1));
					horario.setEstado(resultado2.getString(2));
					horario.setId_empresa(resultado2.getInt(3));
					horario.setDia(resultado2.getString(4));
					horario.setHora_inicio(resultado2.getString(5));
					horario.setHora_fin(resultado2.getString(6));
					horarios.add(horario);
				}
				emp.setEmpresahorarios(horarios);
				
				state3 = (Statement) conexion.createStatement();
				resultado3 = state3.executeQuery("SELECT s.descripcion_servicio FROM empresa_servicio as es, servicios as s WHERE es.id_servicios = s.id_servicios AND es.estado='A' AND s.estado='A' AND es.id_empresa ="+resultado.getInt(1)+";");
								
				servicios = new ArrayList<String>();
				while(resultado3.next()){
					String servicio = resultado3.getString(1);
					servicios.add(servicio);
				}
				emp.setEmpresaservicios(servicios);
				
			}
			
			if(cont>0){
				Gson gson = new Gson();  
				jsonResultado = gson.toJson(emp);
			}else{
				jsonResultado=null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResultado=null;
		}
		return jsonResultado;
	}
	
	
	public String empresa_por_nombreEmpresa(String nombre){
		String jsonResultado;
		int cont = 0;
		ResultSet resultado = null;
		ResultSet resultado2 = null;
		ResultSet resultado3 = null;
		DBManager dbmanager = new DBManager();
		Connection conexion = dbmanager.getConection();
		if (conexion == null) {
			System.out.println("Conexion no se pudo realizar");
			//return jsonempresa.toString();
		}
		Empresa emp = new Empresa();
		Statement state = null;
		Statement state2 = null;
		Statement state3 = null;
		try {
			state = (Statement) conexion.createStatement();
			resultado = state.executeQuery("select * from empresa where estado = 'A' and nombre= '"+nombre+"';");
			while(resultado.next()){
				cont = cont + 1;
				
				emp.setId_empresa(resultado.getInt(1));
				emp.setNombre(resultado.getString(2));
				emp.setDireccion(resultado.getString(3));
				emp.setTelefono(resultado.getString(4));
				emp.setDescripcion_empresa(resultado.getString(5));
				emp.setLatitud(resultado.getString(6));
				emp.setLongitud(resultado.getString(7));
				emp.setId_parroquia(resultado.getInt(8));
				emp.setRuta_imagen(resultado.getString(9));
				emp.setPath_foto(resultado.getString(10));
				emp.setFoto(resultado.getBytes(11));
				emp.setEstado(resultado.getString(12));
				emp.setIdtipo_empresa(resultado.getInt(13));
				
				state2 = (Statement) conexion.createStatement();
				resultado2 = state2.executeQuery("SELECT * FROM empresa_horario WHERE estado = 'A' AND id_empresa ="+resultado.getInt(1)+";");
				
				horarios = new ArrayList<EmpresaHorario>();
				while(resultado2.next()){
					EmpresaHorario horario = new EmpresaHorario();
					horario.setIdempresa_horario(resultado2.getInt(1));
					horario.setEstado(resultado2.getString(2));
					horario.setId_empresa(resultado2.getInt(3));
					horario.setDia(resultado2.getString(4));
					horario.setHora_inicio(resultado2.getString(5));
					horario.setHora_fin(resultado2.getString(6));
					horarios.add(horario);
				}
				emp.setEmpresahorarios(horarios);
				
				state3 = (Statement) conexion.createStatement();
				resultado3 = state3.executeQuery("SELECT s.descripcion_servicio FROM empresa_servicio as es, servicios as s WHERE es.id_servicios = s.id_servicios AND es.estado='A' AND s.estado='A' AND es.id_empresa ="+resultado.getInt(1)+";");
								
				servicios = new ArrayList<String>();
				while(resultado3.next()){
					String servicio = resultado3.getString(1);
					servicios.add(servicio);
				}
				emp.setEmpresaservicios(servicios);
				
			}
			
			if(cont>0){
				Gson gson = new Gson();  
				jsonResultado = gson.toJson(emp);
			}else{
				jsonResultado=null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResultado=null;
		}
		return jsonResultado;
	}
	
	public String ListaEmpresas_sin_parametros(){
		
		String jsonResultado;
		int cont = 0;
		ResultSet resultado = null;
		ResultSet resultado2 = null;
		DBManager dbmanager = new DBManager();
		Connection conexion = dbmanager.getConection();
		if (conexion == null) {
			System.out.println("Conexion no se pudo realizar");
		}
		
		Statement state = null;
		Statement state2 = null;
		try {
			state = (Statement) conexion.createStatement();
			resultado = state.executeQuery("SELECT * FROM empresa where estado='A';");
			empresas = new ArrayList<Empresa>();
			while(resultado.next()){
				cont = cont + 1;
				Empresa emp = new Empresa();
				emp.setId_empresa(resultado.getInt(1));
				emp.setNombre(resultado.getString(2));
				emp.setDireccion(resultado.getString(3));
				emp.setTelefono(resultado.getString(4));
				emp.setDescripcion_empresa(resultado.getString(5));
				emp.setLatitud(resultado.getString(6));
				emp.setLongitud(resultado.getString(7));
				emp.setId_parroquia(resultado.getInt(8));
				emp.setRuta_imagen(resultado.getString(9));
				emp.setPath_foto(resultado.getString(10));
				emp.setFoto(resultado.getBytes(11));
				emp.setEstado(resultado.getString(12));
				emp.setIdtipo_empresa(resultado.getInt(13));
				
				/*state2 = (Statement) conexion.createStatement();
				resultado2 = state2.executeQuery("SELECT s.descripcion_servicio FROM empresa_servicio as es, servicios as s WHERE es.id_servicios = s.id_servicios AND es.estado='A' AND s.estado='A' AND es.id_empresa ="+resultado.getInt(1)+";");
								
				servicios = new ArrayList<String>();
				while(resultado2.next()){
					String servicio = resultado2.getString(1);
					servicios.add(servicio);
				}
				emp.setEmpresaservicios(servicios);*/
				
				empresas.add(emp);
			}
			
			if(cont>0){
				Gson gson = new Gson();
				jsonResultado = gson.toJson(empresas);		
			}else{
				jsonResultado = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jsonResultado = null;
		}
		return jsonResultado;
	}
	
	
	
	
}
