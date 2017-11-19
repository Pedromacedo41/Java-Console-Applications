

public class item {

	private String nome;
	public float valor;
	public int quantidade;
	public boolean embalagem;

	item(String nome, float valor, int quantidade, boolean embalagem){
		this.nome = nome;
		this.valor = valor;
		this.embalagem = embalagem;
		this.quantidade = quantidade;
	}

	public void imprime(){
		String foo= String.format("%-30s \t \t %s", nome, " " + quantidade + 'x'+ valor + " =  RS "+ quantidade*valor);
		System.out.println(foo);
		if(embalagem){
			String foo2= String.format("%-30s \t \t %s", "(+1 Embalagem)", " 1x3.0 =   RS 3.0 ");
			System.out.println(foo2);
		}
		System.out.println('\n');	
	}
} 