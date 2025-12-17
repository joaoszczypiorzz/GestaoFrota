package sistema;

public class Carro extends Veiculo{
    protected int passageiros; //capacidade de pessoas

    //constructor da Classe:
    public Carro(String placa, String modelo, double valorDiaria, int passageiros) {
        super(placa, modelo, valorDiaria);
        this.passageiros =  passageiros;
    }


    @Override
    void aplicarReajuste(double percentual) {

        if(percentual > 10){ //caso o percentual que for recebido do usuário for maior do que dez, sistema deve tratar como 10%
            percentual = 10;
        }
        valorDiaria = valorDiaria + (valorDiaria * percentual/100); //reajustando valor da diaria
        System.out.printf(
                "Percentual de desconto aplicado (MAX 10%%): %.2f%%",
                percentual
        );

    }

    @Override
    public String toString() {
        return String.format("( CARRO ) Placa: %s, Modelo: %s, Valor diária: R$ %.2f , Capacidade de Passageiros: %d", placa, modelo, valorDiaria, passageiros);
    }

    //getters e setters:
    public int setPassageiros(){
        return passageiros;
    }

    public Carro setPassageiros(int passageiros){
        this.passageiros = passageiros;
        return this;
    }


}