package br.com.joao;

import br.com.joao.objetos.Aluno;
import br.com.joao.objetos.Disciplina;
import br.com.joao.objetos.Professor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) throws ParseException {
        List<Disciplina> materias = new ArrayList<>();
        List<Professor> prof = new ArrayList<>();
        List<Aluno> alunos = new ArrayList<>();
        int esc = 0;

        do {
            esc = Integer.parseInt(JOptionPane.showInputDialog("Escolha:"
                    + "\n 1: cadastro de Disciplina"
                    + "\n 2: cadastro de professor"
                    + "\n 3: cadastro de aluno"
                    + "\n 4: consulta de disciplina"
                    + "\n 5: consulta de professor"
                    + "\n 6: consulta de aluno"
                    + "\n 7: Sair"));
            switch (esc) {
                case 1: {

                    do {
                        String nome;
                        String departamento;
                        char status;

                        nome = JOptionPane.showInputDialog("Informe o nome da disciplina ");
                        departamento = JOptionPane.showInputDialog("Qual o departamento: ");
                        status = JOptionPane.showInputDialog("Status [A]tivo ou [I]nativo: ").charAt(0);
                        materias.add(new Disciplina(nome, departamento, status));

                    } while ((JOptionPane.showConfirmDialog(null, "Deseja continuar? ")) == 0);
                    break;
                }
                case 2: {
                    do {
                        int cargaHoraria;
                        float valorHora;
                        float salario = 0;
                        String nome;
                        String rg;
                        String cpf;
                        int idade = 0;
                        Date dataNascimento;
                        SimpleDateFormat conversor = new SimpleDateFormat("dd/MM/yyyy");

                        nome = JOptionPane.showInputDialog("Informe seu nome: ");
                        rg = JOptionPane.showInputDialog("Informe seu RG: ");
                        cpf = JOptionPane.showInputDialog("Informe seu CPF: ");
                        dataNascimento = conversor.parse(JOptionPane.showInputDialog("Informe sua data de Nascimento: "));
                        cargaHoraria = Integer.parseInt(JOptionPane.showInputDialog("Informe sua Carga Hóraria: "));
                        valorHora = Float.parseFloat(JOptionPane.showInputDialog("Informe o valor da hora: "));

                        prof.add(new Professor(cargaHoraria, valorHora, salario, nome, rg, cpf, dataNascimento, idade));

                        if (JOptionPane.showConfirmDialog(null, "Professor já trabalha em alguma disciplina? ") == 0) {
                            do {
                                String disciplinasExistentes = "";
                                for (Disciplina materia : materias) {
                                    disciplinasExistentes += "\n" + materias.indexOf(materia) + " " + materia.getNome();
                                }
                                int escolhaDisciplina = Integer.parseInt(JOptionPane.showInputDialog("Informe qual disciplina: \n" + disciplinasExistentes));
                                prof.get(prof.size() - 1).getDisciplinas().add(materias.get(escolhaDisciplina));
                            } while ((JOptionPane.showConfirmDialog(null, "professor possui outra disciplina?")) == 0);
                        }
                    } while ((JOptionPane.showConfirmDialog(null, "Deseja Continuar? ")) == 0);
                    break;
                }
                case 3: {
                    do {  
                        int matricula;
                        Date dataMatricula;
                        String nome;
                        String rg;
                        String cpf;
                        Date dataNascimento;
                        int idade = 0;
                        
                        SimpleDateFormat conversor = new SimpleDateFormat("dd/MM/yyyy");
                        
                        nome = JOptionPane.showInputDialog("Informe o nome do aluno: ");
                        rg = JOptionPane.showInputDialog("Informe o RG do aluno: ");
                        cpf = JOptionPane.showInputDialog("Informe o CPF do aluno: ");
                        dataNascimento = conversor.parse(JOptionPane.showInputDialog("informe a data de nascimento do aluno: "));
                        dataMatricula = conversor.parse(JOptionPane.showInputDialog("Informe a data de matricula do aluno: "));
                        matricula = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de matrícula do aluno: "));
                        alunos.add(new Aluno(matricula, dataMatricula, nome, rg, cpf, dataNascimento, idade));
                        
                    } while ((JOptionPane.showConfirmDialog(null, "Deseja Continuar? ")) == 0);
                    break;
                }
                case 4: {
                    JOptionPane.showInputDialog(materias.toString());
                }
                break;
                case 5: {
                    JOptionPane.showInputDialog(prof.toString());
                }
                break;
                case 6: {
                    JOptionPane.showInputDialog(alunos.toString());
                }
            }
        } while (esc != 7);
    }

}
