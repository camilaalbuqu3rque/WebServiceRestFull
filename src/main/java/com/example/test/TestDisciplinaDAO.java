package com.example.test;

import com.example.dao.DisciplinaDAO;
import com.example.model.Disciplina;

import java.util.List;

public class TestDisciplinaDAO {

    public static void main(String[] args) {
        DisciplinaDAO dao = new DisciplinaDAO();

        // Teste a) Listar todas as disciplinas
        System.out.println("Disciplinas cadastradas:");
        List<Disciplina> disciplinas = dao.listarDisciplinas();
        for (Disciplina d : disciplinas) {
            System.out.println(d.getId() + " - " + d.getNome() + " - " + d.getDescricao());
        }
        System.out.println();

        // Teste b) Procurar uma disciplina pela chave primária
        System.out.println("Procurando disciplina com ID 1:");
        Disciplina disciplina = dao.procurarDisciplina(1); // Altere o ID conforme necessário
        if (disciplina != null) {
            System.out.println("Disciplina encontrada: " + disciplina.getNome());
        } else {
            System.out.println("Disciplina não encontrada.");
        }
        System.out.println();

        // Teste c) Inserir uma nova disciplina
        System.out.println("Inserindo nova disciplina:");
        Disciplina novaDisciplina = new Disciplina();
        novaDisciplina.setNome("POO");
        novaDisciplina.setDescricao("Estudo os conceitos e técnicas para projetar programas usando classes e objetos.");
        dao.inserirDisciplina(novaDisciplina);
        System.out.println("Disciplina inserida: " + novaDisciplina.getNome());
        System.out.println();

        // Teste d) Alterar os dados da disciplina
        System.out.println("Alterando disciplina com ID 1:");
        Disciplina disciplinaParaAlterar = new Disciplina();
        disciplinaParaAlterar.setId(1); // Altere o ID conforme necessário
        disciplinaParaAlterar.setNome("Biologia");
        disciplinaParaAlterar.setDescricao("Estudo da vida e dos organismos.");
        dao.alterarDisciplina(disciplinaParaAlterar);
        System.out.println("Disciplina alterada para: " + disciplinaParaAlterar.getNome());
        System.out.println();

        // Teste e) Excluir a disciplina pela chave primária
        System.out.println("Excluindo disciplina com ID 1:");
        dao.excluirDisciplina(1); // Altere o ID conforme necessário
        System.out.println("Disciplina excluída.");
        System.out.println();

        // Listar todas as disciplinas após as operações
        System.out.println("Disciplinas cadastradas após operações:");
        disciplinas = dao.listarDisciplinas();
        for (Disciplina d : disciplinas) {
            System.out.println(d.getId() + " - " + d.getNome() + " - " + d.getDescricao());
        }
    }
}