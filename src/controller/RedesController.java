package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController(){
		super();
	}
	
	public void Ip(String so){
		if(so.contains("Windows")){
			String ethernet = "";
			try {
				Process p = Runtime.getRuntime().exec("ipconfig");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha!=null){
					if(linha.contains("Ethernet")){
						ethernet = linha;
					}
					if(linha.contains("IPv4")&&ethernet.contains("Ethernet")){
						ethernet = ethernet + "\n" + linha.substring(12, 16) + linha.substring(46);
						System.out.println(ethernet);
						ethernet = "";
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(so.contains("Linux")){
			String processo = "ifconfig";
			readIp(processo);
		}
	}
	
	public void Ping(String so){
		if(so.contains("Windows")){
			try {
				Process p = Runtime.getRuntime().exec("ping -4 -n 10 www.google.com.br");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha!=null){
					if(linha.contains("ms")){
						if(linha.contains("dia")){
							System.out.print("Tempo m�dio:");
							System.out.print(linha.substring(41));
						}else{
						String palavras[] = linha.split(" ");
						for (String palavra : palavras){
							if(palavra.contains("tempo")){
								System.out.println(palavra);
							}
						}
						}
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(so.contains("Linux")){
			try {
				Process p = Runtime.getRuntime().exec("ping -4 -c 10 www.google.com.br");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha!=null){
					if(linha.contains("ms")){
						if(linha.contains("avg")){
							System.out.print("Tempo m�dio:");
							System.out.print(linha.substring(30, 37));
						}else{
						String palavras[] = linha.split(" ");
						for (String palavra : palavras){
							if(palavra.contains("time=")){
								System.out.println(palavra);
							}
						}
						}
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void readIp(String process){
		String ethernet = "";
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha!=null){
				if(linha.contains("Ethernet")){
					ethernet = linha;
				}
				if(linha.contains("IPv4")){
					System.out.println(ethernet);
				}
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
}
