package arvore_sbb;
import java.util.Random;
public class Teste {
	public static void main(String[] args){
		Random rand=new Random();
		System.out.println("Ordenados\n");
		double[] tempo = new double[10];
		int[] comparacoes = new int[10];
		int[] size = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000};
		for(int i=0; i< size.length; i++){
			ArvoreSBB teste = new ArvoreSBB();
			//System.out.println("Tamanho: " + size[i]);
			for(int y=0; y<size[i]; y++){
				MeuItem chave = new MeuItem(y);
				teste.insere(chave);
			}
			double time = System.nanoTime();
			teste.pesquisa(new MeuItem(size[i]));
			tempo[i]=(System.nanoTime() - time)/1000000;
			comparacoes[i]=teste.comparacoes;
		}
		System.out.println("Tempo:");
		for(int i=0; i<size.length; i++)
			System.out.print(tempo[i] + " ");
		System.out.println("\nComparações:");
		for(int i=0; i<size.length; i++)
			System.out.print(comparacoes[i] + " ");
		System.out.println("\nAleatórios\n");
		
		for(int i=0; i< size.length; i++){
			ArvoreSBB teste = new ArvoreSBB();
			//System.out.println("Tamanho: " + size[i]);
			
			for(int y=0; y<size[i]; y++){
				MeuItem chave = new MeuItem(rand.nextInt(10000));
				teste.insere(chave);
			}
			double time = System.nanoTime();
			teste.pesquisa(new MeuItem(10001));
			tempo[i]=(System.nanoTime() - time)/1000000;
			comparacoes[i]=teste.comparacoes;
		}
		System.out.println("Tempo:");
		for(int i=0; i<size.length; i++)
			System.out.print(tempo[i] + " ");
		System.out.println("\nComparações:");
		for(int i=0; i<size.length; i++)
			System.out.print(comparacoes[i] + " ");
		System.out.println("\nAleatórios\n");
	}
}
