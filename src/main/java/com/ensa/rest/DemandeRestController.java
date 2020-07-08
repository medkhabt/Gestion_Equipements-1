package com.ensa.rest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.bouncycastle.crypto.RuntimeCryptoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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

import com.ensa.entities.Autorisation;
import com.ensa.entities.Demande;
import com.ensa.entities.Demandeur;
import com.ensa.entities.Gestionnaire;
import com.ensa.metier.DemandeService;
import com.ensa.metier.DemandeurService;
import com.ensa.repo.DemandeJpaRepository;


@RestController
@RequestMapping("demandes")
@EnableWebSecurity
@Transactional
public class DemandeRestController {
	@Autowired
	DemandeService demandeService;
	@Autowired
	DemandeJpaRepository demandeRepo;
	@Autowired
	DemandeurService demandeurService;
	
	@GetMapping("")
	public List<Demande> getDemandes(){
		return demandeService.getDemandes();
	}
	@PostMapping("/add")
	public Demande createDemande(@RequestBody Demande demande) throws IOException {
//		byte[] obligation = compressBytes(file.getBytes());
		Demande d = demandeService.createDemande(demande);
//		d.setObligationScanne(obligation);
		return d;
	}
	@PostMapping("/addFile/{id}")
	public Demande addFile(@RequestParam("obligationScanne") MultipartFile file, @PathVariable int id) throws IOException {
		System.out.println(file.getName());
		byte[] obligation = compressBytes(file.getBytes());
		Demande d = demandeService.getDemande(id);
		System.out.println(d.getDemandeur().getNom());
		d.setObligationScanne(obligation);
		return demandeRepo.save(d);
	}
	@PutMapping("/update_demande/{id}")
	public void updateDemande(@RequestBody Demande demande,@PathVariable int id) {
		 demandeService.updateDemande(demande, id);
	}
	@GetMapping("/{id}")
	public Demande getDemande(@PathVariable int id) {
		Demande demande = demandeService.getDemande(id);
		Demande d = new Demande(demande);
		if(demande.getObligationScanne()!=null) {
			d.setObligationScanne(decompressBytes(demande.getObligationScanne()));
		}
		return d;
	}
	@GetMapping("/demande_demandeur")
	public List<Demande> getDemande(@RequestBody Demandeur demandeur) {
		return demandeService.getDemande(demandeur);
	}
	@GetMapping("/demande/DateDemande")
	public List<Demande> getDemande(@RequestBody Date datedemande){
		return demandeService.getDemande(datedemande);
	}
	@DeleteMapping("delete_demande/{id}")
	public void deleteDemande(@PathVariable int id) {
		demandeService.deleteDemande(id);
	}
	@GetMapping("/demande_type")
	public List<Demande> getByTypeEvent(@RequestBody String type) {
		return demandeService.getByTypeEvent(type);
	}
	@GetMapping("/demande/Date_Reservation")
	public List<Demande> getByDateReservation(@RequestBody Date dateReservation) {
		return demandeService.getByDateReservation(dateReservation);
	}
	@GetMapping("/par_mois")
	public List<Integer> getByMonth() throws ParseException {
		int i;
		List<Integer> autoSomme = new ArrayList<Integer>();
		for(i=1;i<13;i++) {
			List<Demande> demandes = demandeService.getDemandesByMonth(i);
			System.out.println(demandes.size());
			autoSomme.add(demandes.size());
		}
		
		return autoSomme;
	}
	@GetMapping("/par_demandeur/{id}")
	public int[] getAutorisations(@PathVariable Long id) {
		Demandeur demandeur = demandeurService.getDemandeur(id);
		if(demandeur==null) {
			throw new RuntimeCryptoException("ce gestionnaire n'existe pas !");
		}
		List<Demande> demandes = demandeService.getDemande(demandeur);
		int[] autoSomme = {0,0,0,0,0,0,0,0,0,0,0,0} ;
		for(Demande demande : demandes) {
			System.out.println(demande.getId());
			Date date = demande.getDateDemande();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int month = cal.get(Calendar.MONTH);
			System.out.println(date);
			autoSomme[month] += 1;
			System.out.println(autoSomme[month]);
		}
		return autoSomme;
	}
//	@GetMapping("/demande/interval_dates")
//	public List<Demande> getByInterval(@RequestBody Date d1, @RequestBody Date d2) {
//		return demandeService.getByInterval(d1, d2);
//	}
	@DeleteMapping("/demande/type/{type}")
	public void deleteByType(@PathVariable String typeEvent) {
		demandeService.deleteDemandeByType(typeEvent);
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
