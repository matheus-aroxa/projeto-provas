package services;

import java.util.ArrayList;
import java.util.List;

import Exceptions.ArrayIsFullException;
import Exceptions.InvalidIdException;
import Exceptions.ObjectAlreadyExistsException;
import Exceptions.QuestaoNotExistsException;
import Exceptions.RequiredArgumentIsNullException;
import models.provas.Prova;
import models.provas.Questao;
import repos.RepositorioQuestoes;

public class QuestaoService {

    private RepositorioQuestoes repositorio = RepositorioQuestoes.getInstance(10);

    public void criarQuestao(Questao questao) {

        if (questao.getEnunciado() == null || questao.getEnunciado().isEmpty()
                || questao.getAlternativas() == null) {
            throw new RequiredArgumentIsNullException();
        }

        for (String alternativa : questao.getAlternativas()) {
            if (alternativa == null || alternativa.isEmpty()) {
                throw new RequiredArgumentIsNullException();
            }
        }

        if (repositorio.getContador().get() >= 10) {
            throw new ArrayIsFullException();
        }

        if (repositorio.procurar(questao.getId()) != -1) {
            throw new ObjectAlreadyExistsException("Já existe uma questão com este ID");
        }

        repositorio.criarQuestao(questao);

        for (Questao q : repositorio.getQuestoes()) {
            System.out.println(q);
        }
        System.out.println("---------------------------");
    }

    public void editarQuestao(Questao questao) {
        if (questao == null) {
            throw new RequiredArgumentIsNullException();
        }

        if (repositorio.procurar(questao.getId()) == -1) {
            throw new QuestaoNotExistsException();
        }

        if (questao.getEnunciado() == null || questao.getEnunciado().isEmpty()
                || questao.getAlternativas() == null) {
            throw new RequiredArgumentIsNullException();
        }

        for (String alternativa : questao.getAlternativas()) {
            if (alternativa.isEmpty()) {
                throw new RequiredArgumentIsNullException();
            }
        }

        repositorio.editar(questao);
    }

    public void removerQuestao(int id) {
        if (id <= 0) {
            throw new InvalidIdException();
        }

        if (repositorio.procurar(id) == 1) {
            throw new QuestaoNotExistsException();
        }

        repositorio.remover(id);
        for (Questao u : repositorio.getQuestoes()) {
            System.out.println(u);
        }

    }

    public Questao[] getQuestoesProva(int idProva) {
        List<Questao> resultado = new ArrayList<>();
        for (Questao q : repositorio.listar()) {
            if (q != null && q.getIdProva() == idProva) {
                resultado.add(q);
            }
        }
        return resultado.toArray(new Questao[0]);
    }

    public List<Questao> findAll() {
        return repositorio.findAll();
    }
}
