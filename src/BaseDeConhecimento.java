
public class BaseDeConhecimento {
	
	int mundo[][]; // mundo Wumpus conhecido (0: desconhecido; 1: seguro; -1: não seguro);
	boolean caminho[][];
	
	public BaseDeConhecimento() {
		int i, j, k;
		mundo = new int[4][4];
		caminho = new boolean[4][4];
		//inicialização do mundo inicial conhecido
		for(i=0; i<4; i++)
			for(j=0; j<4; j++) {
				mundo[i][j] = 0;
				caminho[i][j] = false;
			}
		mundo[0][0] = 1;
		caminho[0][0] = true;
	}
			
	public int[] ask(boolean percep[], int i, int j) {
		int posicao[] = new int[2];
		boolean brisa = percep[0];
		boolean fedor = percep[1];
		boolean brilho = percep[2];
		boolean poco = percep[3];
		boolean Wumpus = percep[4];
		boolean tesouro = percep[5];

		if((i==0)&&(j==0)) { //sala (0,0)
			mundo[0][1] = 1;
			mundo[1][0] = 1;
			if(!caminho[0][1]) {
				posicao[0]=0;
				posicao[1]=1;
			}else {
				posicao[0]=1;
				posicao[1]=0;
			}
		}else{
			if((i==0)&&(j==1)) { //sala (0,1)
				if(!brisa){ //B[1,1] dupla (P[1,2]ouP[2,1]); se um é falso, o outro é falso
					mundo[1][1] = 1; //seguro
					mundo[0][2] = 1; //seguro
				}else {
					mundo[1][1] = -1; //não seguro
					mundo[0][2] = -1; //não seguro
				}
				if(mundo[1][1]==1) {
					posicao[0] = 1;
					posicao[1] = 1;
				}else {
					if(mundo[0][2]==1) {
						posicao[0] = 0;
						posicao[1] = 2;
					}else { //retorne
						posicao[0] = 0;
						posicao[1] = 0;
					}
				}
			}else {
				//if((i==))
				System.out.println("aqui");
			}
		}
		return posicao;
	} 
	
	public void tell(int i, int j) {
		caminho[i][j] = true;  //marca a sala como caminho percorrido
	}

	public void realizarInferencia() {
		boolean inferenciaFeita;
		do {
			inferenciaFeita = false;
			for (int i = 0; i < mundo.length; i++) {
				for (int j = 0; j < mundo[i].length; j++) {
					if (mundo[i][j] == 0) { // Sala desconhecida
						if (temBrisaAdjacente(i, j)) {
							mundo[i][j] = -1; // Marca como poço
							inferenciaFeita = true;
						}
					}
				}
			}
		} while (inferenciaFeita);
	}

	private boolean temBrisaAdjacente(int i, int j) {
		// Verifica se há brisa em alguma sala adjacente
		if (i > 0 && mundo[i - 1][j] == 1) { // Sala acima
			return true;
		}
		if (i < mundo.length - 1 && mundo[i + 1][j] == 1) { // Sala abaixo
			return true;
		}
		if (j > 0 && mundo[i][j - 1] == 1) { // Sala à esquerda
			return true;
		}
		if (j < mundo[i].length - 1 && mundo[i][j + 1] == 1) { // Sala à direita
			return true;
		}
		return false;
	}
}
