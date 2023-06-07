
public class MundoWumpus {
	boolean mundo[][][]; //linha, coluna, vetor de caracter�sticas do mundo Wumpus
	boolean mundoVisivel[][]; //linha, coluna, vetor de caracter�sticas do mundo Wumpus vis�vel para o agente, incluindo o pr�prio agente
	String mundoTela[][]; //linha, coluna, vetor de caracter�sticas do mundo Wumpus no formato de impress�o
	
	public MundoWumpus() {
		// mundo Wumpus, 4x4 salas com, cada uma, 8 caracter�sticas:
		// [i][j][0] = percep��o de brisa
		// [i][j][1] = percep��o de fedor
		// [i][j][2] = percep��o de brilho
		// [i][j][3] = exist�ncia de po�o
		// [i][j][4] = exist�ncia de Wumpus
		// [i][j][5] = exist�ncia de tesouro
		// [i][j][6] = local atual do agente
		mundo = new boolean[4][4][7];
		// mundo percept�vel (explorado pelo agente)
		mundoVisivel = new boolean[][]{{false,false,false,false},{false,false,false,false},{false,false,false,false},{false,false,false,false}};
		mundoTela = new String[4][4];
		inicializaMundo();
	}
	
	public boolean[][][] getMundo() {
		return mundo;
	}
	
	public boolean[] getMundo(int i, int j) {
		return mundo[i][j];
	}
	
	public boolean[][] getMundoVisivel() {
		return mundoVisivel;
	}
	
	public boolean getMundoVisivel(int i, int j) {
		return mundoVisivel[i][j];
	}
	public void inicializaMundo() {
		int i,j;
		//[i][j][brisa, fedor, brilho, po�o, Wumpus, tesouro, agente]
		mundo[0][0] = new boolean[]{false,false,false,false,false,false,false};
		mundo[0][1] = new boolean[]{true,false,false,false,false,false,false};
		mundo[0][2] = new boolean[]{false,false,false,true,false,false,false};
		mundo[0][3] = new boolean[]{true,false,false,false,false,false,false};
		mundo[1][0] = new boolean[]{false,true,false,false,false,false,false};
		mundo[1][1] = new boolean[]{false,false,false,false,false,false,false};
		mundo[1][2] = new boolean[]{true,false,false,false,false,false,false};
		mundo[1][3] = new boolean[]{false,false,false,false,false,false,false};
		mundo[2][0] = new boolean[]{false,false,false,false,true,false,false};
		mundo[2][1] = new boolean[]{true,true,true,false,false,true,false};
		mundo[2][2] = new boolean[]{false,false,false,true,false,false,false};
		mundo[2][3] = new boolean[]{true,false,false,false,false,false,false};
		mundo[3][0] = new boolean[]{false,true,false,false,false,false,false};
		mundo[3][1] = new boolean[]{false,false,false,false,false,false,false};
		mundo[3][2] = new boolean[]{true,false,false,false,false,false,false};
		mundo[3][3] = new boolean[]{false,false,false,true,false,false,false};
		for(i=0; i<4; i++)
			for(j=0; j<4; j++)
				mundoTela[i][j] = "";

	}
	
	public void atualizaMundoTela() {
		int i,j;
		for(i=0; i<4; i++)
			for(j=0; j<4; j++)
				mundoTela[i][j] = "";
		System.out.println();
		for(i=0; i<4; i++) {
			for(j=0; j<4; j++) {
				//[i][j][brisa-B, fedor-F, brilho-R, po�o-P, Wumpus-W, tesouro-T]
				if(mundo[i][j][0]) // se tem brisa
					mundoTela[i][j] += 'B';
				if(mundo[i][j][1]) // se tem fedor
					mundoTela[i][j] += 'F';
				if(mundo[i][j][2]) // se tem brisa
					mundoTela[i][j] += 'R';
				if(mundo[i][j][3]) // se tem brisa
					mundoTela[i][j] += 'P';
				if(mundo[i][j][4]) // se tem brisa
					mundoTela[i][j] += 'W';
				if(mundo[i][j][5]) // se tem brisa
					mundoTela[i][j] += 'T';
				if(mundo[i][j][6]) // se tem agente
					mundoTela[i][j] += 'A';
			}
		}
	}
	
	public void mostraMundo() {
		int i,j;
		atualizaMundoTela();
		// escrevendo de modo que a sala [0][0] seja a primeira de baixo para cima, da esq para a dir
		for(i=3; i>=0; i--) { // (de baixo para cima)
			for(j=0; j<4; j++) { //(da esq para a dir)
				System.out.print(" | "+mundoTela[i][j]+"\t");
			}
			System.out.print("\n---------------------------------\n");
		}
	}
	
	public void inserirAgente(int i, int j) {
		mundo[i][j][6] = true;
	}
	
	public void atualizarAgente(int iAtual, int jAtual, int iNovo, int jNovo) {
		mundo[iNovo][jNovo][6] = true;
		mundo[iAtual][jAtual][6] = false;		
	}

	public boolean salaVisivel(int i, int j) {
		if(mundoVisivel[i][j])
			return true;
		else
			return false;
	}
	
	public boolean[] getPercepcoesSala(int i, int j) {
		return mundo[i][j];
	}
}
