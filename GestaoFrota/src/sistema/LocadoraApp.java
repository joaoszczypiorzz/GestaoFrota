package sistema;


import java.util.List;
import java.util.Scanner;
import java.util.*;
/**
 * Fluxo de Execução (dentro de try-catch):
 * Cadastro: Pergunte ao usuário se ele quer cadastrar um Carro (C) ou Caminhão (T). Leia a placa, modelo e valor da diária. Se for Caminhão, leia eixos e carga. Se for Carro, leia passageiros. Adicione à frota e liste novamente.
 * Aluguel: Peça uma placa para busca (buscarPorPlaca). Se encontrado, peça a quantidade de dias. Execute o método alugar. Exiba o valor total calculado (calcularAluguel).
 * Manutenção de Preço: Peça uma placa de veículo para reajustar o valor da diária. Peça a porcentagem de aumento. Chame aplicarReajuste. Mostre o novo valor da diária e liste a frota para confirmar a alteração apenas naquele veículo.
 * Tratamento de Exceções:
 * Capture InputMismatchException (caso digitem letras onde deveriam ser números).
 * Capture IllegalArgumentException (caso a placa não exista).
 * Capture Exception genérica para erros imprevistos.
 * Finally: Feche o Scanner e agradeça a preferência.
 */
public class LocadoraApp {
    public static void main(String[] args) {

        Frota<Veiculo> veiculos = new Frota<>(); //instanciando lista
        Scanner sc = new Scanner(System.in); //instanciando Scanner para entrada de dados do usuário

        List<Veiculo> veiculosIniciais = Arrays.asList(
                //5 Carros aleátorios
                new Carro("ABC-1234", "Fiat Uno", 100.0, 5),
                new Carro("XYZ-9876", "Toyota Corolla", 250.0, 5),
                new Carro("LMN-4567", "Jeep Compass", 300.0, 5),
                new Carro("OPQ-1111", "Honda Civic", 240.0, 5),
                new Carro("RST-2222", "Chevrolet Onix", 150.0, 5),

                //5 caminhões aleatorios
                new Caminhao("TRK-0001", "Volvo FH 540", 800.0, 40.0, 6),
                new Caminhao("TRK-0002", "Scania R450", 750.0, 35.0, 6),
                new Caminhao("TRK-0003", "Mercedes Accelo", 400.0, 10.0, 2),
                new Caminhao("TRK-0004", "VW Meteor", 780.0, 38.0, 6),
                new Caminhao("TRK-0005", "Iveco Daily", 350.0, 5.0, 2)
        );
        veiculosIniciais.forEach(v -> veiculos.cadastrar(v)); //adicionando todos os veiculosIniciais a lista veiculos

        //exibindo Lista incial na tela ao meu usuário:
        System.out.println("=== VEICULOS DISPONÍVEIS ( INICIAIS ) ===");
        veiculos.listarVeiculos();
    }
}