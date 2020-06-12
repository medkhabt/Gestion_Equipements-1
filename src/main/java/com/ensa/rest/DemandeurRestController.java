package com.ensa.rest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.bouncycastle.crypto.RuntimeCryptoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ensa.entities.Demande;
import com.ensa.entities.Demandeur;
import com.ensa.metier.DemandeurService;

@RestController
@RequestMapping("/demandeurs")
@Transactional
public class DemandeurRestController {
	@Autowired
	DemandeurService demandeurService;
	public static String urlDirectory = System.getProperty("user.dir")+ "/upload";
	
	@GetMapping("")
	public List<Demandeur> getDemandeurs() {
		return demandeurService.getAll();
	}
	@PostMapping("/register")
	public Demandeur createDemandeur(@RequestBody Demandeur demandeur) {
//		Demandeur demandeurTest = demandeurService.findByUsername(demandeur.getUsername());
//		if(demandeurTest!=null) throw new RuntimeCryptoException("this user alreeady exists !");
		demandeurService.saveDemandeur(demandeur);
		System.out.println("demandeur crée");
		demandeurService.addRoleToDemandeur(demandeur.getUsername(), "Demandeur");
		return demandeur;
	}
	@PutMapping("/update/{id}")
	public Demandeur updateDemandeur(@RequestBody Demandeur demandeur, @PathVariable Long id) {
		System.out.println(" inside update demandeur : "+demandeur.getNom());
		return demandeurService.updateDemandeur(demandeur, id);
	}
	@PutMapping("/update_files/{id}")
	public Demandeur addFiles(@RequestParam("statut") MultipartFile statut,@RequestParam("recepisse") MultipartFile file,
			@RequestParam("profileImage") MultipartFile profileImage, @PathVariable Long id) throws IOException {
		
		Demandeur d = demandeurService.getDemandeur(id);
		byte[] recepisse = compressBytes(file.getBytes());
		d.setRecepisse(recepisse);
		byte[] statu = compressBytes(statut.getBytes());
		d.setStatut(statu);
		byte[] image = compressBytes(profileImage.getBytes());
		d.setImageProfile(image);
//		StringBuilder filesName = new StringBuilder();
//		Path fileNameAndPath = Paths.get(urlDirectory,"recepisse"+d.getUsername()+".xlsx");
//		filesName.append(file.getOriginalFilename());
//		Files.write(fileNameAndPath, file.getBytes());
//		Files.readAllBytes(fileNameAndPath);
//		System.out.println(file.getName()+ "----" + file.getContentType());
		return demandeurService.updateDemandeur(d, id);
	}
	@DeleteMapping("/delete_demandeur")
	public void deleteDemandeur(@PathVariable Long id) {
		demandeurService.delete(id);
	}
	@GetMapping("/get_id/{id}")
	public Demandeur getDemandeur(@PathVariable Long id) {
		Demandeur demandeur = demandeurService.getDemandeur(id);
		Demandeur d = new Demandeur(demandeur);
		if(demandeur.getRecepisse()!=null && demandeur.getStatut()!=null) {
			d.setRecepisse(decompressBytes(demandeur.getRecepisse()));
			d.setImageProfile(decompressBytes(demandeur.getImageProfile()));
			d.setStatut(decompressBytes(demandeur.getStatut()));
		} 
		
		return d;
	}
	@GetMapping("/{username}")
	public Demandeur getDemandeur(@PathVariable String username) {
		Demandeur demandeur = demandeurService.findByUsername(username);
		Demandeur d = new Demandeur(demandeur);
//		d = demandeur;
		if(demandeur.getRecepisse()!=null && demandeur.getStatut()!=null) {
			d.setRecepisse(decompressBytes(demandeur.getRecepisse()));
			d.setImageProfile(decompressBytes(demandeur.getImageProfile()));
			d.setStatut(decompressBytes(demandeur.getStatut()));
			} 
		return d;
	}
//	@GetMapping("/files/recepisse/{id}")
//	public String getFile(@PathVariable Long id) {
//		Demandeur d = demandeurService.getDemandeur(id);
//		byte[] recep = d.getRecepisse();
//		byte[] recepisse = decompressBytes(recep);
//		return ResponseEntity.ok()
//				.contentType(MediaType.parseMediaType())
//	}
	@GetMapping("/files/{id}")
	public byte[] getFiles(@PathVariable Long id) {
		Demandeur demandeur = demandeurService.getDemandeur(id);
		byte[] recep = demandeur.getRecepisse();
		System.out.println("avant le décompression : "+recep);
		byte[] recepisse = decompressBytes(recep);
		System.out.println(recepisse.toString());
//		List<byte[]> files = null ;
//		files.add(recepisse);
		return recepisse;
		
	}
	@GetMapping("/nom_et_prenom/{nom}+{prenom}")
	public Demandeur getDemadeur(@PathVariable String nom, @PathVariable String prenom) {
		return demandeurService.getDemandeur(nom, prenom);
	}
//	@GetMapping("/type_demandeur")
//	public List<Demandeur> getDemandeurByType(@RequestBody String type) {
//		return demandeurService.getDemandeurByType(type);
//	}
	@GetMapping("/tel_demandeur")
	public Demandeur getDemandeurByTel(@RequestBody String tel) {
		return demandeurService.getDemandeurByTel(tel);
	}
	@GetMapping("/username")
	public Demandeur getDemandeurByUserAndPass(@RequestBody String username, @RequestBody String password){
		return demandeurService.getDemandeurByUserPass(username, password);
	}
	@GetMapping("/demandes/{id}")
	public List<Demande> getDemandes(@PathVariable Long id){
		return demandeurService.getDemandes(id);
	}
	@GetMapping("/delete_username")
	public void delete(@RequestBody String username) {
		demandeurService.delete(username);
	}
	@GetMapping("/delete_id/{id}")
	public void delete(@PathVariable Long id) {
		demandeurService.delete(id);
	}
	@GetMapping("/demande/{id}")
	public Demandeur findByDemande(@PathVariable int id) {
		return  demandeurService.findByDemande(id);
	}
	
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}
	
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}

	
	
	

}
