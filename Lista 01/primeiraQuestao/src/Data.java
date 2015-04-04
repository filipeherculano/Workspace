
public class Data {
	private int dia;
	private int mes;
	private int ano;
	
	public Data(int dia, int mes, int ano){
		if (ano >= 0 && (1 <= mes && mes <= 12) && (1 <= dia && dia <= 31)){
			if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
				this.dia = dia;
				this.mes = mes;
				this.ano = ano;
				System.out.println("Data cadastrada!");
			}
			else{
				if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && (1 <= dia && dia <= 30)){
					this.dia = dia;
					this.mes = mes;
					this.ano = ano;
					System.out.println("Data cadastrada!");
				}
				else{
					if ((ano % 4 == 0) && (1 <= dia && dia <= 29)){
						this.dia = dia;
						this.mes = mes;
						this.ano = ano;
						System.out.println("Data cadastrada!");
					}
					else{
						if(1 <= dia && dia <= 28){
							this.dia = dia;
							this.mes = mes;
							this.ano = ano;
							System.out.println("Data cadastrada!");
						}
					}
				}
			}
		}
	}
	
	public int getDia(){
		return this.dia;
	}
	public int getMes(){
		return this.mes;
	}
	public int getAno(){

		return this.ano;
	}
	
	public String toString(){
		System.out.println(this.dia+ "/" +this.mes+ "/" +this.ano);
		return null;
	}
	
	public boolean maisAntiga(int d, int m, int a){
		if (a < this.ano){
			return true;
		}
		else{
			if(a == this.ano && m < this.mes){
				return true;
			}
			else{
				if(a == this.ano && m == this.mes && d < this.dia){
					return true;
				}
			}
		}
		return false;
	}
	
	public void avançarDia(){
		if ((this.mes == 1 || this.mes == 3 || this.mes == 5 || this.mes == 7 || this.mes == 8 || this.mes == 10) && (this.dia == 31)){
			this.dia = 1;
			this.mes ++;
		}
		else{
			if ((this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11) && (this.dia == 30)){
				this.dia = 1;
				this.mes ++;
			}
			else{
				if (this.dia == 29 && this.mes == 2){
					this.dia = 1;
					this.mes ++;
				}
				else{
					if(this.dia == 28 && this.mes == 2){
						this.dia = 1;
						this.mes ++;
					}
					else{
						if(this.dia == 31 && this.mes == 12){
							this.dia = 1;
							this.mes = 1;
							this.ano ++;
						}
						else{
							this.dia ++;
						}
					}
				}
			}
		}
		
	}
}
