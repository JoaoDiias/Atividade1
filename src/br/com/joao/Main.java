
package br.com.joao;

import br.com.joao.objetos.Aluno;
import br.com.joao.objetos.Disciplina;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {


    public static void main(String[] args) throws ParseException {
       List <Disciplina> materias = new ArrayList<>();
       
        do {  
       String nome;
       String departamento;
       char status;
       
       nome = JOptionPane.showInputDialog("Informe o nome da disciplina ");
       departamento = JOptionPane.showInputDialog("Qual o departamento: ");
       status = JOptionPane.showInputDialog("Status [A]tivo ou [I]nativo: ").charAt(0);
       materias.add(new Disciplina(nome, departamento, status));
          
        } while ((JOptionPane.showConfirmDialog(null, "Deseja continuar? ")) == 0);
        
       String disciplinasDisponiveis = "";
        for (Disciplina materia : materias) {
          disciplinasDisponiveis +="\n"+ materias.lastIndexOf(materia)+ " " + materia.getNome();
        }
        JOptionPane.showMessageDialog(null, disciplinasDisponiveis);
        
        
       List <Aluno> alunos = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
       
        do { 
            int matricula;
            Date dataMatricula;
            String nome;
            String rg;
            String cpf;
            Date dataNascimento;
            int idade;
            
            nome = JOptionPane.showInputDialog("Informe o nome do aluno: ");
            rg = JOptionPane.showInputDialog("Informe o RG do aluno: ");
            matricula = Integer.parseInt(JOptionPane.showInputDialog("Informe os números da matrícula: "));
            dataNascimento = sdf.parse(JOptionPane.showInputDialog("Qual sua data de nascimento: "));
            dataMatricula = sdf.parse(JOptionPane.showInputDialog("Informe a data de Matrícula: "));
            alunos.add(new Aluno(matricula,dataMatricula,dataNascimento));
        } while (JOptionPane.showConfirmDialog(null, "Deseja Continuar? ")==0);
          for (Aluno aluno : alunos) {
              alunosMatriculados +="\n"+ alunos.lastIndexOf(matriculas)+ " " + matriculas.getNome();
            
        }
 
    }
    
}
