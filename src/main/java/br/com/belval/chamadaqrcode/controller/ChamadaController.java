package br.com.belval.chamadaqrcode.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import br.com.belval.chamadaqrcode.model.Aluno;
import br.com.belval.chamadaqrcode.model.Evento;

@Controller
public class ChamadaController {

	private List<Aluno> alunos = new ArrayList<>();
	private List<Evento> eventos = new ArrayList<>();

	public ChamadaController() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			alunos.add(new Aluno(1, "José Manuel", 50001, "INF2AN", sdf.parse("10/10/2000")));
			alunos.add(new Aluno(2, "Maria José", 50002, "INF2BN", sdf.parse("10/10/2006")));
			alunos.add(new Aluno(3, "João Maria", 50003, "INF2AN", sdf.parse("10/10/2007")));
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		try {
			eventos.add(
					new Evento(1, "CIP2023", "Campeonato de Programação", 
							sdf2.parse("26/09/2023 19:30:00"), sdf2.parse("26/09/2023 23:59:59"),
							"3° andar, laboratório 1"));
			
			eventos.add(
				new Evento(1, "SLA2023", "SLA", 
						sdf2.parse("26/05/2023 19:30:00"), sdf2.parse("26/05/2023 23:59:59"),
						"Belval"));
		
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@GetMapping(
			  value = "/aluno/qrcode/{rm}",
			  produces = MediaType.IMAGE_PNG_VALUE
			)
	public @ResponseBody byte[] getQrCodeAluno(@PathVariable("rm") int rm) {
		
		Aluno aluno = getAlunoPorRm(rm);
		
		if (aluno != null) {
		
			String barcodeText = "http://localhost:8080/aluno/" + rm + "/presente";
			
			try {
				return generateQrCodeAluno(barcodeText);
			} catch (Exception e) {
				e.printStackTrace();
			}
		    
		    return new byte[0];
		}
		return new byte[0];
	}

	private byte[] generateQrCodeAluno(String barcodeText) throws WriterException, IOException {
		QRCodeWriter barcodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = 
		  barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 200, 200);

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, "png", byteArrayOutputStream);
		return byteArrayOutputStream.toByteArray();
	}

	private Aluno getAlunoPorRm(int rm) {
		for(Aluno a : alunos) {
			if (a.getRm() == rm) {
				return a;
			}
		}
		return null;
	}
}
