package sistema;

/**
 * Parte 5 – Classe Principal LocadoraApp (main)
 * Simule o sistema de uma locadora. Utilize try-catch-finally para garantir robustez.
 * Configuração Inicial:
 * Crie um objeto Frota<Veiculo>.
 * Crie uma lista inicial (usando Arrays.asList) com 5 carros e 5 caminhões fictícios e adicione-os à frota.
 * Exiba a lista inicial usando o método da classe Frota.
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

    }
}