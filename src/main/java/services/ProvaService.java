package services;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import models.provas.Prova;
import repos.RepositorioProvas; // Importe o repositório

public class ProvaService {

    // O serviço conversa diretamente com o repositório
    private RepositorioProvas repositorioProvas = RepositorioProvas.getInstance(10);

    public void criarProva(Prova prova) {
        if (prova == null || prova.getTitulo() == null || prova.getTitulo().isEmpty()) {
            // Lançar uma exceção apropriada aqui
            throw new IllegalArgumentException("Prova ou título não pode ser nulo/vazio.");
        }
        // Lógica para gerar ID, se necessário, e salvar
        repositorioProvas.criarProva(prova); // Assumindo que o repositório tem um método criar()
    }

    public void editarProva(Prova prova) {
        // Lógica para editar a prova no repositório
        repositorioProvas.editarProva(prova);
    }

    public List<Prova> listarTodas() {
        // Retorna uma lista de todas as provas não nulas
        return Arrays.stream(repositorioProvas.getProvas())
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public Prova buscarPorId(int id) {
        // Lógica para buscar uma prova específica
        return repositorioProvas.buscarPorId(id);
    }
}