public class Union {
	int size;
	int equiv[];

	public Union(int n){
		equiv= new int[n];
		this.size= n;
		init();
	}

	private void init(){
		for(int i=0; i < size; i++){
			equiv[i]=i;
		}
	}

	public int find_quickfind(int i){
		return equiv[i];
	}


	public void union_quickfind(int x, int y){
		x = find_quickfind(x);
		for(int i=0; i < size; i++){
			if(x==equiv[i]) equiv[i]= equiv[y];
		}
	}

	public int find_paresseaux(int i){
		return 0;
	
	}

	public int union_paresseaux(int x, int y){
		find_paresseaux(x);
		

		return 0;
	}


}