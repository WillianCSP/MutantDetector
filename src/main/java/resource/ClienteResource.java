package resource;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.google.gson.Gson;

import controller.MutantDetector;
import controller.ValidadorDNA;
import model.DNA;


/**
 * 
 * Classe responsável por conter os métodos REST de acesso ao webservice
 *
 * @author Willian Carlos	 
 * @since 18/07/2018 12:25:15
 */
@Path("/mutantDetectorWS")
public class ClienteResource {

	@GET
    @Path("/ping")
    public String testeServidor() {
        System.out.println("Servidor testado via ping: SERVICO EM FUNCIONAMENTO");
        return "SERVICO EM FUNCIONAMENTO ";
    }
	
	@POST
	@Path("/mutant")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response detectarMutante(String dnaJSON){
		
		ResponseBuilder responseBuilder;
		 MutantDetector detect = new MutantDetector();
		 ValidadorDNA validador = new ValidadorDNA();
		 boolean result = false;
		 Gson gson = new Gson();
		 
		 //Converte String JSON para objeto Java
         DNA dna = gson.fromJson(dnaJSON, DNA.class);
         
         if(validador.validarTamanhoECaracteres(dna.getDna())){
			 result = detect.isMutant(dna);
			 
			 if(result){//Em caso de encontrar mutante, retorna http 200
				 System.out.println("Encontrou mutante");
				 responseBuilder = Response.status(200); 
			 
			 }else{//caso contrario 403
				 System.out.println("Não encontrou mutante");
				 responseBuilder = Response.status(403); 
			 }
         }else//Cliente error 400 - bad request
        	 responseBuilder = Response.status(400);
			 
			 return responseBuilder.build();

	}
	
	@GET
    @Path("/stats")
    public String retornaStats() {
        return "TODO: Retorna estatisticas";
    }
	
}
