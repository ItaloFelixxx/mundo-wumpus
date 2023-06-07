
public class Agente {
	int iAtual, jAtual;
	boolean percep[]; //[brisa, fedor, brilho]
	
	public Agente(MundoWumpus mw, int iInicial, int jInicial) {
		iAtual = iInicial;
		jAtual = jInicial;
		percep = new boolean[7];
		mw.inserirAgente(iAtual,jAtual);
		this.setPercep(mw);
	}
	
	public int[] getPosicaoAtual() {
		int posAtual[] = new int[2];
		posAtual[0] = iAtual;
		posAtual[1] = jAtual;
		return posAtual;
	}
	
	public void setPosAtual(int i, int j) {
		iAtual = i;
		jAtual = j;
	}
	
	public boolean[] getPercep() {
		return percep;
	}
	
	public void setPercep(MundoWumpus mw) {
		int i;
		boolean[] p = mw.getPercepcoesSala(iAtual, jAtual);
		for(i=0; i<7; i++) {
			percep[i] = p[i];
		}
	}
	
	public void mover(int iNovo, int jNovo, MundoWumpus mw) {
		mw.atualizarAgente(iAtual, jAtual, iNovo, jNovo);
		this.setPosAtual(iNovo, jNovo);
		this.setPercep(mw);
	}

}
