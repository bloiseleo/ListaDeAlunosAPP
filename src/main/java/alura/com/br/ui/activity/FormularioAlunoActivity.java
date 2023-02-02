package alura.com.br.ui.activity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import alura.com.br.R;
import alura.com.br.dao.AlunoDAO;
import alura.com.br.model.Aluno;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormularioAlunoActivity extends AppCompatActivity {
    private static final String TITULO_APPBAR = "Novo Aluno";
    private EditText fieldNome;
    private EditText fieldEmail;
    private EditText fieldTelefone;
    private final AlunoDAO alunoDAO = new AlunoDAO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(TITULO_APPBAR);
        setContentView(R.layout.activity_formulario_aluno);
        inicializaCampos();
        this.handleCreateAluno();
    }
    private void inicializaCampos() {
        fieldNome = findViewById(R.id.activity_formulario_aluno_nome);
        fieldEmail = findViewById(R.id.activity_formulario_aluno_email);
        fieldTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
    }
    private void handleCreateAluno() {
        Button saveButton = findViewById(R.id.activity_formulario_aluno_botao_salvar);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Aluno aluno = criaAluno();
                salvaAluno(aluno);
            }
        });
    }
    @NonNull
    private Aluno criaAluno() {
        String nome = fieldNome.getText().toString();
        String telefone = fieldTelefone.getText().toString();
        String email = fieldEmail.getText().toString();
        Aluno aluno = new Aluno(nome, telefone, email);
        return aluno;
    }
    private void salvaAluno(Aluno aluno) {
        alunoDAO.salva(aluno);
        finish();
    }
}