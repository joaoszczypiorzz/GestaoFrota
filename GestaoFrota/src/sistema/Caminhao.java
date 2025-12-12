package sistema;

public class Caminhao extends Veiculo{
    protected double capacidadeCarga; //toneladas
    protected int eixos;

    //constructor da Classe com Super de sua classe pai:
    public Caminhao(String placa,String modelo, double valorDiaria, double capacidadeCarga, int eixos){
        super(placa, modelo,valorDiaria);
        this.capacidadeCarga = capacidadeCarga;
        this.eixos = eixos;

    }

    @Override
    void aplicarReajuste(double percentual) {
        if(percentual < 5){ //Reajuste minimo deve ser de 5%, caso o usuário digite um valor menor que 5%, sistema deve tratar como 5%
            percentual = 5;
        }
        valorDiaria = valorDiaria - (valorDiaria * percentual/100); //reajustando valor
    }

    //Getters e setters:
    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public Caminhao setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
        return this;
    }

    public int getEixos() {
        return eixos;
    }

    public Caminhao setEixos(int eixos) {
        this.eixos = eixos;
        return this;
    }
}
