package com.gfa;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.gfa.entities.Chauffeur;

@Service
public class NotificationService {
	private JavaMailSender javaMailSender;
	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender=javaMailSender;	
	}
	private String A;
	private Date D;
	
	public Date getD() {
		return D;
	}

	public void setD(Date d) {
		D = d;
	}

	public String getA() {
		return A;
	}

	public void setA(String a) {
		A = a;
	}
	private int C; 

	public int getC() {
		return C;
	}

	public void setC(int c) {
		C = c;
	}

	public void SendNotification(Chauffeur chauffeur) {
		
		SimpleMailMessage mail= new SimpleMailMessage();
		mail.setTo(chauffeur.getEmail());
		mail.setFrom("hanane.ouhinad@gmail.com");
		mail.setSubject("Avis Entretien");
		mail.setText("Bonjour Mr/Mme."+A+" "+"Un entretien pour le véhicule"+C+" est prevu");
		javaMailSender.send(mail);
		
	}
}
