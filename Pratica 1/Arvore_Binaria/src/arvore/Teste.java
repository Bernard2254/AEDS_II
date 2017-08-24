package arvore;
import java.util.Random;

 public class Teste {
	public static void main(String[] args){
		Random rand=new Random();
		System.out.println("Ordenados\n");
		
		int[] size = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000};
		for(int i=0; i< size.length; i++){
			Arvore_binaria teste = new Arvore_binaria();
			System.out.println("Tamanho: " + size[i]);
			for(int y=0; y<size[i]; y++){
				MeuItem chave = new MeuItem(y);
				teste.insere(chave);
			}
			double time = System.nanoTime();
			teste.pesquisa(new MeuItem(size[i]));
			System.out.println("Tempo: "+(System.nanoTime() - time)/1000000);
			System.out.println("Comparações: "+teste.comparacoes);
		}
		
		System.out.println("Aleatórios\n");
		
		for(int i=0; i< size.length; i++){
			Arvore_binaria teste = new Arvore_binaria();
			System.out.println("Tamanho: " + size[i]);
			
			for(int y=0; y<size[i]; y++){
				MeuItem chave = new MeuItem(rand.nextInt(10000));
				teste.insere(chave);
			}
			double time = System.nanoTime();
			teste.pesquisa(new MeuItem(10001));
			System.out.println("Tempo: "+(System.nanoTime() - time)/1000000);
			System.out.println("Comparações: "+teste.comparacoes);
		}
	}
}
