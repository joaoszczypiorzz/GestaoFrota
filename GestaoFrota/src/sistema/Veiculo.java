package sistema;

public abstract class  Veiculo implements Locavel{
    protected String placa; //Indetificador Unico
    protected String modelo;
    protected double valorDiaria;

    //Constructor da Classe:
    public Veiculo(String placa, String modelo, double valorDiaria){
        this.placa = placa;
        this.modelo = modelo;
        this.valorDiaria = valorDiaria;
    }

    @Override
    public double calcularAluguel(int dias) {
        return valorDiaria * dias;
    }

    @Override
    public void alugar(int dias) {
        System.out.println("Mensagem de confirmação do aluguel do Veiculo: "+ modelo +" Por " + dias +" dias" +" \nValor do aluguel: " + calcularAluguel(dias));
    }

    @Override
    public String toString() {
        return String.format("Placa: %s, Modelo: %s, Valor diária: %.2f", placa, modelo, valorDiaria);
    }

    abstract void aplicarReajuste(double percentual); //metodo abstrato da classe

    //getters e setters da classe:
    public String getPlaca(){
        return placa;
    }

    public Veiculo setPlaca(String placa){
        this.placa = placa;
        return this;
    }

    public String getModelo(){
        return modelo;
    }

    public Veiculo setModelo(String modelo){
        this.modelo = modelo;
        return this;
    }

    public double getValorDiaria(){
        return valorDiaria;
    }

    public Veiculo setValorDiaria(double valorDiaria){
        this.valorDiaria = valorDiaria;
        return this;
    }




}