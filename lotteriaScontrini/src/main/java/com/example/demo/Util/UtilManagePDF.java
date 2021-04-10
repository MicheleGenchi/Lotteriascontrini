package com.example.demo.Util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class UtilManagePDF {

	public static boolean scaricaFile(StringBuilder localFile) {
		String remoteFile = "https://static.gedidigital.it/repubblica/pdf/2021/economia/bollettinoscontrini.pdf";
		String user = System.getenv("USERPROFILE");
		String adesso = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		localFile.append(user).append("/Desktop/estrazione_").append(adesso).append(".pdf");

		try {
			URL website = new URL(remoteFile);
			try (ReadableByteChannel rbc = Channels.newChannel(website.openStream());
					FileOutputStream fos = new FileOutputStream(localFile.toString())) {
				fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
				return true;
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			return false;
		}

	}

	private static void matching(String testo, List<String> codiciScontrini, String regexIDScontrino) {
		Pattern pattern = Pattern.compile(regexIDScontrino, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(testo);
		while (matcher.find()) {
			codiciScontrini.add(matcher.group());
		}
	}
	
	public static List<String> Leggi(String fileOriginale) throws Exception {
		List codiciScontrini = new ArrayList<String>();
		PdfReader reader;
		try {
			reader = new PdfReader(fileOriginale);
			// pageNumber = 1
			String testo = PdfTextExtractor.getTextFromPage(reader, 1);
			matching(testo, codiciScontrini, "\\d{1,4}-\\d{1,4}\\s\\w+");
			reader.close();
			return codiciScontrini;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return codiciScontrini;
	}

}
