package br.com.alura.escola.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class TesteHttpDAO {

	public void testarConexaoHttp() throws IOException {
		URL url = new URL("http://www.google.com.br");
		URLConnection urlConnection = url.openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		reader.close();
	}

}
