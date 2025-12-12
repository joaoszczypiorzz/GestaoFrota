package sistema;

import java.util.ArrayList;
import java.util.List;

public class Frota<T extends Veiculo> {
    protected List<T> lista;

    //Constructor da Classe:
    public Frota(){
        this.lista = new ArrayList<>(); //Definindo a minha variavel Lista como uma um arraylist
    }

    public void cadastrar(T Veiculo){
        lista.add(Veiculo);
    }

    public T buscarPorPlaca(String placa){
        return lista.stream()
                .filter(v -> v.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Veículo não encontrado: " + placa));
    }

    public void listarVeiculos(){
        if(lista.isEmpty()){
            System.out.println("Nenhum Veiculo cadastrado!");
        }else {
            for(T Veiculo: lista){
                System.out.println(Veiculo);
            }
        }
    }

    public List<T> getVeiculos() {
        return lista;
    }
}