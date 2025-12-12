package sistema;

public interface Locavel {
    void alugar(int dias); //registra o alugel do veiculo por uma quantidade de dias
    double calcularAluguel(int dias); //calcula o valor total do aluguel com base na diária

}