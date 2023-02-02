package alura.com.br.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import alura.com.br.R;
import alura.com.br.dao.AlunoDAO;
import alura.com.br.model.Aluno;

public class ListaAlunosActivity extends AppCompatActivity  {

    private static final String TITULO_APPBAR = "Lista de Alunos";
    private final AlunoDAO alunoDAO = new AlunoDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(TITULO_APPBAR);
        setContentView(R.layout.activity_lista_alunos);
        this.handleClickCreateAluno();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mostraAlunos();
    }
    private void handleClickCreateAluno() {
        FloatingActionButton addAlunoButton = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        addAlunoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreFormulario();
            }
        });
    }
    private void mostraAlunos() {
        ListView listaAlunosView = findViewById(R.id.activity_lista_alunos_listview);
        listaAlunosView.setAdapter(new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, alunoDAO.todos()));
    }
    private void abreFormulario() {
        startActivity(new Intent(
                this, FormularioAlunoActivity.class
        ));
    }

}
