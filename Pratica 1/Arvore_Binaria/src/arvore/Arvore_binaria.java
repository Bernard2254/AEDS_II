package arvore;

public class Arvore_binaria {
	  private static class No {  // Nó composto por Item (que tem chave) e mais dois nós (Esquerda e Direita)
	    Item reg; 
	    No esq, dir; 
	  }
	  public int comparacoes=0;
	  private No raiz;        // Define uma variável que guarda o início da árvore (primeiro nó)
	  private void central (No p) { //  Printa a árvore de maneira crescente (usa recursividade)
	    if (p != null) {
	      central (p.esq);
	      System.out.println (p.reg.toString());
	      central (p.dir);
	    }
	  }
	  private Item pesquisa (Item reg, No p, boolean comp) {
	    if (p == null){ 
	    	return null; // Caso o registro procurado não seja achado
	    }
	    else if (reg.compara (p.reg) < 0){ if(comp) comparacoes++; return pesquisa (reg, p.esq, comp);} // Se o registro procurado for menor que o nó atual, desce na árvore pela esquerda
	    else if (reg.compara (p.reg) > 0){ if(comp) comparacoes+=2; return pesquisa (reg, p.dir, comp);} // Se o registro procurado for maior que o nó atual, desce na árvore pela direita
	    else { if(comp) comparacoes+=2; return p.reg;} // Se chegar nessa linha de execução é pq o registro procurado é igual ao registro do nó
	  }
	  
	  private No insere (Item reg, No p) {
	    if (p == null) { // caso a posição da inserção for onde há um No nulo (nó folha), caso base
	      p = new No (); p.reg = reg; // instancia novo nó e o preenche
	      p.esq = null; p.dir = null;
	    }
	    else if (reg.compara (p.reg) < 0) p.esq = insere (reg, p.esq); //Recursão -> procura a posição correta para inserção, até chegar no caso inicial (p==null)
	    else if (reg.compara (p.reg) > 0) p.dir = insere (reg, p.dir);
	    //else System.out.println ("Erro: Registro ja existente"); // Caso encontre um nó que contém o registro desejado
	    return p; 
	  }
	  private No antecessor (No q, No r) { // Pega subárvore mais a direita do filho a esquerda do nó a ser retirado
	    if (r.dir != null) r.dir = antecessor (q, r.dir);
	    else { q.reg = r.reg; r = r.esq; }
	    return r;
	  }
	  private No retira (Item reg, No p) {
	    if (p == null) System.out.println ("Erro: Registro nao encontrado"); // caso não ache o registro
	    else if (reg.compara (p.reg) < 0) p.esq = retira (reg, p.esq); // Recursão de busca
	    else if (reg.compara (p.reg) > 0) p.dir = retira (reg, p.dir); // Recursão de busca
	    else { // Caso tenha encontrado o registro a ser retirado
	      if (p.dir == null) p = p.esq; // Caso não tenha nó que tenha registro maior que o a ser retirado, apenas substitui o nó pelo seu filho menor (mesmo que seja nulo)
	      else if (p.esq == null) p = p.dir; // Caso não tenha nó que tenha registro menor que o a ser retirado, apenas substitui o nó pelo seu filho maior (mesmo que seja nulo)
	      else p.esq = antecessor (p, p.esq); 
	    }
	    return p; 
	  }

	  public Arvore_binaria () { // instancia a árvore
	    this.raiz = null;
	  }
	  
	  public Item pesquisa (Item reg, boolean comp) { // Pesquisa o registro passado
	    return this.pesquisa (reg, this.raiz, comp);
	  }

	  public No insere (Item reg) { // insere o registro passado
		  if(this.pesquisa(reg, false)==null){
			  this.raiz = this.insere (reg, this.raiz);
			  return this.raiz;
		  }
		  return null;
	  }

	  public void retira (Item reg) { // retira o registro passado
	    this.raiz = this.retira (reg, this.raiz);
	  }
	  
	  public void imprime () { // printa a árvore
	    this.central (this.raiz);
	  }

	  // @{\it M\'etodo para testar o funcionamento da classe}@
	  private void testa (No p) { 
	    if (p == null) return;
	    if (p.esq != null) { 
	      if (p.reg.compara (p.esq.reg) < 0) { 
	        System.out.println ("Erro: Pai " + p.reg.toString() + " menor que filho a esquerda " + p.esq.reg.toString());
	        System.exit(1);
	      }
	    }
	    if (p.dir != null) { 
	      if (p.reg.compara (p.dir.reg) > 0 ) { 
	        System.out.println ("Erro: Pai " + p.reg.toString() + " maior que filho a direita " + p.dir.reg.toString());
	        System.exit(1);
	      }
	    }
	    testa(p.esq);
	    testa(p.dir);
	  }
	  public void testa () { 
	    this.testa (this.raiz);
	  }

	}
