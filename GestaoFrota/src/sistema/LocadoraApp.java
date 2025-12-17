package sistema;


import java.util.List;
import java.util.Scanner;
import java.util.*;

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

        System.out.println("=== CADASTRO DE NOVO VEICULO ===");
        try{
            System.out.println("Informe O tipo de Veiculo que deseja cadastrar (C - Carro / T Caminhão )");
            String userchoice = sc.nextLine();
            if(!userchoice.equalsIgnoreCase("c") && !userchoice.equalsIgnoreCase("t")){  //verificação caso usuário digitar input inválido
                throw new InputMismatchException();
            }

            System.out.println("Informe um novo número de Placa: ");
            String novaPlaca = sc.nextLine();
            Veiculo placaVerificar = veiculos.verificarExiste(novaPlaca);
            if(placaVerificar != null){    //Verifica se a placa digitada já existe ou não, caso exista retorna erro
                throw new IllegalArgumentException();
            }

            System.out.println("Informe o Modelo do Veiculo: ");
            String modelo = sc.nextLine();

            System.out.println("Informe o Valor da Diária do Veiculo: ");
            double valorDiaria = sc.nextDouble();
            sc.nextLine(); //puland Buffer
            if(valorDiaria < 0 ){  //Retorna erro caso valor da diára for menor do que zero
                throw new ArithmeticException();
            }

            if(userchoice.equalsIgnoreCase("c")){
                System.out.println("Informe quantos lugares o carro possui: ");
                int capacidade = sc.nextInt();
                sc.nextLine(); //Pulando Buffer de Leitura
                veiculos.cadastrar(new Carro(novaPlaca,modelo, valorDiaria,capacidade));
            }else {
                System.out.println("Informe a capacidade de Carga: ");
                double capacidadeDeCarga = sc.nextDouble();
                sc.nextLine(); //pulando Buffer

                System.out.println("Informe a quantidade de Eixos deste caminhão: ");
                int qtdEixos = sc.nextInt();
                sc.nextLine(); //pulando Buffer
                veiculos.cadastrar(new Caminhao(novaPlaca,modelo,valorDiaria,capacidadeDeCarga,qtdEixos));
            }

        }catch (InputMismatchException e ){
            System.out.println(e);
            System.out.println("ERRO: Tipo de Veiculo digitado Inválido!");
        }catch (IllegalArgumentException e){
            System.out.println(e);
            System.out.println("ERRO: Placa informada já cadastrada no sistema!");
        }catch (ArithmeticException e){
            System.out.println("ERRO: Valor da Diária Deve ser maior que Zero!");
        }finally {
            System.out.println("=== CATALOGO DE VEICULOS ATUALIZADO ===");
            veiculos.listarVeiculos();
        }

        System.out.println("=== ALUGUEL DE VEICULOS ===");
        try{
            System.out.println("Informe a Placa do Veiculo que deseja Alugar: ");
            String inputPlaca = sc.nextLine();
            Veiculo aluguelDesejado = veiculos.buscarPorPlaca(inputPlaca);

            System.out.println("Informe a quantidade de diarias: ");
            int qtdDiarias = sc.nextInt();
            sc.nextLine(); //pulando Buffer
            aluguelDesejado.alugar(qtdDiarias);

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        System.out.println("=== REAJUSTE DE PREÇO ===");
        try{

            System.out.println("Informe A placa do Veiculo que deseja Aplicar o Reajuste de preço: ");
            String placaReajuste = sc.nextLine();
            Veiculo findPlaca = veiculos.buscarPorPlaca(placaReajuste);
            System.out.println("Informe o Percentual de Aumento que deseja aplicar: ");
            double percentual = sc.nextDouble();
            sc.nextLine(); //pulando Buffer
            if(percentual < 0){
                throw new Exception();
            }
            findPlaca.aplicarReajuste(percentual);
            System.out.println("\nInformações do Veiculo Reajustado: " + findPlaca );


        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("ERRO: Percentual deve ser maior que Zero!");
        }finally {
            System.out.println("=== LISTA FINAL DE VEICULOS ===");
            veiculos.listarVeiculos();
            System.out.println("OBRIGADO POR UTILIZAR MEU SISTEMA!");
            System.out.println("SISTEMA ENCERRANDO...");
            sc.close(); //fechado Scanner
        }
    }
}