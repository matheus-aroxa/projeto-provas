package services;

import Exceptions.*;
import models.Turma;
import models.provas.CartaoResposta;
import models.provas.Prova;
import models.provas.Questao;
import repos.RepositorioProvas;
import repos.RepositorioUsuarios;

import java.time.LocalDateTime;
import java.time.Period;

public class ProvaService {

    RepositorioProvas repositorio = RepositorioProvas.getInstance(10);

    public void adicionar(String titulo, String descricao, LocalDateTime dataAplicacao, Period duracao, boolean isRemoto, Turma[] turmas, Questao[] questoes, CartaoResposta[] respostas) {

        if(titulo == null || dataAplicacao == null || duracao == null || turmas == null || questoes == null || respostas == null){
            throw new RequiredArgumentIsNullException();
        }

        if(repositorio.getProvaById(repositorio.getContador().get() + 1) != -1){
            //throw new ;
        }

        if(repositorio.getContador().get() >= 10){
            throw new ArrayIsFullException();
        }

        repositorio.adicionar(titulo, descricao, dataAplicacao, duracao, isRemoto, turmas, questoes, respostas);
    }

    public void deletar(int id) {

      if(id <= 0){
          throw new InvalidIdException();
      }

      if(repositorio.getProvaById(id) != -1){
          //throw new ;
      }
    }

    public void getProvaById(int id) {
        if(id <= 0){
            throw new InvalidIdException();
        }
        repositorio.getProvaById(id);
    }
}
