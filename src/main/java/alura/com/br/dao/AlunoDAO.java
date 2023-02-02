package alura.com.br.dao;

import java.util.ArrayList;
import java.util.List;

import alura.com.br.model.Aluno;

public class AlunoDAO {
    private static final List<Aluno> alunos = new ArrayList<Aluno>();
    public void salva(Aluno aluno) {
        alunos.add(aluno);
    }
    public ArrayList<Aluno> todos() {
        return new ArrayList<Aluno>(alunos);
    }
}
