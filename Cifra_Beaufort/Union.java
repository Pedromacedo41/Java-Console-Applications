public class Union {
	int size;
	int equiv[];
	int haulteur[];

	public Union(int n){
		equiv= new int[n];
		haulteur = new int[n];
		this.size= n;
		init();
	}

	private void init(){
		for(int i=0; i < size; i++){
			equiv[i]=i;
		}
		for(int i=0; i < size; i++){
			haulteur[i]=1;
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

	public int find_paresseaux(int i){    //compression de chemin
		while(i!=equiv[i]){
			equiv[i]=equiv[equiv[i]];
			i=equiv[i];
		}
		return i;
	}

	public int showequiv(int n){
		return equiv[n];
	}

	public void union_paresseaux(int x, int y){
		int i = find_paresseaux(x);
		int j = find_paresseaux(y);
		if(haulteur[i] < haulteur[j]){
			equiv[i]=j;   //point to the bigger tree
		}else{
			equiv[j]=i;
			if(haulteur[i]==haulteur[j]){
				haulteur[i]++;
			}
		}
	}




}